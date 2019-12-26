package com.example.bigtest.controller;

import com.example.bigtest.entity.*;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import com.example.bigtest.service.GoodgManangerService;
import com.example.bigtest.service.SalerManagerService;
import com.example.bigtest.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sm")
@Slf4j
public class SalerManagerController {
    @Autowired
    SalerManagerService salerManagerService;
    @Autowired
    GoodgManangerService goodgManangerService;

    @PostMapping("/login")
    public CommonResponse login( UserAuthDTO userAuthDTO){
       return salerManagerService.login(userAuthDTO);
    }

    @PostMapping("/contract/allList")
    public CommonResponse allList(){
        return salerManagerService.allContractList();
    }
    @PostMapping("/contract/update")
    public CommonResponse contractUpdate(ContractInform contractInform){
        return salerManagerService.updateContractInform(contractInform);
    }
    @PostMapping("/contract/add")
    public CommonResponse contractAll (ContractInform contractInform){
        return  salerManagerService.addContract(contractInform);
    }
    @PostMapping("/contractStatus/update/"+  "/{contractid}")
    public CommonResponse contractStatusUpdate(@PathVariable("contractid")int contractid){
        return salerManagerService.updateContractStatusTwo(contractid);
    }
    @PostMapping("/contractStatusTwo/update")
    public CommonResponse contractStatusUpdateTwo(ChangeItemStatus changeItemStatus){
        return salerManagerService.updateContractStatus(changeItemStatus);
    }


    @PostMapping("/contractItemById/all"+  "/{contractid}")
    public CommonResponse contractItemAll( @PathVariable("contractid")int contractid){
        return salerManagerService.allItemListByContractId(contractid);
    }
    @PostMapping("/contractItemByKey/all")
    public CommonResponse contractItemByKeyAll(ContractItemKey contractItemKey){

        return salerManagerService.allItemList(contractItemKey);
    }
    @PostMapping("/contractItem/all")
    public CommonResponse contractItemAll(){

        return salerManagerService.allContractItem();
    }
    @PostMapping("/contractItem/add")
    public CommonResponse contractItemAdd(ContractItem contractItem){
        System.out.println(contractItem);
        return salerManagerService.addItem(contractItem);
    }
    @PostMapping("/contractItem/update")
    public CommonResponse contractItemUpdate(ContractItem contractItem){
        return salerManagerService.updateItem(contractItem);
    }
    @PostMapping("/contractItem/delete")
    public CommonResponse contractItemDelete(ContractItemKey contractItemKey){
        return salerManagerService.deleteItem (contractItemKey);
    }

    @PostMapping("/salePerson/allList")
    public CommonResponse  salePersonList(){
        return salerManagerService.allSalePerson();
    }
    @PostMapping("/salePerson/update")
    public CommonResponse salePersonUpdate(SalePerson salePerson){
        return salerManagerService.updateSalePerson(salePerson);
    }
    @PostMapping("/salePerson/add")
    public CommonResponse salePersonAdd(SalePerson salePerson){
        return  salerManagerService.addSalePerson(salePerson);
    }
    @PostMapping("/salePerson/delete"+  "/{saleid}")
    public CommonResponse salePersonDetele( @PathVariable("saleid")int saleid) {
        return salerManagerService.deleteSalePerson(saleid);
    }


    @PostMapping("/client/allList")
    public CommonResponse  clientList(){
        return salerManagerService.allClientInform();
    }
    @PostMapping("/client/update")
    public CommonResponse clientUpdate(ClientInform clientInform){
        return salerManagerService.updateClientInform(clientInform);
    }
    @PostMapping("/client/add")
    public CommonResponse salePersonAdd(ClientInform clientInform){
        return  salerManagerService.addClientInform (clientInform);
    }

    @PostMapping("/client/delete"+  "/{clientid}")
    public CommonResponse clientDetele( @PathVariable("clientid")int clientid) {
        return salerManagerService.deleteClientInform(clientid);
    }

    @PostMapping("/goods/all")
    public CommonResponse goodsList( ) {
        return goodgManangerService.allGoodsList();
    }

    @PostMapping("/goodsById/"+  "/{goodsid}")
    public CommonResponse goodsById( @PathVariable("goodsid")int goodsid) {
        return goodgManangerService.getGoodsById(goodsid);
    }
    @PostMapping("/goods/update")
    public CommonResponse goodsUpdate(GoodsInform goodsInform){
        return goodgManangerService.updateGoodsinform(goodsInform);
    }
    @PostMapping("/dispatch/add")
    public  CommonResponse dispatchAdd(GetDispatchOrder getDispatchOrder){
        System.out.println(getDispatchOrder);
        return  goodgManangerService.addDispatchOrder(getDispatchOrder);
    }
//    @PostMapping("/dispatch/update")
//    public  CommonResponse dispatchUpdate()
    @PostMapping("/purchase/add")
    public CommonResponse purchaseAdd(GetPurchaseList getPurchaseList){
        return goodgManangerService.addPurchaseList(getPurchaseList);

    }
    @PostMapping("/dispatch/all")
    public  CommonResponse dispatchAll(){

        return  goodgManangerService.allDispatchOrder();
    }
    @PostMapping("/dispatchById"+  "/{dispatchlistid}")
    public CommonResponse dispatchById(@PathVariable("dispatchlistid")int dispatchlistid){
        return goodgManangerService.dispatchOrderById(dispatchlistid);

    }
    @PostMapping("/purchase/all")
    public  CommonResponse purchaseAll(){

        return  goodgManangerService.allPurchaseList();
    }
    @PostMapping("/logisticById/all"+  "/{dispatchlistid}")
    public  CommonResponse logisticByIdAll(@PathVariable("dispatchlistid")int dispatchlistid){
        return  goodgManangerService.allLogisticById(dispatchlistid);
    }
    @PostMapping("/logistic/add")
    public CommonResponse logisticAdd(logisticInformKey logisticInformKey){
        return  goodgManangerService.addLogistic(logisticInformKey);
    }
    @PostMapping("/order/all")
    public CommonResponse orderAll(){
        return salerManagerService.allOrderList();
    }
@PostMapping("/contract/delete"+  "/{contractid}")
 public  CommonResponse contractDelete(@PathVariable("contractid")int contractid){
        return salerManagerService.deleteContract(contractid);
    }


}
