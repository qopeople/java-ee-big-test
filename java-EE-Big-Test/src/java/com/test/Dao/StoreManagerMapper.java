package com.test.Dao;

import com.test.entity.StoreManager;

public interface StoreManagerMapper {
    int deleteByPrimaryKey(String storemangerid);

    int insert(StoreManager record);

    int insertSelective(StoreManager record);

    StoreManager selectByPrimaryKey(String storemangerid);

    int updateByPrimaryKeySelective(StoreManager record);

    int updateByPrimaryKey(StoreManager record);
}