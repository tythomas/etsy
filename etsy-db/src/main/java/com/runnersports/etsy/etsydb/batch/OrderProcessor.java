package com.runnersports.etsy.etsydb.batch;

import java.util.Calendar;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.Order;

@Component
public class OrderProcessor implements ItemProcessor<Order, Order>{

    private static int previousDay = 0;
    
	@Override
	public Order process(Order item) throws Exception {
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime( item.getSaleDate() );
	    int today = calendar.get(Calendar.DAY_OF_YEAR);
	    
	    if (previousDay == 0) previousDay = today;
	    if (previousDay != today) {
	        int gap = previousDay - today;
	        if (gap > 1) {
	            System.out.println( "FOUND GAP: " + item.getSaleDate() + " FOR " + (gap-1) + " DAY(S)!" );
	        }
            previousDay = today;
	    }
	    
		return item;
	}
}
