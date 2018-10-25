package com.runnersports.etsy.etsydb;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class EtsyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsyDbApplication.class, args);
	}
}
