package com.yanado.dto;

import javax.validation.constraints.NotNull;

public class Product {
	@NotNull
	String productId;

	@NotNull
	String productName;

	@NotNull
	String category;

	String detailCategory;
	String image;
	String attribute1;
	String attribute2;
	String attribute3;
	String content;

	@NotNull
	int price;

	int delivery;

	@NotNull
	String supplierId;


	public Product() {

	}

	public Product(String productId, String productName, String category, String detailCategory, String image,
			String attribute1, String attribute2, String attribute3, String content, int price, int delivery,
			String supplierId) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.detailCategory = detailCategory;
		this.image = image;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.content = content;
		this.price = price;
		this.delivery = delivery;
		this.supplierId = supplierId;
	}

	public Product(String productId, String productName, String category, int price, String supplierId) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.supplierId = supplierId;
	}

	public Product(String category, String detailCategory, String image, String attribute1, String attribute2,
			String attribute3, String content, int price) {
		this.category = category;
		this.detailCategory = detailCategory;
		this.image = image;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.content = content;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetailCategory() {
		return detailCategory;
	}

	public void setDetailCategory(String detailCategory) {
		this.detailCategory = detailCategory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

}