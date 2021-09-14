package cn.gov.modules.system.domain;

import cn.gov.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */
@Entity
@Getter
@Setter
@Table(name="sys_organization")
public class Organization extends BaseEntity implements Serializable {
    @Id
    @Column(name = "organization_id")
    @NotNull(groups = Update.class)
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "单位名称")
    private String name;

    @NotNull
    @ApiModelProperty(value = "单位类型")
    private Integer unitType;

    @NotNull
    @ApiModelProperty(value = "行政正职数")
    private Integer administrativeFirstCount;

    @NotNull
    @ApiModelProperty(value = "行政副职数")
    private Integer administrativeSecendCount;

    @NotNull
    @ApiModelProperty(value = "事业正职数")
    private Integer careerFirstCount;

    @NotNull
    @ApiModelProperty(value = "事业副职数")
    private Integer careerSecendCount;

    @NotNull
    @ApiModelProperty(value = "职务")
    private String job;

    @NotNull
    @ApiModelProperty(value = "是否闪促")
    private Integer isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(id, organization.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
