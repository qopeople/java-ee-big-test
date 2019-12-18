package com.test.Dao;

import com.test.entity.ContractItem;
import com.test.entity.ContractItemKey;

public interface ContractItemMapper {
    int deleteByPrimaryKey(ContractItemKey key);

    int insert(ContractItem record);

    int insertSelective(ContractItem record);

    ContractItem selectByPrimaryKey(ContractItemKey key);

    int updateByPrimaryKeySelective(ContractItem record);

    int updateByPrimaryKey(ContractItem record);
}