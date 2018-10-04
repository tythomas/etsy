package com.runnersports.etsy.etsyinfo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersports.etsy.etsyinfo.model.Order;
import com.runnersports.etsy.etsyinfo.model.Orders;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	Orders orders;
	
	@GetMapping("/taxes")
	public ResponseEntity<String> getTaxes() throws IOException {

		List<Order> ordersList = orders.getAll();
		int totalTaxedOrders = 0;
		BigDecimal totalTaxes = new BigDecimal("0");
		BigDecimal totalOrderValue = new BigDecimal("0");
		for (Order order : ordersList) {
			if (order.isILOrder()) {
				totalTaxedOrders++;
				totalTaxes = totalTaxes.add(order.getSalesTax());
				totalOrderValue = totalOrderValue.add(order.getOrderValue());
			}
		}
		
		return new ResponseEntity<String>(totalTaxedOrders + " taxed orders, totalling: " + totalOrderValue + " and withheld " + totalTaxes, HttpStatus.OK);
	}

}
