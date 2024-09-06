package com.stopping.pojo.dto;

import com.stopping.model.ExcelFieldConfig;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * excel表信息
 * @author stopping
 * */
@Data
@Accessors(chain = true)
public class ExcelTableInfoDTO {
    /**
     * 表id
     * */
    private Integer tableId;
    /**
     * excel表名称
     * */
    private String tableName;
    /**
     * 数据库表名称
     * */
    private String dbTableName;

    /**
     * 字段配置信息 key映射excel表格列坐标，val 列配置
     * */
    private List<ExcelFieldInfoDTO> fieldConfigs;
}
