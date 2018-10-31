package com.runnersports.etsy.etsydb.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.runnersports.etsy.etsydb.model.Order;

@Configuration
public class OrderConfig {

	@Bean("orders-step")
	public Step loadOrdersStep(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		

	}

	@Bean("orders-reader") 
	public ItemReader<Order> fileReader(@Value("${orders.input}") Resource resource) {

		FlatFileItemReader<Order> reader = new FlatFileItemReader<>();
		reader.setResource(resource);
		reader.setLinesToSkip(1);
		reader.setLineMapper(orderLineMapper());
		return reader;
	}

	private LineMapper<Order> orderLineMapper() {

		DefaultLineMapper<Order> mapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] { "saleDate", "orderId", "nothing", "nothing", "nothing", "nothing", "quantity",
				"nothing", "nothing", "nothing", "nothing", "nothing", "state", "nothing", "nothing", "nothing",
				"orderValue", "nothing", "nothing", "discount", "nothing", "shippingAmount", "salesTax" });

		BeanWrapperFieldSetMapper<Order> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(Order.class);
		beanMapper.setStrict(false);

		mapper.setLineTokenizer(tokenizer);
		mapper.setFieldSetMapper(beanMapper);

		return mapper;
	}

}
