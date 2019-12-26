package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class ContractInform {
    private int contractid;

    private int clientid;

    private String clientname;

    private int salerid;

    private String contractname;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date contractcreatetime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date contractstarttime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date contractendtime;

    private String constractstatus;

    private String contractremark;

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public int getSalerid() {
        return salerid;
    }

    public void setSalerid(int salerid) {
        this.salerid = salerid;
    }

    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
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
        this.constractstatus = constractstatus;
    }

    public String getContractremark() {
        return contractremark;
    }

    public void setContractremark(String contractremark) {
        this.contractremark = contractremark;
    }
}