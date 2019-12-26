package com.example.bigtest.controller;

import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.ChangeItemStatus;
import com.example.bigtest.pojo.vto.GetClientSalary;
import com.example.bigtest.service.GoodgManangerService;
import com.example.bigtest.service.SalerManagerService;
import com.example.bigtest.service.SalerService;
import com.example.bigtest.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sp")
@Slf4j
public class SalerController {
    @Autowired
    SalerManagerService salerManagerService;
    @Autowired
    GoodgManangerService goodgManangerService;
    @Autowired
    SalerService salerService;
    @PostMapping("/login")
    public CommonResponse login(UserAuthDTO userAuthDTO){
        return salerManagerService.loginSP(userAuthDTO);
    }
    @PostMapping("/contractBySalerId/"+  "/{salerid}")
    public CommonResponse  contractBySalerId(@PathVariable("salerid")int salerid){
        return  salerService.allContractBySalerId(salerid);
    }
    @PostMapping("/findSomeTimeSalaryByClient")
    public CommonResponse findSomeTimeSalaryByClient(GetClientSalary getClientSalary){
        return salerService.findSomeTimeSalaryByClient(getClientSalary);
    }
    @PostMapping("/changeInform")
    public CommonResponse changeInform(UserAuthDTO userAuthDTO){
        return salerService.changeInform(userAuthDTO);
    }
    @PostMapping("/itemStatusOne/update")
    public  CommonResponse itemStatusOne(ChangeItemStatus changeItemStatus){
        return salerManagerService.updateItemStatus(changeItemStatus);
    }
    @PostMapping("/contractStatus/update")
    public CommonResponse contractStatus(ChangeItemStatus changeItemStatus){
        return  salerManagerService.updateContractStatus(changeItemStatus);
    }
    @PostMapping("/orderBySalerId/"+  "{salerid}")
    public  CommonResponse allOrderBySalerId(@PathVariable("salerid")int salerid){
        return salerService.allOrderBySalerId(salerid);
    }

}
