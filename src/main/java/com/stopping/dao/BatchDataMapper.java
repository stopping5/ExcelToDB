package com.stopping.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stopping.model.ExcelFieldConfig;
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
public interface BatchDataMapper extends BaseMapper<Object> {
    /**
     * 自定义批量插入数据
     * @param tableName 表名
     * @param data 数据
     * @param param 参数
     */
    void batchInsert(@Param("tableName")String tableName,@Param("data")String data,@Param("param")String param);
}
