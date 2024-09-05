package com.stopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stopping.model.TableFieldRelation;

/**
 * 
 */
public interface TableFieldRelationService extends IService<TableFieldRelation> {

    /**
     * 通过ID查询单个
     *
     * @param id ID
     * @return {@link TableFieldRelation}
     */
     TableFieldRelation findById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNum   页号
     * @param pageSize 每页大小
     * @return {@link TableFieldRelation}
     */
     IPage<TableFieldRelation> findByPage(int pageNum, int pageSize);

    /**
     * 新增
     *
     * @param tableFieldRelation TableFieldRelation
     */
    void insert(TableFieldRelation tableFieldRelation);

    /**
     * 修改
     *
     * @param tableFieldRelation TableFieldRelation
     */
    void update(TableFieldRelation tableFieldRelation);

    /**
     * 通过ID删除单个
     *
     * @param id ID
     */
    void deleteById(Integer id);

}