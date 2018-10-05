package com.runnersports.etsy.etsyinfo.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderSummary {

	List<Order> orders;
	BigDecimal totalAmount = new BigDecimal(0);
	BigDecimal shippingAmount = new BigDecimal(0);
	BigDecimal taxesCollected = new BigDecimal(0);
	
	
	public void add(Order order) {
		totalAmount = totalAmount.add(order.getOrderValue());
		shippingAmount = shippingAmount.add(order.getShippingAmount());
		taxesCollected = taxesCollected.add(order.getSalesTax());
		if (orders == null) orders = new ArrayList<Order>();
		orders.add(order);
	}


	public String summaryWithTaxes() {
		return summary() + " and withheld " + NumberFormat.getCurrencyInstance().format(taxesCollected);
	}

	public String summary() {
		return orders.size() + " orders, totalling: " + NumberFormat.getCurrencyInstance().format(totalAmount) + ", shipping of: " + NumberFormat.getCurrencyInstance().format(shippingAmount);
	}

}
