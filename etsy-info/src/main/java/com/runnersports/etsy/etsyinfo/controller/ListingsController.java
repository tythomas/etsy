package com.runnersports.etsy.etsyinfo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listing")
public class ListingsController {

	@GetMapping("/gr/empty")
	public void getEmptyGRListings() throws IOException {

		Iterable<CSVRecord> records = getRecords();
		for (CSVRecord record : records) {
			String title = record.get("TITLE");
			String description = record.get("DESCRIPTION");
			String tubNumber = getGRNumber(description);
			if ("GR".equals(tubNumber))
				System.err.println("EMPTY GR: " + title);
			if (tubNumber.length() > 25)
				System.err.println("MISSING TUB: " + title);
			// System.out.println(getGRNumber(description));
		}
	}

	@GetMapping("/values")
	public void getValues() throws IOException {

		Iterable<CSVRecord> records = getRecords();
		BigDecimal total = new BigDecimal("0");
		int count = 0;
		for (CSVRecord record : records) {
			BigDecimal price = new BigDecimal(record.get("PRICE"));
			BigDecimal quantity = new BigDecimal(record.get("QUANTITY"));
			// System.out.println(price + " , " + quantity);
			total = total.add(price.multiply(quantity));
			count++;
		}

		System.err.println(count + " listings for a total of: " + total);
	}

	private String getGRNumber(String description) {

		return description.substring(description.lastIndexOf("\n") + 1).trim();
	}

	private Iterable<CSVRecord> getRecords() throws IOException {
		Reader in = new FileReader("c:\\Users\\u386361\\Downloads\\EtsyListingsDownload.csv");
		return CSVFormat.RFC4180.withHeader().parse(in);
	}
}
