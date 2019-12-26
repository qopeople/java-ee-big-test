package com.example.bigtest.dao;

import com.example.bigtest.entity.ContractInform;
import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("contractInformMapper")
@Mapper
public interface ContractInformMapper   {
    int deleteByPrimaryKey(int contractid);

    int insert(ContractInform record);

    List <ContractInform> select();

    ContractInform selectByPrimaryKey(int contractid);

    List <ContractInform> selectByClientId(int clientid);
    List <ContractInform> selectBySalerId(int salerid);

    int updateByPrimaryKey(ContractInform record);
    int updateStatus(GetDispatchOrder getDispatchOrder);
    int updateStatus2(ChangeItemStatus changeItemStatus);
}