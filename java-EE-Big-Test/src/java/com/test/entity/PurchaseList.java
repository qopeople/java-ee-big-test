package com.test.entity;

import java.util.Date;

public class PurchaseList {
    private String purchaseid;

    private String storemangerid;

    private String constractid;

    private String contractitemid;

    private Date intime;

    private Double goodsinprice;

    private Double allcost;

    public String getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(String purchaseid) {
        this.purchaseid = purchaseid == null ? null : purchaseid.trim();
    }

    public String getStoremangerid() {
        return storemangerid;
    }

    public void setStoremangerid(String storemangerid) {
        this.storemangerid = storemangerid == null ? null : storemangerid.trim();
    }

    public String getConstractid() {
        return constractid;
    }

    public void setConstractid(String constractid) {
        this.constractid = constractid == null ? null : constractid.trim();
    }

    public String getContractitemid() {
        return contractitemid;
    }

    public void setContractitemid(String contractitemid) {
        this.contractitemid = contractitemid == null ? null : contractitemid.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Double getGoodsinprice() {
        return goodsinprice;
    }

    public void setGoodsinprice(Double goodsinprice) {
        this.goodsinprice = goodsinprice;
    }

    public Double getAllcost() {
        return allcost;
    }

    public void setAllcost(Double allcost) {
        this.allcost = allcost;
    }
}