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

	@Bean("orders-step-2012")
	public Step loadOrdersStep2012(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2012") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2012")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2013")
	public Step loadOrdersStep2013(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2013") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2013")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2014")
	public Step loadOrdersStep2014(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2014") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2014")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2015")
	public Step loadOrdersStep2015(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2015") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2015")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2016")
	public Step loadOrdersStep2016(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2016") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2016")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2017")
	public Step loadOrdersStep2017(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2017") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2017")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2018")
	public Step loadOrdersStep2018(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2018") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2018")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean("orders-step-2019")
	public Step loadOrdersStep2019(StepBuilderFactory stepFactory, 
			@Qualifier("orders-reader-2019") ItemReader<Order> reader,
			ItemProcessor<Order, Order> processor, 
			ItemWriter<Order> writer) {

		return stepFactory.get("load-orders-2019")
				.<Order, Order>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		

	}

	@Bean("orders-reader-2019") 
	public ItemReader<Order> fileReader2019(@Value("${orders.input.2019}") Resource resource) {

		return getFileReader(resource);
	}
	
	@Bean("orders-reader-2018") 
	public ItemReader<Order> fileReader2018(@Value("${orders.input.2018}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2017") 
	public ItemReader<Order> fileReader2017(@Value("${orders.input.2017}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2016") 
	public ItemReader<Order> fileReader2016(@Value("${orders.input.2016}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2015") 
	public ItemReader<Order> fileReader2015(@Value("${orders.input.2015}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2014") 
	public ItemReader<Order> fileReader2014(@Value("${orders.input.2014}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2013") 
	public ItemReader<Order> fileReader2013(@Value("${orders.input.2013}") Resource resource) {

		return getFileReader(resource);
	}

	@Bean("orders-reader-2012") 
	public ItemReader<Order> fileReader2012(@Value("${orders.input.2012}") Resource resource) {

		return getFileReader(resource);
	}

	private ItemReader<Order> getFileReader(Resource resource) {
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
