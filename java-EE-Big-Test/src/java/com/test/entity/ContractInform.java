package com.test.entity;

import java.util.Date;

public class ContractInform {
    private String contractid;

    private String customerid;

    private String customername;

    private String salerid;

    private String contractname;

    private Date contractcreatetime;

    private Date contractstarttime;

    private Date contractendtime;

    private String constractstatus;

    private String contractremark;

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid == null ? null : contractid.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getSalerid() {
        return salerid;
    }

    public void setSalerid(String salerid) {
        this.salerid = salerid == null ? null : salerid.trim();
    }

    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname == null ? null : contractname.trim();
    }

    public Date getContractcreatetime() {
        return contractcreatetime;
    }

    public void setContractcreatetime(Date contractcreatetime) {
        this.contractcreatetime = contractcreatetime;
    }

    public Date getContractstarttime() {
        return contractstarttime;
    }

    public void setContractstarttime(Date contractstarttime) {
        this.contractstarttime = contractstarttime;
    }

    public Date getContractendtime() {
        return contractendtime;
    }

    public void setContractendtime(Date contractendtime) {
        this.contractendtime = contractendtime;
    }

    public String getConstractstatus() {
        return constractstatus;
    }

    public void setConstractstatus(String constractstatus) {
        this.constractstatus = constractstatus == null ? null : constractstatus.trim();
    }

    public String getContractremark() {
        return contractremark;
    }

    public void setContractremark(String contractremark) {
        this.contractremark = contractremark == null ? null : contractremark.trim();
    }
}