package com.openbanking.direct.debits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.setApplicationStartup(new FlightRecorderApplicationStartup());
		try {
			application.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
