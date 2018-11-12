package com.runnersports.etsy.etsydb.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.runnersports.etsy.etsydb.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT max(saleDate) FROM Order")
	Date getMaxDate();
}
