package com.example.bigtest.pojo.vto;

import com.example.bigtest.entity.DispatchList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class GetDispatchOrder {

    private String  itemstatus;
    private int goodsid;
    private int goodsstorenum;
    private int goodsnum;
    private String goodsname;
    private double goodsoutprice;
        private double goodsinprice;
    private  int clientid;

    private int dispatchlistid;

    private int contractid;

    private int contractitemid;

    private String constractstatus;

    private int needgoodsnum;
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

    public String getConstractstatus() {
        return constractstatus;
    }

    public void setConstractstatus(String constractstatus) {
        this.constractstatus = constractstatus;
    }

    public int getNeedgoodsnum() {
        return needgoodsnum;
    }

    public void setNeedgoodsnum(int needgoodsnum) {
        this.needgoodsnum = needgoodsnum;
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getGoodsstorenum() {
        return goodsstorenum;
    }

    public void setGoodsstorenum(int goodsstorenum) {
        this.goodsstorenum = goodsstorenum;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsoutprice() {
        return goodsoutprice;
    }

    public void setGoodsoutprice(double goodsoutprice) {
        this.goodsoutprice = goodsoutprice;
    }

    public double getGoodsinprice() {
        return goodsinprice;
    }

    public void setGoodsinprice(double goodsinprice) {
        this.goodsinprice = goodsinprice;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getDispatchlistid() {
        return dispatchlistid;
    }

    public void setDispatchlistid(int dispatchlistid) {
        this.dispatchlistid = dispatchlistid;
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
