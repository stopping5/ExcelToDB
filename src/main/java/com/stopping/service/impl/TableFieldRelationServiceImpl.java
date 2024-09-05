package com.stopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stopping.model.TableFieldRelation;
import com.stopping.dao.TableFieldRelationMapper;
import com.stopping.service.TableFieldRelationService;

@Service
public class TableFieldRelationServiceImpl extends ServiceImpl<TableFieldRelationMapper, TableFieldRelation> implements TableFieldRelationService{

    @Autowired
    private TableFieldRelationMapper tableFieldRelationMapper;

    @Override
    public TableFieldRelation findById(Integer id){
        return tableFieldRelationMapper.selectById(id);
    }

    @Override
    public IPage<TableFieldRelation> findByPage(int pageNum, int pageSize) {
        return tableFieldRelationMapper.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public void insert(TableFieldRelation tableFieldRelation){
        tableFieldRelationMapper.insert(tableFieldRelation);
    }

    @Override
    public void update(TableFieldRelation tableFieldRelation){
        tableFieldRelationMapper.updateById(tableFieldRelation);
    }

    @Override
    public void deleteById(Integer id){
        tableFieldRelationMapper.deleteById(id);
    }

}