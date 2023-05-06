package com.stopping.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Excel对应字段配置信息
 */
@Data
@AllArgsConstructor
public class ExcelFieldConfigDTO {
    /**
     * 表头字段名
     * */
    private String fieldName;
    /**
     * 映射数据库字段名
     * */
    private String tableFieldName;
    /**
     * 是否必填：0-否，1-是
     * */
    private Integer mustFill;
    /**
     * 字段类型：0-单选，1-多选
     * */
    private Integer fieldContentType;
    /**
     * 是否是hash判断字段
     */
    private Integer keyColumn;
}
