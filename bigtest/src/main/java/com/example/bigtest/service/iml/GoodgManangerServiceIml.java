package com.example.bigtest.service.iml;

import com.example.bigtest.dao.*;
import com.example.bigtest.entity.*;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetGoodsSalary;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import com.example.bigtest.pojo.vto.GetSaleSalary;
import com.example.bigtest.service.GoodgManangerService;
import com.example.bigtest.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class GoodgManangerServiceIml implements GoodgManangerService {
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
    GoodsInformMapper goodsInformMapper;
    @Autowired
    PurchaseListMapper purchaseListMapper;
    @Autowired
    logisticInformMapper logisticMapper;
    @Override
    public CommonResponse allGoodsList() {
        List<GoodsInform> goodsInforms = goodsInformMapper.select();
        if(!goodsInforms.isEmpty()){
            return  CommonResponse.setOk("查询成功",goodsInforms);
        }else {
            return  CommonResponse.error("查询失败");
        }
    }
    //根据商品信息获取id
    @Override
    public CommonResponse getGoodsById(int goodsid){
        GoodsInform goodsInforms = goodsInformMapper.selectByPrimaryKey(goodsid);
        if(!StringUtils.isEmpty(goodsInforms)){
            return  CommonResponse.setOk("查询成功",goodsInforms);
        }else {
            return  CommonResponse.error("查询失败");
        }
    }
    //更新商品信息
    @Override
    public CommonResponse updateGoodsinform(GoodsInform goodsInform){
        int res  = goodsInformMapper.updateByPrimaryKey(goodsInform);
        if(res>0){
            return  CommonResponse.setOk("修改成功","0");
        }
        return CommonResponse.setOk("不存在信息","-1");
    }
    @Override
    public CommonResponse addDispatchOrder(GetDispatchOrder getDispatchOrder) {
        //插入发货单
        int resNum =  dispatchListMapper.insertByOther(getDispatchOrder);
        int resNum2= contractItemMapper.updateByOrder(getDispatchOrder);
        int resNum3 = goodsInformMapper.updateByOrder(getDispatchOrder);
        int resNum4 = contractInformMapper.updateStatus(getDispatchOrder);
        if(resNum>0&&resNum2>0&&resNum3>0&&resNum4>0){
            return  CommonResponse.setOk("添加成功",resNum);
        }
        return  CommonResponse.error("添加失败");
    }
    //获取发货单
    @Override
    public CommonResponse allDispatchOrder() {
//
        List<GetDispatchOrder> getDispatchOrders = new ArrayList();
        List<DispatchList> dispatchLists = dispatchListMapper.select();
        for (int i=0;i<dispatchLists.size();i++){
            ContractItemKey contractItemKey = new ContractItemKey(dispatchLists.get(i).getcontractid(),dispatchLists.get(i).getContractitemid());
            ContractItem contractItem = contractItemMapper.selectByPrimaryKey(contractItemKey);
            GoodsInform goodsInform = goodsInformMapper.selectByPrimaryKey(contractItem.getGoodsid());
            GetDispatchOrder getDispatchOrder =new GetDispatchOrder();

            getDispatchOrder.setContractid(contractItem.getContractid());
            getDispatchOrder.setContractitemid(contractItem.getContractitemid());
            getDispatchOrder.setDispatchlistid(dispatchLists.get(i).getDispatchlistid());
            getDispatchOrder.setItemstatus(contractItem.getItemstatus());
            getDispatchOrder.setEndtime(dispatchLists.get(i).getEndtime());
            getDispatchOrder.setRealgoodsnum(dispatchLists.get(i).getRealgoodsnum());
            getDispatchOrder.setGoodsnum(contractItem.getGoodsnum());
            getDispatchOrder.setClientid(contractItem.getClientid());
            getDispatchOrder.setNeedgoodsnum(contractItem.getNeedgoodsnum());
            getDispatchOrder.setGoodsid(goodsInform.getGoodsid());
            getDispatchOrder.setGoodsname(goodsInform.getGoodsname());
            getDispatchOrder.setGoodsoutprice(goodsInform.getGoodsoutprice());
            getDispatchOrder.setGoodsinprice(goodsInform.getGoodsinprice());
            getDispatchOrder.setGoodsstorenum(goodsInform.getGoodsstorenum());
            getDispatchOrders.add(getDispatchOrder);

        }
        if(!getDispatchOrders.isEmpty()){
            return CommonResponse.setOk("查询完成",getDispatchOrders);
        }else {
            return CommonResponse.error("查询失败");
        }
    }
    @Override
    public  CommonResponse dispatchOrderById(int dispatchlistid){
        DispatchList dispatchList =dispatchListMapper.selectByPrimaryKey(dispatchlistid);
        if (!StringUtils.isEmpty(dispatchList)){
            return CommonResponse.setOk("查询完成",dispatchList);
        }else {
            return CommonResponse.error("查询失败");
        }
    }

    @Override
    public CommonResponse updateDispatchOrder(GetDispatchOrder getDispatchOrder) {
        return null;
    }
    @Override
    public  CommonResponse allLogisticById(int dispatchlistid){
         List<logisticInformKey> logisticInformKeys = logisticMapper.selectById(dispatchlistid);
         if(!logisticInformKeys.isEmpty()){
             Collections.sort(logisticInformKeys, new Comparator<logisticInformKey>(){
                 public int compare(logisticInformKey p1, logisticInformKey p2) {
                     //按照Person的年龄进行升序排列
                     if(p1.getSteptime ().compareTo(p2.getSteptime())>0){
                         return 1;
                     }
                     if(p1.getSteptime ().compareTo(p2.getSteptime())==0){
                         return 0;
                     }
                     return -1;
                 }});
             return  CommonResponse.setOk("查询成功",logisticInformKeys);
         }else {
             return  CommonResponse.error("查询失败");
         }
    }
    //添加发货单物流状态
    @Override
    public   CommonResponse addLogistic(logisticInformKey logisticInformKey){
        int res = logisticMapper.insert(logisticInformKey);
        if(res>0){

            return  CommonResponse.setOk("插入成功",res);
        }else {
            return  CommonResponse.error("插入失败");
        }
    }


    @Override
    public CommonResponse addPurchaseList(GetPurchaseList getPurchaseList) {
       int res1 =purchaseListMapper.insertByOrder(getPurchaseList);
       int res2 = goodsInformMapper.updateByPurchse(getPurchaseList);
       int res3 =contractItemMapper.updateByPurchase(getPurchaseList);
       if(res1>0&&res2>0&&res3>0){
           return  CommonResponse.setOk("添加成功",0);
       }
        return  CommonResponse.error("添加失败");
    }

    @Override
    public CommonResponse allPurchaseList() {
        List<PurchaseList> purchaseLists = purchaseListMapper.select();
        List<GetPurchaseList> getPurchaseLists = new ArrayList();
        for(int i=0;i<purchaseLists.size();i++){
            ContractItemKey contractItemKey = new ContractItemKey(purchaseLists.get(i).getContractid(),purchaseLists.get(i).getContractitemid());
            ContractItem contractItem = contractItemMapper.selectByPrimaryKey(contractItemKey);
           System.out.println(contractItem);
            GetPurchaseList getPurchaseList =new GetPurchaseList();
            GoodsInform goodsInform = goodsInformMapper.selectByPrimaryKey(contractItem.getGoodsid());

            getPurchaseList.setPurchaseid(purchaseLists.get(i).getPurchaseid());
            getPurchaseList.setContractid(contractItem.getContractid());
            getPurchaseList.setNeedgoodsnum(contractItem.getNeedgoodsnum());

            getPurchaseList.setRealgoodsnum(purchaseLists.get(i).getRealgoodsnum());
            getPurchaseList.setContractitemid(contractItem.getContractitemid());
            getPurchaseList.setIntime(purchaseLists.get(i).getIntime());
            getPurchaseList.setClientid(contractItem.getClientid());
            getPurchaseList.setGoodsstorenum(goodsInform.getGoodsstorenum());
            getPurchaseList.setGoodsid(goodsInform.getGoodsid());
            getPurchaseList.setGoodsname(goodsInform.getGoodsname());
            getPurchaseList.setGoodsnum(contractItem.getGoodsnum());
            getPurchaseList.setGoodsinprice(goodsInform.getGoodsinprice());
            getPurchaseList.setGoodsoutprice(goodsInform.getGoodsoutprice());
            getPurchaseList.setItemstatus(contractItem.getItemstatus());
               getPurchaseLists.add(getPurchaseList);
        }
       if(!getPurchaseLists.isEmpty()){
           return CommonResponse.setOk("查询完成",getPurchaseLists);
       }else {
           return CommonResponse.error("查询失败");
       }

    }

    @Override
    public CommonResponse updatePurchaseList(GetPurchaseList getPurchaseList) {
        return null;
    }

    @Override
    public CommonResponse getSalaryByClientId(GetSaleSalary getSaleSalary) {
        return null;
    }

    @Override
    public CommonResponse getSalaryBySaleId(GetSaleSalary getSaleSalary) {
        return null;
    }

    @Override
    public CommonResponse getSalaryByGoodsId(GetGoodsSalary getGoodsSalary) {
        return null;
    }
    //增加商品信息
    @Override
   public CommonResponse addGoods(GoodsInform goodsInform){
        int res = goodsInformMapper.insert(goodsInform);
        if(res>0){
            return CommonResponse.setOk("添加成功",res);
        }
        return CommonResponse.error("添加失败");
    }
    //移除商品信息
    @Override
    public CommonResponse deleteGoods(int goodsid){
        int res  = goodsInformMapper.deleteByPrimaryKey(goodsid);
        if(res>0){
            return CommonResponse.setOk("删除成功",res);
        }
        return CommonResponse.error("删除失败");

    }
}
