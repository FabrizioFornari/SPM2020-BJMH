package com.policeman.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@ComponentScan({"com.amrengp"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PolicemanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicemanApplication.class, args);
	}
}
