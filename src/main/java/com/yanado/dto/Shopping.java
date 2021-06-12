package com.yanado.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery
	(
			name = "getShoppingByCategory",
			query = "SELECT s FROM Shopping s WHERE s.product.productId=:id"
	),
	@NamedQuery
	(
			name = "getShoppingByUserId",
			query = "SELECT s FROM Shopping s WHERE s.product.supplierId=:id"
	),
	@NamedQuery
	(
			name = "getShoppingList",
			query = "SELECT s FROM Shopping s"
	)
})
public class Shopping implements Serializable {
	@Id
	String shoppingId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="productId")
	Product product;
	String status;
	
	@Temporal(TemporalType.DATE)
	Date published;
	
	// 여기서 따로 어노테이션 주지 않아도 되는지 (db에는 reviewId가 없는데..)
	@OneToMany(mappedBy="shopping", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviewList;
	
	
	
	
	// Constructor
	public Shopping() {
		super();
	}

	public Shopping(String shoppingId, Product product, String status, Date published) {
		super();
		this.shoppingId = shoppingId;
		this.product = product;
		this.status = status;
		this.published = published;
	}
	
	public Shopping(String shoppingId, Product product, String status, Date published, List<Review> reviewList) {
		super();
		this.shoppingId = shoppingId;
		this.product = product;
		this.status = status;
		this.published = published;
		this.reviewList = reviewList;
	}

	// getter, setter
	public String getShoppingId() {
		return shoppingId;
	}
	public Product getProduct() {
		return product;
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

	public void setStatus(String status) {
		this.status = status;
	}
	public void setPublished(Date published) {
		this.published = published;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	

}
