package com.runnersports.etsy.etsyinfo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersports.etsy.etsyinfo.model.OrderSummary;
import com.runnersports.etsy.etsyinfo.model.Orders;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	Orders orders;
	
	@GetMapping("/taxes")
	public ResponseEntity<String> getTaxes() throws IOException {

		OrderSummary ilOrders = orders.findAllILOrders();
		
		return new ResponseEntity<String>(ilOrders.summaryWithTaxes(), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<String> getAll() throws IOException {

		OrderSummary allOrders = orders.findAllOrders();
		
		return new ResponseEntity<String>(allOrders.summary(), HttpStatus.OK);
	}

}
