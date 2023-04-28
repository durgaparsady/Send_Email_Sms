package com.example.demo.testSms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class TestSms {

	@Autowired
	private SmsConfig config;

	 

	@PostMapping("/sendingSms")
	public String sendSms(@RequestBody SmsDto smsData) {
		System.err.println(config.getAccountSid());
		System.err.println(config.getAuthToken());
		System.err.println(config.getTrialNumber());

		Twilio.init(config.getAccountSid(), config.getAuthToken());
		try {

			if (smsData.getPhoneNumber() != null) {
				PhoneNumber to = new PhoneNumber(smsData.getPhoneNumber());
				PhoneNumber from = new PhoneNumber(config.getTrialNumber());

				Message.creator(to, from, smsData.getMessage()).create();
				return "Send Message Successfull";
			}else {
				return "Please Enter Number";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Number is Not valid";
		}

	}

}
