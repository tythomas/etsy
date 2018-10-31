package com.runnersports.etsy.etsydb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class States {

	@Id
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
