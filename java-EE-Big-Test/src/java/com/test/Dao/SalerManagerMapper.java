package com.test.Dao;

import com.test.entity.SalerManager;

public interface SalerManagerMapper {
    int deleteByPrimaryKey(String salemanagerid);

    int insert(SalerManager record);

    int insertSelective(SalerManager record);

    SalerManager selectByPrimaryKey(String salemanagerid);

    int updateByPrimaryKeySelective(SalerManager record);

    int updateByPrimaryKey(SalerManager record);
}