package com.yanado.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery
	(
			name = "getOrderByUserId",
			query = "SELECT o FROM Order o WHERE o.user.userId=:id"
	)
	
})
@Table(name="ORDERINFO")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(generator = "ORDER_GEN")
	@GenericGenerator(name = "ORDER_GEN", strategy = "uuid")
	@Column(name="ORDERID")
	String orderId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="USERID")
	User user;
	
	@OneToMany(mappedBy="order")
	List<Item> item;
	
	@Column(name="SHIPNAME")
	String shipName;
	
	@Column(name="SHIPNUMBER")
	String shipNumber;
	
	@Column(name="SHIPADDRESS")
	String shipAddress;
	
	@Column(name="BILLNAME")
	String billName;
	
	@Column(name="BILLNUMBER")
	String billNumber;
	
	@Column(name="BILLADDRESS")
	String billAddress;
	
	@Column(name="TOTALPRICE")
	int totalPrice;
	
	@Column(name="ORDERDATE")
	Date orderDate;
	
	@Column(name="PAYMENTTYPE")
	String paymentType;
	
	int status;
	String courier;
	
	@Column(name="CARDNUM")
	String cardNum;
	
	public Order() {}
	
	public Order(String orderId, User user, List<Item> item, String shipName, String shipNumber, String shipAddress,
			String billName, String billNumber, String billAddress, int totalPrice, Date orderDate, String paymentType,
			int status, String courier, String cardNum) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.item = item;
		this.shipName = shipName;
		this.shipNumber = shipNumber;
		this.shipAddress = shipAddress;
		this.billName = billName;
		this.billNumber = billNumber;
		this.billAddress = billAddress;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.paymentType = paymentType;
		this.status = status;
		this.courier = courier;
		this.cardNum = cardNum;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(String shipNumber) {
		this.shipNumber = shipNumber;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	
	

}
