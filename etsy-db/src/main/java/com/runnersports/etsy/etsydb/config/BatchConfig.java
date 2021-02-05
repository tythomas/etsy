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
			@Qualifier("orders-step-2012") Step orderStep2012,
			@Qualifier("orders-step-2013") Step orderStep2013,
			@Qualifier("orders-step-2014") Step orderStep2014,
			@Qualifier("orders-step-2015") Step orderStep2015,
			@Qualifier("orders-step-2016") Step orderStep2016,
			@Qualifier("orders-step-2017") Step orderStep2017,
			@Qualifier("orders-step-2018") Step orderStep2018,
			@Qualifier("orders-step-2019") Step orderStep2019,
			@Qualifier("orders-step-2020") Step orderStep2020,
			@Qualifier("orders-step-2021") Step orderStep2021,
			@Qualifier("listings-step") Step listingStep
			) {
		
		return jobFactory.get("load-data")
			.incrementer(new RunIdIncrementer())
			.start(orderStep2012)
			.next(orderStep2013)
			.next(orderStep2014)
			.next(orderStep2015)
			.next(orderStep2016)
			.next(orderStep2017)
			.next(orderStep2018)
			.next(orderStep2019)
			.next(orderStep2020)
			.next(orderStep2021)
			.next(listingStep)
			.build();
	}

}
