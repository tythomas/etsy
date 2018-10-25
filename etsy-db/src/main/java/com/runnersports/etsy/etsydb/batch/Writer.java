package com.runnersports.etsy.etsydb.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.EtsyOrder;
import com.runnersports.etsy.etsydb.repository.OrderRepository;

@Component
public class Writer implements ItemWriter<EtsyOrder> {

	@Autowired
	private OrderRepository repository;
	
	@Override
	public void write(List<? extends EtsyOrder> orders) throws Exception {
		
		repository.saveAll(orders);
	}

	
}
