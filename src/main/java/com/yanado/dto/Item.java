package com.yanado.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery
	(
			name = "get",
			query = "SELECT s FROM Shopping s WHERE s.product.productId=:id"
	)
	
})
public class Item implements Serializable{
	
	@Id
	@GeneratedValue(generator = "ITEM_GEN")
	@GenericGenerator(name = "ITEM_GEN", strategy = "uuid")
	@Column(name="ITEMID")
	String itemId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ORDERID")
	Order order;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	Product product;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="USERID")
	User user;
	
	int unitcost;
	int quentity;
	
	@Column(name="ATTRIBUTE1")
	String att1;
	
	@Column(name="ATTRIBUTE2")
	String att2;
	
	@Column(name="ATTRIBUTE3")
	String att3;
	int status;
	
	public Item() {}
	
	public Item(String itemId, Product product, User user, int unitcost, int quentity, String att1, String att2,
			String att3, int status) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.user = user;
		this.unitcost = unitcost;
		this.quentity = quentity;
		this.att1 = att1;
		this.att2 = att2;
		this.att3 = att3;
		this.status = status;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(int unitcost) {
		this.unitcost = unitcost;
	}
	
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuentity() {
		return quentity;
	}

	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}

	public String getAtt1() {
		return att1;
	}

	public void setAtt1(String att1) {
		this.att1 = att1;
	}

	public String getAtt2() {
		return att2;
	}

	public void setAtt2(String att2) {
		this.att2 = att2;
	}

	public String getAtt3() {
		return att3;
	}

	public void setAtt3(String att3) {
		this.att3 = att3;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
