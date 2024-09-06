package com.stopping.service;

/**
 * 批量数据处理逻辑
 * @author stopping
 * @date 2024年9月5日22:46:17
 */
public interface BatchDataService{

    /**
     * 批量插入数据
     * @param tableName 表名
     * @param params 参数
     * @param data 数据
     */
    void batchInsertData(String tableName,String params,String data);
}
