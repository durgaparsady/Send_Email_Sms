package com.example.demo.testSms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class SmsDto {
	private String phoneNumber;
	private String message;

}
