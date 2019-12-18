package com.test.entity;

public class ContractItemKey {
    private String contractid;

    private String contractitemid;

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid == null ? null : contractid.trim();
    }

    public String getContractitemid() {
        return contractitemid;
    }

    public void setContractitemid(String contractitemid) {
        this.contractitemid = contractitemid == null ? null : contractitemid.trim();
    }
}