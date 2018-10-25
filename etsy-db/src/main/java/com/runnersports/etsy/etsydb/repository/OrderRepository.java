package com.runnersports.etsy.etsydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runnersports.etsy.etsydb.model.EtsyOrder;

public interface OrderRepository extends JpaRepository<EtsyOrder, Long> {

}
