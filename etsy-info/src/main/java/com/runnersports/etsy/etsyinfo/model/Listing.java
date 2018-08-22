package com.runnersports.etsy.etsyinfo.model;

//TITLE	DESCRIPTION	PRICE	CURRENCY_CODE	QUANTITY	TAGS	MATERIALS	IMAGE1	IMAGE2	IMAGE3	IMAGE4	IMAGE5	IMAGE6	IMAGE7	IMAGE8	IMAGE9	IMAGE10	VARIATION 1 TYPE	VARIATION 1 NAME	VARIATION 1 VALUES	VARIATION 2 TYPE	VARIATION 2 NAME	VARIATION 2 VALUES

public class Listing {

	private String title;
	private String description;
	private String price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
