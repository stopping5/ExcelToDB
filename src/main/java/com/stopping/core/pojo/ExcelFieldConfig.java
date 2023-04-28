package com.stopping.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Excel对应字段配置信息
 */
@Data
@AllArgsConstructor
public class ExcelFieldConfig {
    /**
     * 表头字段名
     * */
    private String excelField;
    /**
     * 映射数据库字段名
     * */
    private String dbField;
    /**
     * 是否必填：0-否，1-是
     * */
    private Integer notEntry;
    /**
     * 字段类型：0-单选，1-多选
     * */
    private Integer fileType;
}
