package com.runnersports.etsy.etsydb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.runnersports.etsy.etsydb.model.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {

	@Query("SELECT l FROM Listing l WHERE l.tub = 'GR'")
	public List<Listing> getGRListings();
}
