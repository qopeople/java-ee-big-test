package com.example.bigtest.dao;

import com.example.bigtest.entity.GoodsInform;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("goodsInformMapper")
@Mapper
public interface GoodsInformMapper {
    int deleteByPrimaryKey(int goodsid);

    int insert(GoodsInform record);

    GoodsInform selectByPrimaryKey(int goodsid);

    List<GoodsInform> select();
    int updateByPrimaryKey(GoodsInform record);

    int updateByOrder(GetDispatchOrder getDispatchOrder);
    int updateByPurchse(GetPurchaseList getPurchaseList);
}