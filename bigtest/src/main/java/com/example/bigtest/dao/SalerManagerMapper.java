package com.example.bigtest.dao;

import com.example.bigtest.entity.SalerManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("salerManagerMapper")
@Mapper
public interface SalerManagerMapper {
    int deleteByPrimaryKey(int salemanagerid);

    int insert(SalerManager record);

    SalerManager selectByPrimaryKey(int salemanagerid);
    SalerManager selectByuserName(String username);

    int updateByPrimaryKey(SalerManager record);
}