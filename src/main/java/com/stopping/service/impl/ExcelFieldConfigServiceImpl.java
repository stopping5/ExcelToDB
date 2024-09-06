package com.stopping.service.impl;

import com.stopping.model.ExcelFieldConfig;
import com.stopping.dao.ExcelFieldConfigMapper;
import com.stopping.service.ExcelFieldConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 表格字段配置表 服务实现类
 * </p>
 *
 * @author 
 * @date 2023-05-03
 */
@Service
public class ExcelFieldConfigServiceImpl extends ServiceImpl<ExcelFieldConfigMapper, ExcelFieldConfig> implements ExcelFieldConfigService {

    @Autowired
    private ExcelFieldConfigMapper excelFieldConfigMapper;

    @Override
    public List<ExcelFieldConfig> queryExcelFieldConfigInfoByTableId(Integer tableId) {
        List<ExcelFieldConfig> configs= excelFieldConfigMapper.findConfigByTableId(tableId);
        if (configs.isEmpty()){
            //TODO 异常：未能查找配置
        }
        return configs;
    }
}
