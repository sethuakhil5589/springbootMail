package com.akhil.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements IMainService{
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private static final Logger logger=LoggerFactory.getLogger(MailServiceImpl.class);
	@Value("{spring.mail.username}")
	String from;
	@Override
	public String sendingMail(String[] items, Double[] prices, String[] mails) throws Exception {
		Double amount=0.0;
		for(Double price:prices) {
			amount=amount+price;
		}
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		logger.info("control is in service method...");
		helper.setSubject("Bill for the items");
		helper.setTo(mails);
		helper.setFrom(from);
		
		
		for (String item:items) {
			helper.setText(item);
		}
		String message="Hello your bill: "+Arrays.toString(items)+" price: "+amount;
		helper.setText(message);
		logger.info("Control is before the return statement");
		sender.send(mimeMessage);
		return "Mail sent Successfully!";
	}

}
