package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class DispatchList {
    private int dispatchlistid;

    private int contractid;

    private int contractitemid;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date starttime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endtime;
    private int realgoodsnum;



    public int getRealgoodsnum() {
        return realgoodsnum;
    }

    public void setRealgoodsnum(int realgoodsnum) {
        this.realgoodsnum = realgoodsnum;
    }

    public int getDispatchlistid() {
        return dispatchlistid;
    }

    public void setDispatchlistid(int dispatchlistid) {
        this.dispatchlistid = dispatchlistid;
    }

    public int getcontractid() {
        return contractid;
    }

    public void setcontractid(int contractid) {
        this.contractid = contractid;
    }

    public int getContractitemid() {
        return contractitemid;
    }

    public void setContractitemid(int contractitemid) {
        this.contractitemid = contractitemid;
    }


    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}