package com.example.bigtest.controller;

import com.example.bigtest.entity.GoodsInform;
import com.example.bigtest.entity.logisticInformKey;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.service.GoodgManangerService;
import com.example.bigtest.service.SalerManagerService;
import com.example.bigtest.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stm")
@Slf4j
public class StoreManagerController {
    @Autowired
    SalerManagerService salerManagerService;
    @Autowired
    GoodgManangerService goodgManangerService;
    @PostMapping("/logisticById/all"+  "/{dispatchlistid}")
    public CommonResponse logisticByIdAll(@PathVariable("dispatchlistid")int dispatchlistid){
        return  goodgManangerService.allLogisticById(dispatchlistid);
    }
    @PostMapping("/logistic/add")
    public CommonResponse logisticAdd(logisticInformKey logisticInformKey){
        return  goodgManangerService.addLogistic(logisticInformKey);
    }
    @PostMapping("/login")
    public CommonResponse login( UserAuthDTO userAuthDTO){
        return salerManagerService.loginSTM(userAuthDTO);
    }

    @PostMapping("/goods/add")
    public  CommonResponse goodsAdd(GoodsInform goodsInform){
        return goodgManangerService.addGoods(goodsInform);
    }
    @PostMapping("/goods/delete"+  "/{goodsid}")
    public CommonResponse goodsDelete(@PathVariable("goodsid")int goodsid){
        return  goodgManangerService.deleteGoods((goodsid));
    }
}
