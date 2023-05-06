package com.stopping.core.listener;

import com.alibaba.excel.EasyExcel;
import com.stopping.core.context.ExcelTableContext;
import com.stopping.core.pojo.ExcelHeadInfoDTO;
import com.stopping.core.pojo.ExcelTableInfoDTO;
import com.stopping.core.util.IdUtil;
import com.stopping.mvc.service.ExcelFieldConfigService;
import com.stopping.mvc.service.ExcelTableConfigService;
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
    @Resource
    private ExcelTableConfigService excelTableConfigService;

    @Test
    public void testBatchInsert(){
        String ios = "/Users/stopping/code/stopping/ExcelToDB/src/main/resources/config/用户爱好调查表头配置表.xlsx";
        String win = "";
        File file = new File(ios);
        ExcelTableInfoDTO excelTableInfoDTO = new ExcelTableInfoDTO();
        excelTableInfoDTO.setExcelId(IdUtil.generateUuid());
        excelTableInfoDTO.setTableName("user");
        excelTableInfoDTO.setExcelTableName("用户爱好调查表头配置表");
        excelTableInfoDTO.setOperateName("用户信息调查表");
        ExcelTableContext.setContext(excelTableInfoDTO);
        EasyExcel.read(file,new ReadHeadExcelListener(excelFieldConfigService)).sheet().doRead();

        excelTableConfigService.generateDbTable();
        //TODO 关闭ThreadLocal
    }
}