package com.runnersports.etsy.etsyinfo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListingsController {

	
	@GetMapping("/gr/empty")
	public void getEmptyGRListings() throws IOException {
		
		Reader in = new FileReader("c:\\Users\\u386361\\Downloads\\EtsyListingsDownload.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader().parse(in);
		for (CSVRecord record : records) {
		    String title = record.get("TITLE");
		    String description = record.get("DESCRIPTION");
		    String tubNumber = getGRNumber(description);
		    if ("GR".equals(tubNumber)) System.err.println("EMPTY GR: " + title);
		    if (tubNumber.length() > 25) System.err.println("MISSING TUB: " + title);
//		    System.out.println(getGRNumber(description));
		}
	}
	
	private String getGRNumber(String description) {
		
		return description.substring(description.lastIndexOf("\n")+1).trim();
	}
}
