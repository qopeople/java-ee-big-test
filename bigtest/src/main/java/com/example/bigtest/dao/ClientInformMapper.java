package com.example.bigtest.dao;

import com.example.bigtest.entity.ClientInform;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("clientInformMapper")
@Mapper
public interface ClientInformMapper {
    int deleteByPrimaryKey(int clientid);

    int insert(ClientInform record);

    ClientInform selectByPrimaryKey(int clientid);

    List<ClientInform> select();

    int updateByPrimaryKey(ClientInform record);
}