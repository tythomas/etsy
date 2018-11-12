package com.runnersports.etsy.etsydb;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersports.etsy.etsydb.model.Listing;
import com.runnersports.etsy.etsydb.repository.ListingRepository;

@RestController
@RequestMapping("/listing")
public class ListingController {

	@Autowired
	private ListingRepository repository;
	
	@GetMapping("/gr")
	public ResponseEntity<List<Listing>> getGR() throws IOException {
		return new ResponseEntity<List<Listing>>(repository.getGRListings(), HttpStatus.OK);
	}
	

}
