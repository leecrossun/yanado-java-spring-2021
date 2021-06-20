package com.yanado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class ListProduct {
	@JsonProperty("items")
	private ProductNaver[] productNaver;
	
	public ListProduct() {}

	public ListProduct(ProductNaver[] productNaver) {
		super();
		this.productNaver = productNaver;
	}

	public ProductNaver[] getProductNaver() {
		return productNaver;
	}

	public void setProductNaver(ProductNaver[] productNaver) {
		this.productNaver = productNaver;
	}
	
	

}
