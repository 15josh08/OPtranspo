package com.lostandfound.OPtranspo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailsender;
	
	@Value("$(spring.mail.username)")
	private String fromEmailId;
	
	public  ResponseEntity<String> sendEmail(String recipient) {
		SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
		simpleMailMessage.setFrom(fromEmailId);
		simpleMailMessage.setTo(recipient);
		simpleMailMessage.setText("This is to inform you that you may have lost an item on your one of the rides with us. If that is the case please visit out website, search for the item and claim it or contact us on (###-###-####) for further action regarding this.");
		simpleMailMessage.setSubject("Regarding a lost item.");
		
		javaMailsender.send(simpleMailMessage);
		return ResponseEntity.ok("The email is sent successfully.");
	}
}
	
