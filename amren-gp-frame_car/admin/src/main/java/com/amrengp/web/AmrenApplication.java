package com.amrengp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@ComponentScan({"com.amrengp"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AmrenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmrenApplication.class, args);
	}
}
