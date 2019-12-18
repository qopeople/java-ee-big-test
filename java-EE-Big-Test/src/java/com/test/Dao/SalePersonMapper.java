package com.test.Dao;

import com.test.entity.SalePerson;

public interface SalePersonMapper {
    int deleteByPrimaryKey(String salerid);

    int insert(SalePerson record);

    int insertSelective(SalePerson record);

    SalePerson selectByPrimaryKey(String salerid);

    int updateByPrimaryKeySelective(SalePerson record);

    int updateByPrimaryKey(SalePerson record);
}