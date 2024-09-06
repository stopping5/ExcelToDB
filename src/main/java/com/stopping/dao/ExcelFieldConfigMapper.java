package com.stopping.dao;

import com.stopping.model.ExcelFieldConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 表格字段配置表 Mapper 接口
 * </p>
 *
 * @author 
 * @date 2023-05-03
 */
@Mapper
public interface ExcelFieldConfigMapper extends BaseMapper<ExcelFieldConfig> {
    /**
     * 通过tableId获取表格字段配置
     * @param tableId tableid
     * @return 表格字段配置集合
     */
    List<ExcelFieldConfig> findConfigByTableId(@Param("tableId") Integer tableId);
}
