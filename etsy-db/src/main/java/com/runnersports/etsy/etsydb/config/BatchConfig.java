package com.runnersports.etsy.etsydb.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public Job job(JobBuilderFactory jobFactory,
			@Qualifier("orders-step") Step orderStep,
			@Qualifier("listings-step") Step listingStep
			) {
		
		return jobFactory.get("load-data")
			.incrementer(new RunIdIncrementer())
			.start(orderStep)
			.next(listingStep)
			.build();
	}

}
