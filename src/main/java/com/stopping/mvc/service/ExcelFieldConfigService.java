package com.stopping.mvc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stopping.core.pojo.ExcelFieldConfigDTO;
import com.stopping.mvc.pojo.entity.ExcelFieldConfig;

/**
 * <p>
 * 表格字段配置表 服务类
 * </p>
 *
 * @author 
 * @date 2023-05-03
 */
public interface ExcelFieldConfigService extends IService<ExcelFieldConfig> {
    /**
     * 批量保存Excel字段配置
     * @param excelFieldConfig
     */
    void batchSave(ExcelFieldConfigDTO excelFieldConfig);
}
