package com.runnersports.etsy.etsydb.model;

import java.math.BigDecimal;

public class OrderSummary {

	private BigDecimal totalAmount;
	private BigDecimal totalShipping;
	private BigDecimal totalTax;
	private Integer numOrders;
	private String state;
	
	public OrderSummary(Long numOrders, BigDecimal totalAmount, BigDecimal totalTax, BigDecimal totalShipping, String state) {
		this.numOrders = numOrders.intValue();
		this.totalAmount = totalAmount;
		this.totalTax = totalTax;
		this.totalShipping = totalShipping;
		this.state = state;
	}

	public OrderSummary(Long numOrders, BigDecimal totalAmount, BigDecimal totalTax, BigDecimal totalShipping) {
		this.numOrders = numOrders.intValue();
		this.totalAmount = totalAmount;
		this.totalTax = totalTax;
		this.totalShipping = totalShipping;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getTotalShipping() {
		return totalShipping;
	}
	public void setTotalShipping(BigDecimal totalShipping) {
		this.totalShipping = totalShipping;
	}
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	public Integer getNumOrders() {
		return numOrders;
	}
	public void setNumOrders(Integer numOrders) {
		this.numOrders = numOrders;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderSummary [totalAmount=" + totalAmount + ", totalShipping=" + totalShipping + ", totalTax="
				+ totalTax + ", numOrders=" + numOrders + ", state=" + state + "]";
	}
	
	
}
