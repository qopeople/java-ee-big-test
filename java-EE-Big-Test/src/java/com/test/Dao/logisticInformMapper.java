package com.test.Dao;

import com.test.entity.logisticInformKey;

public interface logisticInformMapper {
    int deleteByPrimaryKey(logisticInformKey key);

    int insert(logisticInformKey record);

    int insertSelective(logisticInformKey record);
}