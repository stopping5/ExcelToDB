package com.stopping.service.impl;

import com.stopping.service.BatchDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BatchDataServiceImplTest {

    @Autowired
    private BatchDataService batchDataService;

    @Test
    void batchInsertData() {

        batchDataService.batchInsertData("import_excel_user","`username`, `age`, `school`","( 'cs', 13, 'ss' ),( 'ss', 16, 'sss' )");
    }
}