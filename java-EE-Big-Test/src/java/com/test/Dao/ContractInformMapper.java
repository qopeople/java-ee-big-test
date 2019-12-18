package com.test.Dao;

import com.test.entity.ContractInform;

public interface ContractInformMapper {
    int deleteByPrimaryKey(String contractid);

    int insert(ContractInform record);

    int insertSelective(ContractInform record);

    ContractInform selectByPrimaryKey(String contractid);

    int updateByPrimaryKeySelective(ContractInform record);

    int updateByPrimaryKey(ContractInform record);
}