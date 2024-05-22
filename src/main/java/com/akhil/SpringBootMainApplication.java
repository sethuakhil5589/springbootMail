package com.akhil;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akhil.Mail.SendMail;

@SpringBootApplication
public class SpringBootMainApplication {
	@Autowired
	private  SendMail email;
	
	private static final Logger logger=LoggerFactory.getLogger(SpringBootMainApplication.class);
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootMainApplication.class, args);
		logger.info("In main method");
		SendMail mail = context.getBean(SendMail.class);
		mail.sendingMails();
		
	}
	
	public  void sendEmail() throws Exception {
		logger.debug("In sendMail method in main class");
		logger.info("In sendMail method in main class");
		email.sendingMails();
	}

}
