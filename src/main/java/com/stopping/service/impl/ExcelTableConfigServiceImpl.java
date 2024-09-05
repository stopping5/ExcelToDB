package com.stopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stopping.model.ExcelTableConfig;
import com.stopping.dao.ExcelTableConfigMapper;
import com.stopping.service.ExcelTableConfigService;

@Service
public class ExcelTableConfigServiceImpl extends ServiceImpl<ExcelTableConfigMapper, ExcelTableConfig> implements ExcelTableConfigService{

    @Autowired
    private ExcelTableConfigMapper excelTableConfigMapper;

    @Override
    public ExcelTableConfig findById(Integer id){
        return excelTableConfigMapper.selectById(id);
    }

    @Override
    public IPage<ExcelTableConfig> findByPage(int pageNum, int pageSize) {
        return excelTableConfigMapper.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public void insert(ExcelTableConfig excelTableConfig){
        excelTableConfigMapper.insert(excelTableConfig);
    }

    @Override
    public void update(ExcelTableConfig excelTableConfig){
        excelTableConfigMapper.updateById(excelTableConfig);
    }

    @Override
    public void deleteById(Integer id){
        excelTableConfigMapper.deleteById(id);
    }

}