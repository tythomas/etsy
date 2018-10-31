package com.runnersports.etsy.etsydb.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.Order;

@Component
public class OrderProcessor implements ItemProcessor<Order, Order>{

	@Override
	public Order process(Order item) throws Exception {
		
		return item;
	}
}
