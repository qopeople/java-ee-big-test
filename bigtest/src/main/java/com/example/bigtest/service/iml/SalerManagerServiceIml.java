package com.example.bigtest.service.iml;

import com.example.bigtest.dao.*;
import com.example.bigtest.entity.*;
import com.example.bigtest.pojo.dto.UserAuthDTO;

import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.service.SalerManagerService;
import com.example.bigtest.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalerManagerServiceIml  implements SalerManagerService {

    @Autowired
    SalerManagerMapper salerManagerMapper;
    @Autowired
    ContractInformMapper contractInformMapper;
    @Autowired
    ContractItemMapper contractItemMapper;
    @Autowired
    ClientInformMapper clientInformMapper;
    @Autowired
    SalePersonMapper salePersonMapper;
    @Autowired
    DispatchListMapper dispatchListMapper;
    @Autowired
    StoreManagerMapper storeManagerMapper;

    @Override
    public CommonResponse login(UserAuthDTO userAuthDTO ) {
        SalerManager salerManager1 = salerManagerMapper.selectByuserName(userAuthDTO.getUsername());
        if(!StringUtils.isEmpty(salerManager1)){
            return CommonResponse.setOk("登录成功！",salerManager1);
        }
        return CommonResponse.setOk("登录失败！请联系管理员注册账号",-1);
    }
    @Override
    public CommonResponse loginSTM(UserAuthDTO userAuthDTO ) {
        StoreManager storeManager =storeManagerMapper.selectByuserName(userAuthDTO.getUsername());

        if(!StringUtils.isEmpty(storeManager)){
            return CommonResponse.setOk("登录成功！",storeManager);
        }
        return CommonResponse.setOk("登录失败",-1);
    }
    @Override
    public CommonResponse loginSP(UserAuthDTO userAuthDTO ) {
        SalePerson salePerson =salePersonMapper.selectByuserName(userAuthDTO.getUsername());

        if(!StringUtils.isEmpty(salePerson)){
            return CommonResponse.setOk("登录成功！",salePerson);
        }
        return CommonResponse.setOk("登录失败",-1);
    }

    @Override
    public CommonResponse allContractList() {
        List<ContractInform>  contractInforms = contractInformMapper.select();
        if(!contractInforms.isEmpty()){
            return  CommonResponse.setOk(contractInforms);
        }
        return null;
    }


    @Override
    public CommonResponse addContract(ContractInform contractInform) {
        int resultNums = contractInformMapper.insert(contractInform);
        if(resultNums>0){
            return CommonResponse.setOk("添加成功",resultNums);
        }else {
            return CommonResponse.error("插入数据失败！");
        }
    }

    @Override
    public CommonResponse addItem(ContractItem contractItem) {
        int resultNums2 = contractItemMapper.insert(contractItem);
        if(resultNums2>0){
            return CommonResponse.setOk("添加成功",resultNums2);
        }else {
            return CommonResponse.error("插入数据失败！");
        }
    }
    //獲取合同項
    @Override
    public CommonResponse allItemList(ContractItemKey contractItemKey){
       ContractItem contractItems = contractItemMapper.selectByPrimaryKey(contractItemKey);
        if(!StringUtils.isEmpty(contractItems)){
            return CommonResponse.setOk("查詢成功",contractItems);
        }else {
            return CommonResponse.error("查詢数据失败！");
        }
    }
    @Override
    public CommonResponse allContractItem(){
        List<ContractItem> contractItems = contractItemMapper.select();
        if(!contractItems.isEmpty()){
            return CommonResponse.setOk("查詢成功",contractItems);
        }else {
            return CommonResponse.error("查詢数据失败！");
        }

    }
    @Override
    public   CommonResponse allItemListByContractId(int contractid){
        List<ContractItem> contractItems = contractItemMapper.selectByContractId(contractid);
        if(!contractItems.isEmpty()){
            return CommonResponse.setOk("查詢成功",contractItems);
        }else {
            return CommonResponse.error("查詢数据失败！");
        }
    }

    @Override
  public CommonResponse deleteItem(ContractItemKey contractItemKey){
        int res = contractItemMapper.deleteByPrimaryKey(contractItemKey);
       if(res>0){
           return CommonResponse.setOk("删除数据成功",res);
       }else {
           return CommonResponse.error("删除数据失败！");
       }
   }
    @Override
    public CommonResponse deleteContract(int contractId) {
        int resultNum1 = contractInformMapper.deleteByPrimaryKey(contractId);
        int resultNum2  = contractItemMapper.deletwByContractId(contractId);
        if(resultNum1>0){
            return CommonResponse.setOk("删除数据成功",resultNum1);
        }else {
            return CommonResponse.error("删除数据失败");
        }

    }

    //更新合同项内容
    @Override
    public CommonResponse updateItem(ContractItem contractItem){
      int res =  contractItemMapper.updateByPrimaryKey(contractItem);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");

    }
    //更新合同项状态
    @Override
    public CommonResponse updateItemStatus(ChangeItemStatus changeItemStatus){

        ContractItemKey contractItemKey = new ContractItemKey(changeItemStatus.getContractid(),changeItemStatus.getContractitemid());
        ContractItem contractItem =contractItemMapper.selectByPrimaryKey(contractItemKey);
        if(contractItem.getNeedgoodsnum()>0){
            changeItemStatus.setItemstatus("进行中");
        }
        System.out.println(changeItemStatus.getItemstatus());
        int res = contractItemMapper.updateStatus(changeItemStatus);
         List<DispatchList> dispatchLists = dispatchListMapper.selectByContractKeyTwo(contractItemKey);
         for (int i=0;i<dispatchLists.size();i++){
             DispatchList dispatchList = dispatchLists.get(i);
             if(dispatchList.getEndtime()==null){
                 dispatchList.setEndtime(new Date());
                 int res2 = dispatchListMapper.updateByPrimaryKey(dispatchList);

             }
         }

        return  CommonResponse.setOk("修改成功","0");
    }
    //更新合同状态
    @Override
    public CommonResponse updateContractStatus(ChangeItemStatus changeItemStatus){
        int res = contractInformMapper.updateStatus2(changeItemStatus);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");
    }
    //修改合同内容
    @Override
    public CommonResponse updateContractInform(ContractInform contractInform){
     int res=  contractInformMapper.updateByPrimaryKey(contractInform);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");
    }
//判断内容是否可以变化
@Override
public CommonResponse updateContractStatusTwo(int contractId){
        List<ContractItem> contractItems = contractItemMapper.selectByContractId(contractId);
        if (!contractItems.isEmpty()){
            for (int i=0;i<contractItems.size();i++){
                if(!contractItems.get(i).getItemstatus().equals("履行完成")){
                    return  CommonResponse.setOk("合同未完成","0");
                }
            }
           ChangeItemStatus changeItemStatus =new ChangeItemStatus();
            changeItemStatus.setContractid(contractId);
            changeItemStatus.setConstractstatus("履行完成");
            Date date =new Date();
            changeItemStatus.setContractendtime(date);
            int res = contractInformMapper.updateStatus2(changeItemStatus);
            if(res>0){
                return  CommonResponse.setOk("合同更新成功",res);
            }else {
                 return CommonResponse.error("更新失败！");
            }
        }else {
            return  CommonResponse.setOk("合同内容项为空",-1);
        }
}
    //获取客户信息
    @Override
    public  CommonResponse allClientInform(){
        List<ClientInform> clientInforms = clientInformMapper.select();
        if(!clientInforms.isEmpty()){
            return CommonResponse.setOk("获取成功",clientInforms);
        }
        return CommonResponse.error("获取失败");
    }
    //增加客户信息
    @Override
    public CommonResponse addClientInform(ClientInform clientInform){
        int resNum = clientInformMapper.insert(clientInform);
        if(resNum>0){
            return  CommonResponse.setOk("成功添加",resNum);
        }
        return  CommonResponse.error("添加失败");
    }
    //修改客户信息
    @Override
    public CommonResponse updateClientInform(ClientInform clientInform){
      int res =  clientInformMapper.updateByPrimaryKey(clientInform);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");
    }

    @Override
    public CommonResponse deleteClientInform(int clientId){
        clientInformMapper.deleteByPrimaryKey(clientId);
        return  CommonResponse.setOk("删除成功","0");
    }
    //获取销售人员信息
    @Override
    public CommonResponse allSalePerson(){
        List<SalePerson> salePeople = salePersonMapper.select();
        if(!salePeople.isEmpty()){
            return  CommonResponse.setOk("查讯成功",salePeople);
        }
        return  CommonResponse.error("查询失败");
    }
    //增加销售人员信息
    @Override
    public CommonResponse addSalePerson(SalePerson salePerson){
        int resNum = salePersonMapper.insert(salePerson);
        if(resNum>0){
            return  CommonResponse.setOk("添加成功",resNum);
        }
        return  CommonResponse.error("添加失败");
    }
    //修改销售人员信息
    @Override
    public CommonResponse updateSalePerson(SalePerson salePerson){
      int res =  salePersonMapper.updateByPrimaryKey(salePerson);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");

    }
   @Override
   public  CommonResponse deleteSalePerson(int saleid){
        salePersonMapper.deleteByPrimaryKey(saleid);
       return  CommonResponse.setOk("删除成功","0");
   }
    //获取所有订单信息
    @Override
    public    CommonResponse allOrderList(){
        List<ContractInform> contractInforms = contractInformMapper.select();
//
        List<GetDispatchOrder> getDispatchOrders = new ArrayList();
        if(!contractInforms.isEmpty()) {
            for (int j = 0; j < contractInforms.size(); j++) {
                List<ContractItem> contractItems2 = contractItemMapper.selectByContractId(contractInforms.get(j).getContractid());

                if (!contractItems2.isEmpty()) {
                    for (int k = 0; k < contractItems2.size(); k++) {
                        ContractItemKey contractItemKey = new ContractItemKey(contractItems2.get(k).getContractid(), contractItems2.get(k).getContractitemid());
                        List<DispatchList> dispatchLists= dispatchListMapper.selectByContractKeyTwo(contractItemKey);
                        for (int i=0;i<dispatchLists.size();i++) {
                           DispatchList dispatchList = dispatchLists.get(i);
                                if (dispatchList.getEndtime() != null) {
                                    GetDispatchOrder getDispatchOrder = new GetDispatchOrder();
                                    getDispatchOrder.setClientid(contractItems2.get(k).getClientid());
                                    getDispatchOrder.setStarttime(dispatchList.getStarttime());
                                    getDispatchOrder.setEndtime(dispatchList.getEndtime());
                                    getDispatchOrder.setDispatchlistid(dispatchList.getDispatchlistid());
                                    getDispatchOrder.setGoodsnum(contractItems2.get(k).getGoodsnum());
                                    getDispatchOrder.setGoodsoutprice(contractItems2.get(k).getGoodsoutprice());
                                    getDispatchOrder.setGoodsid(contractItems2.get(k).getGoodsid());
                                    getDispatchOrder.setRealgoodsnum(dispatchList.getRealgoodsnum());
                                    getDispatchOrder.setGoodsname(contractItems2.get(k).getGoodsname());
                                    getDispatchOrders.add(getDispatchOrder);

                            }
                        }
                    }
                }
            }
            return CommonResponse.setOk("查询完成",getDispatchOrders);
        }else {
            return CommonResponse.error("无内容");
        }
    }


}
