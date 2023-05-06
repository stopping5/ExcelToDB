package com.stopping.core.context;

import com.stopping.core.pojo.ExcelTableInfoDTO;

public class ExcelTableContext {
    /**
     * Excel上下文内容
     */
    private static ThreadLocal<ExcelTableInfoDTO> context = new InheritableThreadLocal<>();

    public static void setContext(ExcelTableInfoDTO excelInfo){
        context.set(excelInfo);
    }

    public static void setExcelID(String id){
        ExcelTableInfoDTO excelTableInfo = getContext();
        excelTableInfo.setExcelId(id);
        context.set(excelTableInfo);
    }

    public static void setColNum(Integer colNum){
        ExcelTableInfoDTO excelTableInfo = getContext();
        excelTableInfo.setColNum(colNum);
        context.set(excelTableInfo);
    }

    /**
     * 获取上下文内容
     * @return
     */
    public static ExcelTableInfoDTO getContext(){
        return context.get();
    }

    /**
     * 移除上下文信息
     */
    public static void remove(){
        context.remove();
    }
}
