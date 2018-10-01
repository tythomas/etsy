package com.runnersports.etsy.etsyinfo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@GetMapping("/taxes")
	public ResponseEntity<String> getTaxes() throws IOException {

		Iterable<CSVRecord> records = getRecords();
		int totalTaxedOrders = 0;
		BigDecimal totalTaxes = new BigDecimal("0");
		BigDecimal totalOrderValue = new BigDecimal("0");
		for (CSVRecord record : records) {
			String state = record.get("Ship State");
			if ("IL".equals(state)) {
				totalTaxedOrders++;
				totalTaxes = totalTaxes.add(new BigDecimal(record.get("Sales Tax")));
				totalOrderValue = totalOrderValue.add(new BigDecimal(record.get("Order Value")));
			}
		}
		
		return new ResponseEntity<String>(totalTaxedOrders + " taxed orders, totalling: " + totalOrderValue + " and withheld " + totalTaxes, HttpStatus.OK);
	}

	private Iterable<CSVRecord> getRecords() throws IOException {
		Reader in = new FileReader("c:\\Users\\u386361\\Downloads\\EtsySoldOrders2018.csv");
		return CSVFormat.RFC4180.withHeader().parse(in);
	}
}
