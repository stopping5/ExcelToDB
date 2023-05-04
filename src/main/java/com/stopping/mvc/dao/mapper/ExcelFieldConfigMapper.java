package com.stopping.mvc.dao.mapper;

import com.stopping.mvc.pojo.entity.ExcelFieldConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
     * 批量保存语句
     * @param excelFieldConfigs
     */
    void saveBatch(List<ExcelFieldConfig> excelFieldConfigs);
}
