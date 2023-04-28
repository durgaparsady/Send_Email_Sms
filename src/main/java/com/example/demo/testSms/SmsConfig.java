package com.example.demo.testSms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@NoArgsConstructor
public class SmsConfig {
	private String accountSid;
	private String authToken;
	private String trialNumber;

}
