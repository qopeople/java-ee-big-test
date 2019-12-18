package com.test.Dao;

import com.test.entity.ClientInform;

public interface ClientInformMapper {
    int deleteByPrimaryKey(String clientid);

    int insert(ClientInform record);

    int insertSelective(ClientInform record);

    ClientInform selectByPrimaryKey(String clientid);

    int updateByPrimaryKeySelective(ClientInform record);

    int updateByPrimaryKey(ClientInform record);
}