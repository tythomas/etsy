package com.runnersports.etsy.etsydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runnersports.etsy.etsydb.model.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {

}
