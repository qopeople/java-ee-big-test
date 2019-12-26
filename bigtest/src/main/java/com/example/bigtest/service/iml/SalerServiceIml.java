package com.example.bigtest.service.iml;

import com.example.bigtest.dao.*;
import com.example.bigtest.entity.ContractInform;
import com.example.bigtest.entity.ContractItem;
import com.example.bigtest.entity.ContractItemKey;
import com.example.bigtest.entity.DispatchList;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.GetClientSalary;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetSaleSalary;
import com.example.bigtest.service.SalerService;
import com.example.bigtest.utils.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalerServiceIml implements SalerService {
    @Autowired
    ContractInformMapper contractInformMapper;
    @Autowired
    ContractItemMapper contractItemMapper;
    @Autowired
    SalePersonMapper salePersonMapper;
    @Autowired
    DispatchListMapper dispatchListMapper;
    @Override
    public CommonResponse allContractBySalerId(int salerid) {
        List<ContractInform> contractInforms = contractInformMapper.selectBySalerId(salerid);
        if (!contractInforms.isEmpty()){
            return  CommonResponse.setOk("查询成功",contractInforms);
        }else{
            return CommonResponse.error("查询失败！");
        }
    }

    @Override
    public CommonResponse changeInform(UserAuthDTO userAuthDTO) {
       int res = salePersonMapper.updateByUserInform(userAuthDTO);
       if(res>0){
           return  CommonResponse.setOk("查询成功",res);
       }else {
           return  CommonResponse.error("更新失败");
       }
    }

    @Override
    public CommonResponse findSomeTimeSalaryByClient(GetClientSalary getClientSalary) {
        List<ContractItem> contractItems =contractItemMapper.selectByClientId(getClientSalary.getClientid());
        int resNum =0;
        if(!contractItems.isEmpty()){
            for (int i=0 ;i<contractItems.size();i++){
                if(contractItems.get(i).getItemstatus()=="履行完成") {
                    ContractItemKey contractItemKey = new ContractItemKey(contractItems.get(i).getContractid(), contractItems.get(i).getContractitemid());
                    DispatchList dispatchList = dispatchListMapper.selectByContractKey(contractItemKey);

                    if (dispatchList.getStarttime().compareTo(getClientSalary.getCreateTime()) >= 0 && dispatchList.getEndtime().compareTo(getClientSalary.getEndTime()) <= 0) {
                        resNum += contractItems.get(i).getGoodsnum() * contractItems.get(i).getGoodsoutprice();
                    }
                }

            }
            return  CommonResponse.setOk("查询成功",resNum );
        }else{
            return CommonResponse.error("查询失败！");
        }

    }
    @Override
    public  CommonResponse allOrderBySalerId(int salerid)
    {
        List<ContractInform> contractInforms = contractInformMapper.selectBySalerId(salerid);
//
        List<GetDispatchOrder> getDispatchOrders = new ArrayList();
        if(!contractInforms.isEmpty()) {
            for (int j = 0; j < contractInforms.size(); j++) {
                List<ContractItem> contractItems2 = contractItemMapper.selectByContractId(contractInforms.get(j).getContractid());

                if (!contractItems2.isEmpty()) {
                    for (int k = 0; k < contractItems2.size(); k++) {


                            ContractItemKey contractItemKey = new ContractItemKey(contractItems2.get(k).getContractid(), contractItems2.get(k).getContractitemid());
                            List<DispatchList> dispatchLists= dispatchListMapper.selectByContractKeyTwo(contractItemKey);
                           for (int m=0;m<dispatchLists.size();m++) {
                               DispatchList dispatchList =dispatchLists.get(m);
                               if(dispatchList.getEndtime()!=null) {
                                   GetDispatchOrder getDispatchOrder = new GetDispatchOrder();

                                   getDispatchOrder.setStarttime(dispatchList.getStarttime());
                                   getDispatchOrder.setEndtime(dispatchList.getEndtime());
                                   getDispatchOrder.setDispatchlistid(dispatchList.getDispatchlistid());
                                   getDispatchOrder.setGoodsnum(contractItems2.get(k).getGoodsnum());
                                   getDispatchOrder.setGoodsoutprice(contractItems2.get(k).getGoodsoutprice());
                                   getDispatchOrder.setGoodsid(contractItems2.get(k).getGoodsid());

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
