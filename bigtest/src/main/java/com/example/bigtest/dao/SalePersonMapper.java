package com.example.bigtest.dao;

import com.example.bigtest.entity.SalePerson;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("salePersonMapper")
@Mapper
public interface SalePersonMapper {
    int deleteByPrimaryKey(int salerid);

    int insert(SalePerson record);

    SalePerson selectByuserName(String username);

    SalePerson selectByPrimaryKey(int salerid);

   List<SalePerson> select();

   int updateByUserInform(UserAuthDTO userAuthDTO);

    int updateByPrimaryKey(SalePerson record);

}