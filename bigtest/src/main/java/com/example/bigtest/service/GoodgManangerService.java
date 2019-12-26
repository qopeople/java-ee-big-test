package com.example.bigtest.service;

import com.example.bigtest.entity.DispatchList;
import com.example.bigtest.entity.GoodsInform;
import com.example.bigtest.entity.logisticInformKey;
import com.example.bigtest.pojo.vto.GetDispatchOrder;
import com.example.bigtest.pojo.vto.GetGoodsSalary;
import com.example.bigtest.pojo.vto.GetPurchaseList;
import com.example.bigtest.pojo.vto.GetSaleSalary;
import com.example.bigtest.utils.CommonResponse;

public interface GoodgManangerService {

    //生成发货单
    CommonResponse addDispatchOrder(GetDispatchOrder getDispatchOrder);

    //获取发货单列表
    CommonResponse allDispatchOrder();
    //根据id获取发货单信息
    CommonResponse dispatchOrderById(int dispatchlistid);
//    //完成发货更新时间
//    CommonResponse updateDispatch(int dispatchlistid );
    //更改合同项状态
    CommonResponse updateDispatchOrder(GetDispatchOrder getDispatchOrder);

    //获取发货单的全部物流信息
    CommonResponse allLogisticById(int dispatchlistid);
    //添加发货单物流状态
    CommonResponse addLogistic(logisticInformKey logisticInformKey);

    //添加进货单
    CommonResponse addPurchaseList(GetPurchaseList getPurchaseList );
    //获取进货单列表
    CommonResponse allPurchaseList();

    //完成进货单
    CommonResponse updatePurchaseList(GetPurchaseList getPurchaseList);

    //根据销售id获取完成的订单
    CommonResponse getSalaryByClientId(GetSaleSalary getSaleSalary);
    //根据客户id获取某段时间的销售额
    CommonResponse getSalaryBySaleId(GetSaleSalary getSaleSalary);
    //根据商品获取订单
    CommonResponse getSalaryByGoodsId(GetGoodsSalary getGoodsSalary);

    //获取商品信息
    CommonResponse allGoodsList();
    //根据商品信息获取id
    CommonResponse getGoodsById(int goodsid);
    //更新商品信息
    CommonResponse updateGoodsinform(GoodsInform goodsInform);
    //增加商品信息
    CommonResponse addGoods(GoodsInform goodsInform);
    //移除商品信息
    CommonResponse deleteGoods(int goodsid);

}
