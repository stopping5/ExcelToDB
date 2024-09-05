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
import com.stopping.model.ExcelTableConfig;
import com.stopping.service.ExcelTableConfigService;

/**
 * 
 */
@RestController
@RequestMapping("/excelTableConfig")
@Api(tags = "")
public class ExcelTableConfigController {
    @Autowired
    private ExcelTableConfigService excelTableConfigService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个")
    public ExcelTableConfig findById(@ApiParam("ID") @PathVariable("id") Integer id) {
        return excelTableConfigService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    public IPage<ExcelTableConfig> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                                @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return excelTableConfigService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("新增")
    public void insert(@RequestBody ExcelTableConfig excelTableConfig) {
        excelTableConfigService.insert(excelTableConfig);
    }

    @PutMapping
    @ApiOperation("修改")
    public void update(@RequestBody ExcelTableConfig excelTableConfig) {
        excelTableConfigService.update(excelTableConfig);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个")
    public void deleteById(@ApiParam("ID") @PathVariable("id") Integer id) {
        excelTableConfigService.deleteById(id);
    }
}
