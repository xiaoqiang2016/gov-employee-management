package cn.gov.modules.system.service.impl;

import cn.gov.exception.EntityExistException;
import cn.gov.modules.system.domain.Organization;
import cn.gov.modules.system.repository.OrganizationRepository;
import cn.gov.modules.system.service.OrganizationService;
import cn.gov.modules.system.service.dto.OrganizationQueryCriteria;
import cn.gov.modules.system.service.mapstruct.OrganizationMapper;
import cn.gov.utils.PageUtil;
import cn.gov.utils.QueryHelp;
import cn.gov.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "organization")
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;


    /**
     * 创建单位
     * @param resources /
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Organization resources) {
        Organization  organization = organizationRepository.findByName(resources.getName());
        if(organization != null){
            throw new EntityExistException(Organization.class,"name",resources.getName());
        }
        organizationRepository.save(resources);
    }

    /**
     * 修改单位
     * @param resources /
     */
    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(Organization resources) {
        Organization organization = organizationRepository.findById(resources.getId()).orElse(new Organization());
        Organization  organizationOld = organizationRepository.findByName(resources.getName());
        if(organizationOld != null && !organizationOld.getId().equals(resources.getId())){
            throw new EntityExistException(Organization.class,"name",resources.getName());
        }
        ValidationUtil.isNull( organization.getId(),"OrganizationMapper","id",resources.getId());
        resources.setId(organization.getId());
        organizationRepository.save(resources);
    }

    /**
     * 分页查询
     * @param criteria
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryAll(OrganizationQueryCriteria criteria, Pageable pageable) {
        Page<Organization> page = organizationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(organizationMapper::toDto).getContent(),page.getTotalElements());
    }
}
