package cn.gov.modules.system.repository;

import cn.gov.modules.system.domain.Dept;
import cn.gov.modules.system.domain.Job;
import cn.gov.modules.system.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {
    /**
     * 根据名称查询
     * @param name 名称
     * @return /
     */
    Organization findByName(String name);

}
