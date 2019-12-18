package com.test.entity;

public class ContractItem extends ContractItemKey {
    private String goodsid;

    private String goodsname;

    private String clientid;

    private Integer goodsnum;

    private Double goodsoutprice;

    private String itemstatus;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Double getGoodsoutprice() {
        return goodsoutprice;
    }

    public void setGoodsoutprice(Double goodsoutprice) {
        this.goodsoutprice = goodsoutprice;
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus == null ? null : itemstatus.trim();
    }
}