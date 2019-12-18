package com.test.entity;

import java.util.Date;

public class SalePerson {
    private String salerid;

    private String salepassword;

    private String salername;

    private String salertel;

    private Date reportdutytime;

    public String getSalerid() {
        return salerid;
    }

    public void setSalerid(String salerid) {
        this.salerid = salerid == null ? null : salerid.trim();
    }

    public String getSalepassword() {
        return salepassword;
    }

    public void setSalepassword(String salepassword) {
        this.salepassword = salepassword == null ? null : salepassword.trim();
    }

    public String getSalername() {
        return salername;
    }

    public void setSalername(String salername) {
        this.salername = salername == null ? null : salername.trim();
    }

    public String getSalertel() {
        return salertel;
    }

    public void setSalertel(String salertel) {
        this.salertel = salertel == null ? null : salertel.trim();
    }

    public Date getReportdutytime() {
        return reportdutytime;
    }

    public void setReportdutytime(Date reportdutytime) {
        this.reportdutytime = reportdutytime;
    }
}