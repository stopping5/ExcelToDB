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
 * 表格配置表
 *
 * @author stopping
 * @date 2023-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("im_excel_table_config")
public class ExcelTableConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;


}
