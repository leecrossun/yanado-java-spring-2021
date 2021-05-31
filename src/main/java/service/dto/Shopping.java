package service.dto;

import java.util.Date;

public class Shopping {
	String shoppingId;
	Product product;
	String detailCategory;
	String status;
	Date published;
	
	
	// Constructor
	public Shopping() {
		super();
	}

	public Shopping(String shoppingId, Product product, String detailCategory, String status, Date published) {
		super();
		this.shoppingId = shoppingId;
		this.product = product;
		this.detailCategory = detailCategory;
		this.status = status;
		this.published = published;
	}
	
	// getter, setter
	public String getShoppingId() {
		return shoppingId;
	}
	public Product getProduct() {
		return product;
	}
	public String getDetailCategory() {
		return detailCategory;
	}
	public String getStatus() {
		return status;
	}
	public Date getPublished() {
		return published;
	}
	public void setShoppingId(String shoppingId) {
		this.shoppingId = shoppingId;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setDetailCategory(String detailCategory) {
		this.detailCategory = detailCategory;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPublished(Date published) {
		this.published = published;
	}

}
