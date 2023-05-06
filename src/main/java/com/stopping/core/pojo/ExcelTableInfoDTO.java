package com.stopping.core.pojo;

import lombok.Data;

/**
 * excel上传表格信息DTO
 */

@Data
public class ExcelTableInfoDTO {
    /**
     * 全局唯一ID
     */
    private String excelId;
    /**
     * 操作类型名称
     */
    private String operateName;

    /**
     * 数据库表名
     */
    private String tableName;

    /**
     * excel表格名称
     */
    private String excelTableName;

    /**
     * 配置状态：0-失效、1-生效
     */
    private Integer status;

    /**
     * excel列数
     */
    private Integer colNum;

    /**
     * 模版url
     */
    private String modelUrl;
}
