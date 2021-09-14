package cn.gov.modules.system.service.dto;

import cn.gov.base.BaseDTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */

@Getter
@Setter
public class OrganizationDto extends BaseDTO implements Serializable {

    private Long id;


    private String name;


    private Integer unitType;


    private Integer administrativeFirstCount;


    private Integer administrativeSecendCount;


    private Integer careerFirstCount;


    private Integer careerSecendCount;


    private String job;

    private Integer isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrganizationDto organizationDto = (OrganizationDto) o;
        return Objects.equals(id, organizationDto.id) &&
                Objects.equals(name, organizationDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
