package com.example.demo.smscontroller;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
 

@Data
public class SmsRequest {

   
    private final String phoneNumber; // destination

   
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
 

}
