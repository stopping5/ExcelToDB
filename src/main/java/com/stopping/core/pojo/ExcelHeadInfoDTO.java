package com.stopping.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表头读取相关信息
 * @author stopping
 */
@Data
@AllArgsConstructor
public class ExcelHeadInfoDTO {
    /**
     * EXCEL映射数据库表名称
     */
    private String tableName;

    /**
     * Excel全局唯一ID
     */
    private String tableId;
}
