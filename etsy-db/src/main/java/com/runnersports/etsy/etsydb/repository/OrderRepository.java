package com.runnersports.etsy.etsydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runnersports.etsy.etsydb.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
