package com.stopping.pojo.dto;

import com.stopping.model.ExcelFieldConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExcelFieldInfoDTO extends ExcelFieldConfig {
    /**
     * 对应表头的坐标
     */
    private Integer index;
}
