package com.runnersports.etsy.etsydb;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersports.etsy.etsydb.model.OrderSummary;
import com.runnersports.etsy.etsydb.repository.OrderSummaryRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	@GetMapping("/iltax")
	public ResponseEntity<String> getTaxes() throws IOException {
		return new ResponseEntity<String>(orderSummaryRepository.getILSalesTax().toString(), HttpStatus.OK);
	}
	
	@GetMapping("/statesummary")
	public ResponseEntity<List<OrderSummary>> getStateSummary() throws IOException {
		return new ResponseEntity<List<OrderSummary>>(orderSummaryRepository.getSummaryByState(), HttpStatus.OK);
	}
	
	@GetMapping("/allorders")
	public ResponseEntity<List<OrderSummary>> getAllOrderSummary() throws IOException {
		return new ResponseEntity<List<OrderSummary>>(orderSummaryRepository.getAllSales(), HttpStatus.OK);
	}
}
