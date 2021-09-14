package cn.gov.modules.system.rest;

import cn.gov.annotation.Log;
import cn.gov.exception.BadRequestException;
import cn.gov.modules.system.domain.Organization;
import cn.gov.modules.system.service.OrganizationService;
import cn.gov.modules.system.service.dto.JobQueryCriteria;
import cn.gov.modules.system.service.dto.OrganizationQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liushaoqiang
 * @Description TODO
 * @date 2021/9/14
 */

@RestController
@RequiredArgsConstructor
@Api(tags = "系统：单位管理")
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    private static final String ENTITY_NAME = "OrganizationMapper";


    @ApiOperation("查询单位")
    @GetMapping
    @PreAuthorize("@el.check('organization:list','user:list')")
    public ResponseEntity<Object> query(OrganizationQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(organizationService.queryAll(criteria, pageable),HttpStatus.OK);
    }

    @Log("新增单位")
    @ApiOperation("新增单位")
    @PostMapping
    public ResponseEntity<Void> create(@Validated @RequestBody Organization resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        organizationService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改单位")
    @ApiOperation("修改单位")
    @PutMapping
    public ResponseEntity<Void> update(@Validated(Organization.Update.class) @RequestBody Organization resources){
        organizationService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
