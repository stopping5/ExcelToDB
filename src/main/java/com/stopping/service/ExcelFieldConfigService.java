package com.stopping.service;

import com.stopping.model.ExcelFieldConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
     * 通过tableId查询表字段的配置信息
     * @param tableId tableid
     * @return 配置信息集合
     */
    List<ExcelFieldConfig> queryExcelFieldConfigInfoByTableId(Integer tableId);
}
