package com.stopping.core.listener;

import com.alibaba.excel.EasyExcel;
import com.stopping.core.pojo.ExcelHeadInfoDTO;
import com.stopping.mvc.service.ExcelFieldConfigService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;


@SpringBootTest
@RunWith(SpringRunner.class)
class ReadHeadExcelListenerTest {
    @Resource
    private ExcelFieldConfigService excelFieldConfigService;

    @Test
    public void testBatchInsert(){
        String ios = "/Users/stopping/code/stopping/ExcelToDB/src/main/resources/config/用户爱好调查表头配置表.xlsx";
        String win = "";
        File file = new File(ios);
        EasyExcel.read(file,new ReadHeadExcelListener(excelFieldConfigService,new ExcelHeadInfoDTO("user_config"))).sheet().doRead();
    }
}