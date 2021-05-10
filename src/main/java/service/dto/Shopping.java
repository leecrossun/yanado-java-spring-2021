package service.dto;

import java.util.Date;

public class Shopping {
	String shoppingId;
	String productId;
	String detailCategory;
	String status;
	Date published;
	
	
	// Constructor
	public Shopping() {
		super();
	}

	public Shopping(String shoppingId, String productId, String detailCategory, String status, Date published) {
		super();
		this.shoppingId = shoppingId;
		this.productId = productId;
		this.detailCategory = detailCategory;
		this.status = status;
		this.published = published;
	}
	
	// getter, setter
	public String getShoppingId() {
		return shoppingId;
	}
	public String getProductId() {
		return productId;
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
	public void setProductId(String productId) {
		this.productId = productId;
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
