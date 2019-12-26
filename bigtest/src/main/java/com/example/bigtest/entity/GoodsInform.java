package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsInform {
    private int goodsid;

    private int goodsstorenum;

    private String goodsname;

    private double goodsinprice;

    private double goodsoutprice;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getGoodsstorenum() {
        return goodsstorenum;
    }

    public void setGoodsstorenum(int goodsstorenum) {
        this.goodsstorenum = goodsstorenum;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Double getGoodsinprice() {
        return goodsinprice;
    }

    public void setGoodsinprice(Double goodsinprice) {
        this.goodsinprice = goodsinprice;
    }

    public double getGoodsoutprice() {
        return goodsoutprice;
    }

    public void setGoodsoutprice(double goodsoutprice) {
        this.goodsoutprice = goodsoutprice;
    }
}