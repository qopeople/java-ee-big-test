package com.example.bigtest.dao;

import com.example.bigtest.entity.ContractItemKey;
import com.example.bigtest.entity.DispatchList;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("dispatchListMapper")
@Mapper
public interface DispatchListMapper {
    int deleteByPrimaryKey(int dispatchlistid);

    int insert(DispatchList record);

    DispatchList selectByContractKey(ContractItemKey contractItemKey);
    DispatchList selectByPrimaryKey(int dispatchlistid);

    List<DispatchList> select();

    List<DispatchList> selectByContractKeyTwo(ContractItemKey contractItemKey);

    int updateByPrimaryKey(DispatchList record);
    int insertByOther(GetDispatchOrder getDispatchOrder);
}