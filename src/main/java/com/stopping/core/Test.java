package com.stopping.core;

import com.alibaba.excel.EasyExcel;
import com.stopping.core.listener.ReadHeadExcelListener;
import com.stopping.core.pojo.ExcelHeadInfoDTO;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String ios = "/Users/stopping/code/stopping/ExcelToDB/src/main/resources/config/用户爱好调查表头配置表.xlsx";
        String win = "";
        File file = new File(ios);
        EasyExcel.read(file,new ReadHeadExcelListener(null,new ExcelHeadInfoDTO("user_config"))).sheet().doRead();
    }
}
