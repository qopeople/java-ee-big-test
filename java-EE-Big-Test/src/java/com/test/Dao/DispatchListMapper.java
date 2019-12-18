package com.test.Dao;

import com.test.entity.DispatchList;

public interface DispatchListMapper {
    int deleteByPrimaryKey(String dispatchlistid);

    int insert(DispatchList record);

    int insertSelective(DispatchList record);

    DispatchList selectByPrimaryKey(String dispatchlistid);

    int updateByPrimaryKeySelective(DispatchList record);

    int updateByPrimaryKey(DispatchList record);
}