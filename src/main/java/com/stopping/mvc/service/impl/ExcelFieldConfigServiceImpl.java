package com.stopping.mvc.service.impl;

import com.stopping.core.pojo.ExcelFieldConfigDTO;
import com.stopping.mvc.pojo.entity.ExcelFieldConfig;
import com.stopping.mvc.dao.mapper.ExcelFieldConfigMapper;
import com.stopping.mvc.service.ExcelFieldConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 表格字段配置表 服务实现类
 * </p>
 *
 * @author 
 * @date 2023-05-03
 */
@Service
@Slf4j
public class ExcelFieldConfigServiceImpl extends ServiceImpl<ExcelFieldConfigMapper, ExcelFieldConfig> implements ExcelFieldConfigService {

    @Override
    public void batchSave(List<ExcelFieldConfigDTO> excelFieldConfig) {
        List<ExcelFieldConfig> excelFieldConfigs = new ArrayList<>();
        excelFieldConfigs = excelFieldConfig.stream().map(
                (excel)->{
                    ExcelFieldConfig efc = new ExcelFieldConfig();
                    BeanUtils.copyProperties(excel,efc);
                    return efc;
                }
        ).collect(Collectors.toList());
        log.info("保存数据库:{}",excelFieldConfigs);
        baseMapper.saveBatch(excelFieldConfigs);
    }
}
