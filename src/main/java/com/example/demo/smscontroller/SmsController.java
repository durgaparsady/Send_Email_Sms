package com.example.demo.smscontroller;
  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
//@Slf4j                             //ye annotation ye niche Logger class me ye class load karne ke liye he fhir ye niche vali line nahi likhni hogi
public class SmsController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SmsController.class);

	@Autowired
	private TwilioProperty twilioProperty;
//	private String generateOTP() {
//		return new DecimalFormat("000000").format(new Random().nextInt(999999));
//	}

	@PostMapping("/send-sms-twilio")
    public ResponseEntity<String> sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		
		System.err.println(twilioProperty.getAccountSid());
		System.err.println(twilioProperty.getAuthToken());
		System.err.println(twilioProperty.getTrialNumber());
		
		 Twilio.init(
	        		twilioProperty.getAccountSid(),   //Account SID
	        		twilioProperty.getAuthToken()     //TWILIO_AUTH_TOKEN
	        );
		
		 
 
        if (smsRequest.getPhoneNumber()!=null) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioProperty.getTrialNumber());
            
//            MessageCreator creator = Message.creator(to, from, smsRequest.getMessage());
//            creator.create();
            
          Message.creator(new PhoneNumber(smsRequest.getPhoneNumber()),             //to
    		        new PhoneNumber(twilioProperty.getTrialNumber()),                //from
    		        smsRequest.getMessage()).create();     //genrateOTP()+"Otp is "                          //message
            
            LOGGER.info("SMS send Successfuly", smsRequest.getMessage());     //server ke console ke liye info, warn
            
            return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
        } else {
                  throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
        }
    }

	
   
}
