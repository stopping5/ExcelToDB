package com.stopping.model;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;
/**
* 
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
    * 数据库字段名
    */
    @TableField("excel_table_name")
    private String excelTableName;
    /**
    * excel字段名
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
    private Date createdAt;
    /**
    * 
    */
    @TableField("updated_at")
    private Date updatedAt;
}