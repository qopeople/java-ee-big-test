package com.example.bigtest.pojo.vto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ChangeItemStatus {
    private String itemstatus;
    private String constractstatus;
    private int contractid;
    private int contractitemid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date contractendtime;

    public Date getContractendtime() {
        return contractendtime;
    }

    public void setContractendtime(Date contractendtime) {
        this.contractendtime = contractendtime;
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus;
    }

    public String getConstractstatus() {
        return constractstatus;
    }

    public void setConstractstatus(String constractstatus) {
        this.constractstatus = constractstatus;
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
}
