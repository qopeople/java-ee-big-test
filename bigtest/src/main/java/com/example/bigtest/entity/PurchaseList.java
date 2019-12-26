package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class PurchaseList {
    private int purchaseid;



    private int contractid;

    private int contractitemid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date intime;

    private int realgoodsnum;

    public int getRealgoodsnum() {
        return realgoodsnum;
    }

    public void setRealgoodsnum(int realgoodsnum) {
        this.realgoodsnum = realgoodsnum;
    }

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    public int getContractitemid() {
        return contractitemid;
    }

    public void setContractitemid(int contractitemid) {
        this.contractitemid = contractitemid;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }
}