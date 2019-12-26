package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalerManager {
    private int salemanagerid;

    private String password;
    private String username;

    private String salemanagername;

    private String salermanagertel;

    public int getSalemanagerid() {
        return salemanagerid;
    }

    public void setSalemanagerid(int salemanagerid) {
        this.salemanagerid = salemanagerid;
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

    public String getSalemanagername() {
        return salemanagername;
    }

    public void setSalemanagername(String salemanagername) {
        this.salemanagername = salemanagername;
    }

    public String getSalermanagertel() {
        return salermanagertel;
    }

    public void setSalermanagertel(String salermanagertel) {
        this.salermanagertel = salermanagertel;
    }
}