package com.example.bigtest.dao;


import com.example.bigtest.entity.ContractItem;
import com.example.bigtest.entity.ContractItemKey;
import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("contractItemMapper")
@Mapper
public interface ContractItemMapper {
    int deleteByPrimaryKey(ContractItemKey key);
    int deletwByContractId(int contractid);

    int insert(ContractItem record);


    List<ContractItem> select();

    ContractItem selectByPrimaryKey(ContractItemKey key);

    List<ContractItem> selectByContractId(int contractid);
    List<ContractItem> selectByClientId(int clientid);
    int updateByPrimaryKey(ContractItem record);

    int updateByOrder(GetDispatchOrder getDispatchOrder);
    int  updateByPurchase(GetPurchaseList getPurchaseList);
    int updateStatus(ChangeItemStatus changeItemStatus);

//    int updateByPurchase(GetPurchaseList getPurchaseList);
}