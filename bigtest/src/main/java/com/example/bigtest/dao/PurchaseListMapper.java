package com.example.bigtest.dao;

import com.example.bigtest.entity.PurchaseList;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("purchaseListMapper")
@Mapper
public interface PurchaseListMapper {
    int deleteByPrimaryKey(int purchaseid);

    int insert(PurchaseList record);

    int insertByOrder(GetPurchaseList getPurchaseList);

    PurchaseList selectByPrimaryKey(int purchaseid);

    List<PurchaseList> select();

    int updateByPrimaryKey(PurchaseList record);
}