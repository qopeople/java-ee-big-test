package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractItemKey {
    private int contractid;

    private int contractitemid;
    public ContractItemKey(int contractid,int contractitemid){
        this.contractid =contractid;
        this.contractitemid =contractitemid;
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