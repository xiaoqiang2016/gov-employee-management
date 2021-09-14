package cn.gov.modules.system.service;

import cn.gov.modules.system.domain.Organization;
import cn.gov.modules.system.service.dto.OrganizationQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */
public interface OrganizationService {

    /**
     * 创建
     * @param resources /
     * @return /
     */
    void create(Organization resources);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    void update(Organization resources);


    /**
     * 分页查询
     * @return /
     */
    Map<String,Object> queryAll(OrganizationQueryCriteria criteria, Pageable pageable);
}
