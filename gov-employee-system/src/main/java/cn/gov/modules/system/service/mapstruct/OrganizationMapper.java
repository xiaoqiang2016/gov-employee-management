package cn.gov.modules.system.service.mapstruct;

import cn.gov.base.BaseMapper;
import cn.gov.modules.system.domain.Job;
import cn.gov.modules.system.domain.Organization;
import cn.gov.modules.system.service.dto.JobDto;
import cn.gov.modules.system.service.dto.OrganizationDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper  extends BaseMapper<OrganizationDto, Organization> {
}
