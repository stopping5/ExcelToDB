package com.stopping.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.stopping.core.pojo.ExcelHeadInfoDTO;

import java.util.Map;

/**
 * 读取Excel表头监听器
 */
public class ReadHeadExcelListener implements ReadListener<Map<Integer,String>> {

    private ExcelHeadInfoDTO excelHeadInfoDTO;

    public ReadHeadExcelListener(ExcelHeadInfoDTO excelHeadInfoDTO) {
        this.excelHeadInfoDTO = excelHeadInfoDTO;
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        ReadListener.super.invokeHead(headMap, context);
    }


    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
