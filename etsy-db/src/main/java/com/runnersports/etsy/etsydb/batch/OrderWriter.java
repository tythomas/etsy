package com.runnersports.etsy.etsydb.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.Order;
import com.runnersports.etsy.etsydb.repository.OrderRepository;

@Component
public class OrderWriter implements ItemWriter<Order> {

	@Autowired
	private OrderRepository repository;
	
	@Override
	public void write(List<? extends Order> orders) throws Exception {
		
		repository.saveAll(orders);
	}

	
}
