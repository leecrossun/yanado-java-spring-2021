package com.yanado.dto;

public class FavoriteDTO {

	private Favorite fav;
	private Product product;

	public FavoriteDTO(Favorite fav, Product product) {
		super();
		this.fav = fav;
		this.product = product;
	}

	public Favorite getFav() {
		return fav;
	}

	public void setFav(Favorite fav) {
		this.fav = fav;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
