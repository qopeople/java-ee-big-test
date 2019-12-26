package com.example.bigtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class  logisticInformKey {
    private int dispatchlistid;

    private String currentpostion;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date steptime;

    public int getDispatchlistid() {
        return dispatchlistid;
    }

    public void setDispatchlistid(int dispatchlistid) {
        this.dispatchlistid = dispatchlistid;
    }

    public String getCurrentpostion() {
        return currentpostion;
    }

    public void setCurrentpostion(String currentpostion) {
        this.currentpostion = currentpostion;
    }

    public Date getSteptime() {
        return steptime;
    }

    public void setSteptime(Date steptime) {
        this.steptime = steptime;
    }
}