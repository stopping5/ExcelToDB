package com.stopping.mvc.service.impl;

import com.stopping.core.context.ExcelTableContext;
import com.stopping.core.pojo.ExcelTableInfoDTO;
import com.stopping.mvc.pojo.entity.ExcelTableConfig;
import com.stopping.mvc.dao.mapper.ExcelTableConfigMapper;
import com.stopping.mvc.service.ExcelTableConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * 表格配置表 服务实现类
 *
 * @author stopping
 * @date 2023-05-06
 */
@Service
@Slf4j
public class ExcelTableConfigServiceImpl extends ServiceImpl<ExcelTableConfigMapper, ExcelTableConfig> implements ExcelTableConfigService {

    @Override
    public boolean generateDbTable() {
        ExcelTableInfoDTO excelTableInfoDTO = ExcelTableContext.getContext();
        Assert.notNull(excelTableInfoDTO,"Excel Table Context Is Null");
        ExcelTableConfig excelTableConfig = new ExcelTableConfig();
        BeanUtils.copyProperties(excelTableInfoDTO,excelTableConfig);
        return this.save(excelTableConfig);
    }
}
