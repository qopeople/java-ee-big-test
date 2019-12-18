package com.test.entity;

import java.util.Date;

public class DispatchList {
    private String dispatchlistid;

    private String constractid;

    private String contractitemid;

    private String storemangerid;

    private String goodsliststatus;

    private String logisticid;

    private Date starttime;

    private Date endtime;

    public String getDispatchlistid() {
        return dispatchlistid;
    }

    public void setDispatchlistid(String dispatchlistid) {
        this.dispatchlistid = dispatchlistid == null ? null : dispatchlistid.trim();
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

    public String getStoremangerid() {
        return storemangerid;
    }

    public void setStoremangerid(String storemangerid) {
        this.storemangerid = storemangerid == null ? null : storemangerid.trim();
    }

    public String getGoodsliststatus() {
        return goodsliststatus;
    }

    public void setGoodsliststatus(String goodsliststatus) {
        this.goodsliststatus = goodsliststatus == null ? null : goodsliststatus.trim();
    }

    public String getLogisticid() {
        return logisticid;
    }

    public void setLogisticid(String logisticid) {
        this.logisticid = logisticid == null ? null : logisticid.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}