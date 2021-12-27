package com.cgi.workbasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class WorkBasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkBasketApplication.class, args);
	}
}
