package com.test.Dao;

import com.test.entity.PurchaseList;

public interface PurchaseListMapper {
    int deleteByPrimaryKey(String purchaseid);

    int insert(PurchaseList record);

    int insertSelective(PurchaseList record);

    PurchaseList selectByPrimaryKey(String purchaseid);

    int updateByPrimaryKeySelective(PurchaseList record);

    int updateByPrimaryKey(PurchaseList record);
}