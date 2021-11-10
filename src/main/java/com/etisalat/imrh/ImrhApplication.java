package com.etisalat.imrh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nabeel Ahmed
 */
@SpringBootApplication
//http://localhost:8080/swagger-ui.html
public class ImrhApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(ImrhApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ImrhApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	}
}
