package com.akhil.Mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.akhil.service.MailServiceImpl;

@Component
public class SendMail {
	@Autowired
	private MailServiceImpl service;
	@Autowired
	private static final Logger logger=LoggerFactory.getLogger(MailServiceImpl.class);
	public String sendingMails() {
		logger.info("Control is in Sending mails method");
		String [] items= {"Java","Spring","Hibernate","Docker"};
		Double [] prices= {4999.0,5999.0,2599.9,2999.9};
		String [] emails= {"basavapatrunisusmi123@gmail.com","sethuakhil5589@gmail.com","basavapatrunisusmitha@gmail.com"};
		logger.info("Control is before return statement of Sending mails method");
		try {
			 String mail = service.sendingMail(items, prices, emails);
		} catch (Exception e) {
			System.out.println("Exception in sendingMail method.");
			e.printStackTrace();
		}
		return "Mail sent ";
	}
}
