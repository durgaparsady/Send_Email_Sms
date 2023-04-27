package com.example.demo.smscontroller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@NoArgsConstructor
public class TwilioProperty {

    private String accountSid;
    private String authToken;
    private String trialNumber;

}
