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
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.runnersports.etsy.etsydb.model.Listing;

@Configuration
public class ListingConfig {

	@Bean("listings-step")
	public Step loadOrdersStep(StepBuilderFactory stepFactory, 
			@Qualifier("listings-reader") ItemReader<Listing> reader,
			ItemProcessor<Listing, Listing> processor, 
			ItemWriter<Listing> writer) {

		return stepFactory.get("load-listings")
				.<Listing, Listing>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		

	}

	@Bean("listings-reader") 
	public ItemReader<Listing> fileReader(@Value("${listings.input}") Resource resource) {

		FlatFileItemReader<Listing> reader = new FlatFileItemReader<>();
		reader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
		reader.setResource(resource);
		reader.setLinesToSkip(1);
		reader.setLineMapper(orderLineMapper());
		return reader;
	}

	private LineMapper<Listing> orderLineMapper() {

		DefaultLineMapper<Listing> mapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] { "title", "description", "price", "nothing", "quantity", "nothing", "nothing", 
				"pic1","pic2","pic3","pic4","pic5","pic6","pic7","pic8","pic9","pic10",
				});

		BeanWrapperFieldSetMapper<Listing> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(Listing.class);
		beanMapper.setStrict(false);

		mapper.setLineTokenizer(tokenizer);
		mapper.setFieldSetMapper(beanMapper);

		return mapper;
	}

}
