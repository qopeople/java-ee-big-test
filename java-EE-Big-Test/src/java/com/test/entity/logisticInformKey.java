package com.test.entity;

public class logisticInformKey {
    private String logisticid;

    private String currentpostion;

    public String getLogisticid() {
        return logisticid;
    }

    public void setLogisticid(String logisticid) {
        this.logisticid = logisticid == null ? null : logisticid.trim();
    }

    public String getCurrentpostion() {
        return currentpostion;
    }

    public void setCurrentpostion(String currentpostion) {
        this.currentpostion = currentpostion == null ? null : currentpostion.trim();
    }
}