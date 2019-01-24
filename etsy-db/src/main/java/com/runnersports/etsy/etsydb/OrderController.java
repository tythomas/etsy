package com.runnersports.etsy.etsydb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersports.etsy.etsydb.model.OrderSummary;
import com.runnersports.etsy.etsydb.repository.OrderRepository;
import com.runnersports.etsy.etsydb.repository.OrderSummaryByYear;
import com.runnersports.etsy.etsydb.repository.OrderSummaryRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/iltax")
	public ResponseEntity<OrderSummary> getTaxes() throws IOException {
		return new ResponseEntity<OrderSummary>(orderSummaryRepository.getILSalesTax(), HttpStatus.OK);
	}
	
	@GetMapping("/statesummary")
	public ResponseEntity<List<OrderSummary>> getStateSummary() throws IOException {
		return new ResponseEntity<List<OrderSummary>>(orderSummaryRepository.getSummaryByState(), HttpStatus.OK);
	}
	
	@GetMapping("/monthsummary")
	public ResponseEntity<List<OrderSummaryByYear>> getMonthSummary() throws IOException {
		List<OrderSummary> summaries = orderSummaryRepository.getSummaryByMonth();
		Map<Integer, List<OrderSummary>> map = new TreeMap<>();
		for (OrderSummary orderSummary : summaries) {
			List<OrderSummary> list = map.get(orderSummary.getYear());
			if (list == null) list = new ArrayList<>();
			list.add(orderSummary);
			map.put(orderSummary.getYear(), list);
		}
		List<OrderSummaryByYear> summaryList = new ArrayList<>();
		for (Integer key : map.keySet()) {
			OrderSummaryByYear summary = new OrderSummaryByYear();
			summary.setYear(key);
			summary.setSummaries(map.get(key));
			summaryList.add(summary);
		}
		return new ResponseEntity<List<OrderSummaryByYear>>(summaryList, HttpStatus.OK);
	}
	
	@GetMapping("/allorders")
	public ResponseEntity<OrderSummary> getAllOrderSummary() throws IOException {
		return new ResponseEntity<OrderSummary>(orderSummaryRepository.getAllSales(), HttpStatus.OK);
	}

	@GetMapping("/latest")
	public ResponseEntity<Date> getLastSaleDate() throws IOException {

		return new ResponseEntity<Date>(orderRepository.getMaxDate(), HttpStatus.OK);
	}
}
