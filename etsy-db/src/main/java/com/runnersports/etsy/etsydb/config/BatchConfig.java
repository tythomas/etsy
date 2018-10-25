package com.runnersports.etsy.etsydb.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.runnersports.etsy.etsydb.model.EtsyOrder;

@Configuration
public class BatchConfig {

	@Bean
	public Job job(JobBuilderFactory jobFactory, 
			StepBuilderFactory stepFactory,
			ItemReader<EtsyOrder> reader,
			ItemProcessor<EtsyOrder, EtsyOrder> processor,
			ItemWriter<EtsyOrder> writer) {
		
		Step step = stepFactory.get("step1")
				.<EtsyOrder, EtsyOrder>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		
		return jobFactory.get("load")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
	}
	
	@Bean
	public FlatFileItemReader<EtsyOrder> fileReader(@Value("${input}") Resource resource) {
		
		FlatFileItemReader<EtsyOrder> reader = new FlatFileItemReader<>();
		reader.setResource(resource);
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}

	private LineMapper<EtsyOrder> lineMapper() {
		
		DefaultLineMapper<EtsyOrder> mapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] {"saleDate", "orderId","nothing","nothing","nothing","nothing","quantity","nothing","nothing","nothing","nothing","nothing","state","nothing","nothing","nothing","orderValue","nothing","nothing","discount","nothing","shippingAmount","salesTax"});
//		tokenizer.setNames(new String[] {"saleDate", "orderId","a","b","c","d","e","f","g","h","i","j","state"});
//		tokenizer.setNames(new String[] 
//				{"saleDate","orderId","Buyer","User ID","Full Name","First Name","Last Name","Number of Items","Payment Method","Date Shipped","Street 1","Street 2","Ship City","Ship State","Ship Zipcode","Ship Country","Currency","Order Value","Coupon Code","Coupon Details","Discount Amount","Shipping Discount","Shipping","Sales Tax","Order Total","Status","Card Processing Fees","Order Net","Adjusted Order Total","Adjusted Card Processing Fees","Adjusted Net Order Amount","Buyer","Order Type","Payment Type"
//				}
//		);
		
		BeanWrapperFieldSetMapper<EtsyOrder> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(EtsyOrder.class);
		beanMapper.setStrict(false);
		
		mapper.setLineTokenizer(tokenizer);
		mapper.setFieldSetMapper(beanMapper);
		
		return mapper;
	}
}
