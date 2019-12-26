package com.example.bigtest.service;


import com.example.bigtest.entity.*;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.*;
import com.example.bigtest.utils.CommonResponse;

import javax.validation.constraints.Null;
import java.util.List;

public interface SalerManagerService {
    CommonResponse login( UserAuthDTO userAuthDTO );
    CommonResponse loginSTM( UserAuthDTO userAuthDTO );
    CommonResponse loginSP( UserAuthDTO userAuthDTO );
    /**
     * 所有信息
     * @return
     */
    CommonResponse allContractList ();


    CommonResponse addContract(ContractInform contractInform);

    //添加合同项
    CommonResponse addItem(ContractItem contractItem);
//刪除合同項
    CommonResponse deleteItem(ContractItemKey contractItemKey);
    //獲取合同項
    CommonResponse allItemList(ContractItemKey contractItemKey);
    CommonResponse allContractItem();
    CommonResponse allItemListByContractId(int contractId);
    //包括删除所包含的合同项，以及所有有关的发货信息
    CommonResponse deleteContract(int contractId);

    //更新合同项内容
    CommonResponse updateItem(ContractItem contractItem);
    //更新合同项状态
    CommonResponse updateItemStatus(ChangeItemStatus changeItemStatus);
    //更新合同状态
    CommonResponse updateContractStatus(ChangeItemStatus changeItemStatus);
    //修改合同内容
    CommonResponse updateContractInform(ContractInform contractInform);
    //判断合同内容状态是否可以更变
    CommonResponse updateContractStatusTwo(int contractId);

    //获取客户信息
    CommonResponse allClientInform();
    //增加客户信息
    CommonResponse addClientInform(ClientInform clientInform);
    //修改客户信息
    CommonResponse updateClientInform(ClientInform clientInform);
    CommonResponse deleteClientInform(int clientId);

    //获取销售人员信息
    CommonResponse allSalePerson();
    //增加客户信息
    CommonResponse addSalePerson(SalePerson salePerson);
    //修改客户信息
    CommonResponse updateSalePerson(SalePerson salePerson);

    CommonResponse deleteSalePerson(int saleId);

    //获取所有订单信息
    CommonResponse allOrderList();



}
