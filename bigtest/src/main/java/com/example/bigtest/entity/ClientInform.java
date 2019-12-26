 package com.example.bigtest.entity;

 import lombok.Data;
 import lombok.NoArgsConstructor;

 @Data
 @NoArgsConstructor
public class ClientInform {
    private int clientid;
    private String clientname;

    private String clienttel;

    private String address;

}