package com.stopping.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stopping.model.TableFieldRelation;
import com.stopping.service.TableFieldRelationService;

/**
 * 
 */
@RestController
@RequestMapping("/tableFieldRelation")
@Api(tags = "")
public class TableFieldRelationController {
    @Autowired
    private TableFieldRelationService tableFieldRelationService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个")
    public TableFieldRelation findById(@ApiParam("ID") @PathVariable("id") Integer id) {
        return tableFieldRelationService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    public IPage<TableFieldRelation> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                                @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return tableFieldRelationService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("新增")
    public void insert(@RequestBody TableFieldRelation tableFieldRelation) {
        tableFieldRelationService.insert(tableFieldRelation);
    }

    @PutMapping
    @ApiOperation("修改")
    public void update(@RequestBody TableFieldRelation tableFieldRelation) {
        tableFieldRelationService.update(tableFieldRelation);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个")
    public void deleteById(@ApiParam("ID") @PathVariable("id") Integer id) {
        tableFieldRelationService.deleteById(id);
    }
}
