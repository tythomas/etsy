package com.runnersports.etsy.etsydb.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Listing {

	@Id
	@GeneratedValue
	private Long id;
	@Column(columnDefinition="TEXT")
	private String title;
	@Transient
	private String description;
	private BigDecimal price;
	private Integer quantity;
	
	@Transient
	String pic1;
	
	@Transient
	String pic2;
	
	@Transient
	String pic3;
	
	@Transient
	String pic4;
	
	@Transient
	String pic5;
	
	@Transient
	String pic6;
	
	@Transient
	String pic7;
	
	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	public String getPic6() {
		return pic6;
	}

	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}

	public String getPic7() {
		return pic7;
	}

	public void setPic7(String pic7) {
		this.pic7 = pic7;
	}

	public String getPic8() {
		return pic8;
	}

	public void setPic8(String pic8) {
		this.pic8 = pic8;
	}

	public String getPic9() {
		return pic9;
	}

	public void setPic9(String pic9) {
		this.pic9 = pic9;
	}

	public String getPic10() {
		return pic10;
	}

	public void setPic10(String pic10) {
		this.pic10 = pic10;
	}

	@Transient
	String pic8;
	
	@Transient
	String pic9;
	
	@Transient
	String pic10;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String tub;
	private Integer numPictures;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTub() {
		return tub;
	}

	public void setTub(String tub) {
		this.tub = tub;
	}

	public Integer getNumPictures() {
		return numPictures;
	}

	public void setNumPictures(Integer numPictures) {
		this.numPictures = numPictures;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
