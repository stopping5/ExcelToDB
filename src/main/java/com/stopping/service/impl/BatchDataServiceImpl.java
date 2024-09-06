package com.stopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stopping.dao.BatchDataMapper;
import com.stopping.dao.ExcelFieldConfigMapper;
import com.stopping.model.ExcelFieldConfig;
import com.stopping.service.BatchDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BatchDataServiceImpl extends ServiceImpl<BatchDataMapper, Object> implements BatchDataService {
    @Resource
    private BatchDataMapper batchDataMapper;

    @Override
    public void batchInsertData(String tableName, String params, String data) {
        //todo sql安全检测
        //批量插入数据
        batchDataMapper.batchInsert(tableName,data,params);
    }
}
