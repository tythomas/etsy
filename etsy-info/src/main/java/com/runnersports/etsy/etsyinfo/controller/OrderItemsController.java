package com.runnersports.etsy.etsyinfo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitem")
public class OrderItemsController {

	@GetMapping("/history")
	public ResponseEntity<String> getTaxes(@RequestParam("keyword") String keyword) throws IOException, ParseException {

		SimpleDateFormat saleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM-MMM");
		
		Map<String, Integer> month = new TreeMap<String, Integer>();
		
		Iterable<CSVRecord> records = getRecords();
		for (CSVRecord record : records) {
			String title = record.get("Item Name");
			if (title.contains(keyword)) {
				Date soldDate = saleDateFormat.parse(record.get("Sale Date"));
				Integer monthCount = month.get(monthFormat.format(soldDate));
				if (monthCount == null) monthCount = new Integer(0);
				month.put(monthFormat.format(soldDate), ++monthCount);
			}
		}
		
		for (String key : month.keySet()) {
			System.out.println(key + ": " + month.get(key));
		}
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	private Iterable<CSVRecord> getRecords() throws IOException {
		Reader in = new FileReader("c:\\Users\\u386361\\Downloads\\EtsySoldOrderItems2018.csv");
		return CSVFormat.RFC4180.withHeader().parse(in);
	}
}
