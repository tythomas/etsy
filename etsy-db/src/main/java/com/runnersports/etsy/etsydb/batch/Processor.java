package com.runnersports.etsy.etsydb.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.runnersports.etsy.etsydb.model.EtsyOrder;

@Component
public class Processor implements ItemProcessor<EtsyOrder, EtsyOrder>{

	@Override
	public EtsyOrder process(EtsyOrder item) throws Exception {
		
		return item;
	}
}
