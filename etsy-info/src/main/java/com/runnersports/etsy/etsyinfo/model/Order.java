package com.runnersports.etsy.etsyinfo.model;

import java.math.BigDecimal;

import org.apache.commons.csv.CSVRecord;

public class Order {

	private CSVRecord record;
	
	public Order(CSVRecord record) {
		this.record = record;
	}

	public boolean isILOrder() {
		String state = record.get("Ship State");
		return "IL".equals(state);
	}

	public BigDecimal getSalesTax() {
		return new BigDecimal(record.get("Sales Tax"));
	}

	public BigDecimal getOrderValue() {
		return new BigDecimal(record.get("Order Value"));
	}

	public BigDecimal getShippingAmount() {
		return new BigDecimal(record.get("Shipping"));
	}

}
