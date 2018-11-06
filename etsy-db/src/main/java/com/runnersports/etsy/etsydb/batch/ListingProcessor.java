package com.runnersports.etsy.etsydb.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.Listing;

@Component
public class ListingProcessor implements ItemProcessor<Listing, Listing>{

	@Override
	public Listing process(Listing item) throws Exception {
		
		
		String gr = item.getDescription().substring(item.getDescription().lastIndexOf("\n") + 1).trim();	
		if (gr.length() > 24) gr = "GR";
		item.setTub(gr);
		
		int count = 0;
		if (item.getPic1().length() > 0) count++;
		if (item.getPic2().length() > 0) count++;
		if (item.getPic3().length() > 0) count++;
		if (item.getPic4().length() > 0) count++;
		if (item.getPic5().length() > 0) count++;
		if (item.getPic6().length() > 0) count++;
		if (item.getPic7().length() > 0) count++;
		if (item.getPic8().length() > 0) count++;
		if (item.getPic9().length() > 0) count++;
		if (item.getPic10().length() > 0) count++;
		item.setNumPictures(count);
		
		return item;
	}
}
