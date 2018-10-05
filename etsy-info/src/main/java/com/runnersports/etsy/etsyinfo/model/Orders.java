package com.runnersports.etsy.etsyinfo.model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class Orders {

	private List<Order> orders;
	
	public List<Order> getAll() throws IOException {
		if (orders == null) {
			Reader in = new FileReader("c:\\Users\\u386361\\Downloads\\EtsySoldOrders2018.csv");
			orders = new ArrayList<Order>();
			
			for (CSVRecord record : CSVFormat.RFC4180.withHeader().parse(in)) {
				orders.add(new Order(record));
			}
		}
		return orders;
	}

	public OrderSummary findAllILOrders() throws IOException {
		
		OrderSummary ilOrders = new OrderSummary();
		for (Order order : this.getAll()) {
			if (order.isILOrder()) {
				ilOrders.add(order);
			}
		}
		return ilOrders;
	}

	public OrderSummary findAllOrders() throws IOException {
		OrderSummary allOrders = new OrderSummary();
		for (Order order : this.getAll()) {
			allOrders.add(order);
		}
		return allOrders;
	}

}
