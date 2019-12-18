package com.test.entity;

public class StoreManager {
    private String storemangerid;

    private String storemanagerpassword;

    private String storemangername;

    private String storemangertel;

    public String getStoremangerid() {
        return storemangerid;
    }

    public void setStoremangerid(String storemangerid) {
        this.storemangerid = storemangerid == null ? null : storemangerid.trim();
    }

    public String getStoremanagerpassword() {
        return storemanagerpassword;
    }

    public void setStoremanagerpassword(String storemanagerpassword) {
        this.storemanagerpassword = storemanagerpassword == null ? null : storemanagerpassword.trim();
    }

    public String getStoremangername() {
        return storemangername;
    }

    public void setStoremangername(String storemangername) {
        this.storemangername = storemangername == null ? null : storemangername.trim();
    }

    public String getStoremangertel() {
        return storemangertel;
    }

    public void setStoremangertel(String storemangertel) {
        this.storemangertel = storemangertel == null ? null : storemangertel.trim();
    }
}