package com.TicketingSystem.RealTime_Ticketing_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RealTimeTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeTicketingSystemApplication.class, args);
	}

}
