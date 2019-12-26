package com.example.bigtest.dao;

import com.example.bigtest.entity.StoreManager;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("storeManagerMapper")
@Mapper
public interface StoreManagerMapper {
    int deleteByPrimaryKey(int storemangerid);
     StoreManager selectByuserName(String username);
    int insert(StoreManager record);
    StoreManager selectByPrimaryKey(int storemangerid);
    List<StoreManager> select();
    int updateByPrimaryKey(StoreManager record);
    int updateByUserInform(UserAuthDTO userAuthDTO);
}