package com.stopping.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.stopping.core.pojo.ExcelFieldConfig;
import com.stopping.core.pojo.ExcelHeadInfoDTO;
import jdk.internal.org.objectweb.asm.Handle;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 读取Excel表头监听器
 */
@Slf4j
public class ReadHeadExcelListener implements ReadListener<Map<Integer,String>> {
    /**
     * Excel请求头关联信息
     * */
    private ExcelHeadInfoDTO excelHeadInfoDTO;

    /**
     * 缓存读取配置信息
     */
    private List<ExcelFieldConfig> excelFieldConfigs = new ArrayList<>(MAX_THRESHOLD);

    private static Integer MAX_THRESHOLD = 2;

    public ReadHeadExcelListener(ExcelHeadInfoDTO excelHeadInfoDTO) {
        this.excelHeadInfoDTO = excelHeadInfoDTO;
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("读取表头信息："+ JSON.toJSONString(headMap));
    }


    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        //System.out.println("读取行数据信息:" + JSON.toJSONString(integerStringMap));
        ExcelFieldConfig excelFieldConfig = new ExcelFieldConfig(integerStringMap.get(0),integerStringMap.get(1),Integer.valueOf(integerStringMap.get(2)),Integer.valueOf(integerStringMap.get(3)));
        excelFieldConfigs.add(excelFieldConfig);
        if (excelFieldConfigs.size() >= MAX_THRESHOLD){
            saveExcelConfig();
            excelFieldConfigs.clear();
        }
    }

    /**
     * 批量保存
     */
    private void saveExcelConfig(){
        System.out.println("批量保存:"+JSON.toJSONString(excelFieldConfigs));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveExcelConfig();
        System.out.println("数据清洗完毕");
    }
}
