package com.runnersports.etsy.etsydb.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.Listing;
import com.runnersports.etsy.etsydb.repository.ListingRepository;

@Component
public class ListingWriter implements ItemWriter<Listing> {

	@Autowired
	private ListingRepository repository;
	
	@Override
	public void write(List<? extends Listing> listings) throws Exception {
		
		repository.saveAll(listings);
	}

	
}
