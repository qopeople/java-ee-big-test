package com.example.bigtest.dao;

import com.example.bigtest.entity.logisticInformKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("logisticInformMapper")
@Mapper
public interface logisticInformMapper {
    int deleteByPrimaryKey(int dispatchlistid);

    int insert(logisticInformKey record);

//    logisticInformKey selectByKey(logisticInformKey key);
    List<logisticInformKey> selectById(int dispatchlistid);


}