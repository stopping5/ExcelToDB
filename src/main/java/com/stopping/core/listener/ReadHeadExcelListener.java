package com.stopping.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.stopping.core.pojo.ExcelHeadInfoDTO;
import jdk.internal.org.objectweb.asm.Handle;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 读取Excel表头监听器
 */
@Slf4j
public class ReadHeadExcelListener implements ReadListener<Map<Integer,String>> {

    private ExcelHeadInfoDTO excelHeadInfoDTO;

    public ReadHeadExcelListener(ExcelHeadInfoDTO excelHeadInfoDTO) {
        this.excelHeadInfoDTO = excelHeadInfoDTO;
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("读取表头信息："+ JSON.toJSONString(headMap));
    }


    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        System.out.println("读取行数据信息:" + JSON.toJSONString(integerStringMap));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
