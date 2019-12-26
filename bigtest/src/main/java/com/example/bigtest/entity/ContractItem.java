package com.example.bigtest.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ContractItem extends ContractItemKey {
    private int goodsid;

    private String goodsname;

    private int clientid;

    private int goodsnum;

    private Double goodsoutprice;

    private String itemstatus;
    private int needgoodsnum;

    public int getNeedgoodsnum() {
        return needgoodsnum;
    }

    public void setNeedgoodsnum(int needgoodsnum) {
        this.needgoodsnum = needgoodsnum;
    }

    public ContractItem(int contractid, int contractitemid) {
        super(contractid, contractitemid);
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
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
        this.itemstatus = itemstatus;
    }
}