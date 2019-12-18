package com.test.entity;

public class SalerManager {
    private String salemanagerid;

    private String salemanagerpassword;

    private String salemanagername;

    private String salermanagertel;

    public String getSalemanagerid() {
        return salemanagerid;
    }

    public void setSalemanagerid(String salemanagerid) {
        this.salemanagerid = salemanagerid == null ? null : salemanagerid.trim();
    }

    public String getSalemanagerpassword() {
        return salemanagerpassword;
    }

    public void setSalemanagerpassword(String salemanagerpassword) {
        this.salemanagerpassword = salemanagerpassword == null ? null : salemanagerpassword.trim();
    }

    public String getSalemanagername() {
        return salemanagername;
    }

    public void setSalemanagername(String salemanagername) {
        this.salemanagername = salemanagername == null ? null : salemanagername.trim();
    }

    public String getSalermanagertel() {
        return salermanagertel;
    }

    public void setSalermanagertel(String salermanagertel) {
        this.salermanagertel = salermanagertel == null ? null : salermanagertel.trim();
    }
}