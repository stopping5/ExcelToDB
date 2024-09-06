package com.stopping.model;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;
import java.util.Date;
/**
* 表配置信息表
*/
@Data
@TableName("excel_table_config")
public class ExcelTableConfig {
    /**
    * 主键
    */
    @TableId
    @TableField("id")
    private Integer id;
    /**
    * excel字段名
    */
    @TableField("excel_table_name")
    private String excelTableName;
    /**
    * 数据库表名
    */
    @TableField("db_table_name")
    private String dbTableName;
    /**
    * 模板url
    */
    @TableField("model_url")
    private String modelUrl;
    /**
    * 删除状态：0-未删除、1-删除
    */
    @TableField("del_flag")
    private boolean delFlag;
    /**
    * 
    */
    @TableField("created_at")
    private LocalDateTime createdAt;
    /**
    * 
    */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}