package com.yanado.dto;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class ProductNaver {
	String title;
	String link;
	String image;
	int lprice;
	String category2;
	
	public ProductNaver() {}
	
	public ProductNaver(String title, String link, String image, int lprice, String category2) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.lprice = lprice;
		this.category2 = category2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLprice() {
		return lprice;
	}

	public void setLprice(int lprice) {
		this.lprice = lprice;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	
	
	
	

}
