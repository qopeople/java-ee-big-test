package com.test.Dao;

import com.test.entity.GoodsInform;

public interface GoodsInformMapper {
    int deleteByPrimaryKey(String goodsid);

    int insert(GoodsInform record);

    int insertSelective(GoodsInform record);

    GoodsInform selectByPrimaryKey(String goodsid);

    int updateByPrimaryKeySelective(GoodsInform record);

    int updateByPrimaryKey(GoodsInform record);
}