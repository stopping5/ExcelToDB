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
@TableName("table_field_relation")
public class TableFieldRelation {
    /**
    * 主键
    */
    @TableId
    @TableField("id")
    private Integer id;
    /**
    * 表id - 映射excel_table_config#id
    */
    @TableField("table_id")
    private Integer tableId;
    /**
    * 字段id - 映射excel_field_config#id
    */
    @TableField("field_Id")
    private Integer fieldId;
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