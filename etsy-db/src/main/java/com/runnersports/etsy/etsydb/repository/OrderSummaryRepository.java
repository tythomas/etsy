package com.runnersports.etsy.etsydb.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.OrderSummary;

@Component
public class OrderSummaryRepository {

	@Autowired
	private EntityManager em;
	
	public OrderSummary getILSalesTax() {
		
		String query = "SELECT NEW com.runnersports.etsy.etsydb.model.OrderSummary(count(*), sum(orderValue), sum(salesTax), sum(shippingAmount), 'IL') FROM EtsyOrder where state = 'IL'";
		return (OrderSummary) em.createQuery(query).getSingleResult();
	}
	
	public List<OrderSummary> getSummaryByState() {
		
		String query = "SELECT NEW com.runnersports.etsy.etsydb.model.OrderSummary(count(*), sum(orderValue), sum(salesTax), sum(shippingAmount), state) FROM EtsyOrder GROUP BY STATE ORDER BY STATE";
		return (List<OrderSummary>) em.createQuery(query).getResultList();
	}
}
