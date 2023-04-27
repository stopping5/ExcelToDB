package com.stopping.core.pojo;

import lombok.Data;

/**
 * 表头读取相关信息
 * @author stopping
 */
@Data
public class ExcelHeadInfoDTO {
    /**
     * EXCEL映射数据库表名称
     */
    private String tableName;
}
