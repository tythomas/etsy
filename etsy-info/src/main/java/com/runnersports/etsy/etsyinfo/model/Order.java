package com.runnersports.etsy.etsyinfo.model;

import org.apache.commons.csv.CSVRecord;

public class Order {

	private CSVRecord record;
	
	public Order(CSVRecord record) {
		this.record = record;
	}
}
