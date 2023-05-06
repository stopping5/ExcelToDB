package com.stopping.mvc.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import com.stopping.mvc.service.ExcelTableConfigService;

/**
 * 表格配置表前端控制器
 *
 * @author stopping
 * @date 2023-05-06
 * @menu 业务模块
 */
@AllArgsConstructor
@RestController
@RequestMapping("/excel-table-config")
public class ExcelTableConfigController {

    private final ExcelTableConfigService excelTableConfigService;

}
