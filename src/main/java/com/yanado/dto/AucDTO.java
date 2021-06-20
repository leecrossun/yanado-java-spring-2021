package com.yanado.dto;

public class AucDTO {
	private Auc auc;
	private Product product;
	
	public AucDTO() {
	}
	
	public AucDTO(Auc auc, Product product) {
		this.auc = auc;
		this.product = product;
	}
	
	public Auc getAuc() {
		return auc;
	}
	public void setAuc(Auc auc) {
		this.auc = auc;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
