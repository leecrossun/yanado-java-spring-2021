package com.yanado.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery
	(
			name = "getShoppingByCategory",
			query = "SELECT s.shoppingId, s.product, s.stock, s.status, s.published FROM Shopping s WHERE s.product.productId=:id"
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
	),
	@NamedQuery
	(
			name = "getShoppingByshoppingId",
			query = "SELECT s FROM Shopping s WHERE s.shoppingId=:id"
	)
	
})
public class Shopping implements Serializable {
	@Id
	@Column(name="SHOPPINGID")
	@GeneratedValue(generator = "SHOPPING_GEN")
	@GenericGenerator(name = "SHOPPING_GEN", strategy = "uuid")
	String shoppingId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCTID")
	Product product;
	
	int stock;
	int status;
	
	@Temporal(TemporalType.DATE)
	Date published;
	
	// 여기서 따로 어노테이션 주지 않아도 되는지 (db에는 reviewId가 없는데..)
	@OneToMany(mappedBy="shopping", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviewList;
	
	
	
	
	// Constructor
	public Shopping() {
		super();
	}

	public Shopping(String shoppingId, Product product, int stock, int status, Date published) {
		super();
		this.shoppingId = shoppingId;
		this.product = product;
		this.stock = stock;
		this.status = status;
		this.published = published;
	}
	
	public Shopping(String shoppingId, Product product, int stock, int status, Date published, List<Review> reviewList) {
		super();
		this.shoppingId = shoppingId;
		this.product = product;
		this.stock = stock;
		this.status = status;
		this.published = published;
		this.reviewList = reviewList;
	}

	// getter, setter
	@Column(name = "shoppingId")
	public String getShoppingId() {
		return shoppingId;
	}
	public Product getProduct() {
		return product;
	}

	public int getStatus() {
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

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setStock(String stock) {
		this.stock = Integer.parseInt(stock);
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
