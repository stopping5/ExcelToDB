package com.stopping.model;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;
import java.util.Date;
/**
* 表字段映射关系表
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
    @TableField("field_id")
    private Integer fieldId;
    /**
    *   创建时间
    */
    @TableField("created_at")
    private LocalDateTime createdAt;
    /**
    *   更新时间
    */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}