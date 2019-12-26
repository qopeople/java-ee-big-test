package com.example.bigtest.service;

import com.example.bigtest.entity.SalePerson;
import com.example.bigtest.pojo.dto.UserAuthDTO;
import com.example.bigtest.pojo.vto.GetClientSalary;
import com.example.bigtest.pojo.vto.GetSaleSalary;
import com.example.bigtest.utils.CommonResponse;

public interface SalerService {
    //通过销售id查询合同信息
    CommonResponse allContractBySalerId(int salerid);
//    更改信息
    CommonResponse changeInform(UserAuthDTO userAuthDTO);
    //获取客户id的一段销售总额
    CommonResponse findSomeTimeSalaryByClient(GetClientSalary getClientSalary);
    //查询销售id所完成的订单
    CommonResponse allOrderBySalerId(int salerid);
    //获取销售id在一段时间内的销售额
//    CommonResponse findSomeTimeSalaryBySaler(GetSaleSalary getSaleSalary);

}
