package com.infosys.infytel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CustMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustMsApplication.class, args);
	}

}
