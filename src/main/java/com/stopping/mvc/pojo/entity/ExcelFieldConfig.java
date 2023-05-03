package com.stopping.mvc.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 表格字段配置表
 * </p>
 *
 * @author 
 * @date 2023-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("im_excel_field_config")
public class ExcelFieldConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 数据库字段名
     */
    private String tableFieldName;

    /**
     * excel字段名
     */
    private String fieldName;

    /**
     * 配置状态：0-失效、1-生效
     */
    private Integer status;

    /**
     * 是否是hash判断字段
     */
    private Integer keyColumn;

    /**
     * 字段状态:0-非必填，1-必填
     */
    private Integer mustFill;

    /**
     * 字段内容类型:0-单选，1-多选
     */
    private Integer fieldContentType;

    /**
     * 是否校验表头
     */
    private Integer checkType;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;


}
