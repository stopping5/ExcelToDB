package com.stopping.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.stopping.core.context.ExcelTableContext;
import com.stopping.core.pojo.ExcelFieldConfigDTO;
import com.stopping.core.pojo.ExcelHeadInfoDTO;
import com.stopping.mvc.service.ExcelFieldConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 读取Excel表头监听器
 */
@Slf4j
public class ReadHeadExcelListener implements ReadListener<Map<Integer,String>> {
    private ExcelFieldConfigService excelFieldConfigService;

    /**
     * 缓存读取配置信息
     */
    private List<ExcelFieldConfigDTO> excelFieldConfigDTOS = new ArrayList<>(MAX_THRESHOLD);

    private static Integer MAX_THRESHOLD = 100;

    public ReadHeadExcelListener(ExcelFieldConfigService excelFieldConfigService) {
        this.excelFieldConfigService = excelFieldConfigService;
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("读取表头信息："+ JSON.toJSONString(headMap));
    }


    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        //System.out.println("读取行数据信息:" + JSON.toJSONString(integerStringMap));
        ExcelFieldConfigDTO excelFieldConfigDTO = new ExcelFieldConfigDTO(integerStringMap.get(0),integerStringMap.get(1),Integer.valueOf(integerStringMap.get(2)),Integer.valueOf(integerStringMap.get(3)),Integer.valueOf(integerStringMap.get(4)));
        excelFieldConfigDTOS.add(excelFieldConfigDTO);
        if (excelFieldConfigDTOS.size() >= MAX_THRESHOLD){
            saveExcelConfig();
            excelFieldConfigDTOS.clear();
        }
    }

    /**
     * 批量保存
     */
    private void saveExcelConfig(){
        System.out.println("批量保存:"+JSON.toJSONString(excelFieldConfigDTOS));
        excelFieldConfigService.batchSave(excelFieldConfigDTOS);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveExcelConfig();
        System.out.println("数据清洗完毕,保存表格信息");

    }
}
