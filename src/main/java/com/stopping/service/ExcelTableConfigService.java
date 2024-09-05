package com.stopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stopping.model.ExcelTableConfig;

/**
 * 
 */
public interface ExcelTableConfigService extends IService<ExcelTableConfig> {

    /**
     * 通过ID查询单个
     *
     * @param id ID
     * @return {@link ExcelTableConfig}
     */
     ExcelTableConfig findById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNum   页号
     * @param pageSize 每页大小
     * @return {@link ExcelTableConfig}
     */
     IPage<ExcelTableConfig> findByPage(int pageNum, int pageSize);

    /**
     * 新增
     *
     * @param excelTableConfig ExcelTableConfig
     */
    void insert(ExcelTableConfig excelTableConfig);

    /**
     * 修改
     *
     * @param excelTableConfig ExcelTableConfig
     */
    void update(ExcelTableConfig excelTableConfig);

    /**
     * 通过ID删除单个
     *
     * @param id ID
     */
    void deleteById(Integer id);

}