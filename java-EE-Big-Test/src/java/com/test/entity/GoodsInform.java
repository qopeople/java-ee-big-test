package com.test.entity;

public class GoodsInform {
    private String goodsid;

    private Integer goodsstorenum;

    private String goodsname;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public Integer getGoodsstorenum() {
        return goodsstorenum;
    }

    public void setGoodsstorenum(Integer goodsstorenum) {
        this.goodsstorenum = goodsstorenum;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }
}