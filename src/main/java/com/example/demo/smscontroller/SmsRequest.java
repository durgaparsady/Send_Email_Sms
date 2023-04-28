package com.example.demo.smscontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {

	private String phoneNumber; // destination
	private String message;

//    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
//                      @JsonProperty("message") String message) {
//        this.phoneNumber = phoneNumber;
//        this.message = message;
//    }

}
