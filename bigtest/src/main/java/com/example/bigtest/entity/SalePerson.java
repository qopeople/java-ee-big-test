package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class SalePerson {
    private int salerid;

    private String password;
    private String username;

    private String salername;

    private String salertel;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reportdutytime;

    public int getSalerid() {
        return salerid;
    }

    public void setSalerid(int salerid) {
        this.salerid = salerid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalername() {
        return salername;
    }

    public void setSalername(String salername) {
        this.salername = salername;
    }

    public String getSalertel() {
        return salertel;
    }

    public void setSalertel(String salertel) {
        this.salertel = salertel;
    }

    public Date getReportdutytime() {
        return reportdutytime;
    }

    public void setReportdutytime(Date reportdutytime) {
        this.reportdutytime = reportdutytime;
    }
}