package com.runnersports.etsy.etsydb.model;

import java.util.ArrayList;
import java.util.List;

public class OrderSummaryByYear {

	private Integer year;
	List<OrderSummary> summaries = new ArrayList<>();
	public List<OrderSummary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<OrderSummary> summaries) {
		this.summaries = summaries;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
}
