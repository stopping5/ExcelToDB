package com.stopping.service;


import com.alibaba.excel.EasyExcel;
import com.stopping.core.listener.ReadUploadExcelListener;
import com.stopping.service.impl.ExcelFieldConfigServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class ExcelFieldConfigServiceTest {

    @Autowired
    private ExcelFieldConfigService excelFieldConfigService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test(){
        String url = "src/main/resources/config/生源信息.xlsx";
        EasyExcel.read(url,new ReadUploadExcelListener(1,applicationContext)).sheet().doRead();

    }

}