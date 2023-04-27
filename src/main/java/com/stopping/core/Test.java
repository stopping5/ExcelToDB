package com.stopping.core;

import com.alibaba.excel.EasyExcel;
import com.stopping.core.listener.ReadHeadExcelListener;
import com.stopping.core.pojo.ExcelHeadInfoDTO;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\code\\excel-to-database\\src\\main\\resources\\config\\用户爱好调查表头配置表.xlsx");
        EasyExcel.read(file,new ReadHeadExcelListener(new ExcelHeadInfoDTO("user_config"))).sheet().doRead();
    }
}
