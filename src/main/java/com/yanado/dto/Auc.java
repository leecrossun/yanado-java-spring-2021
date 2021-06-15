package com.yanado.dto;

import java.sql.Date;

public class Auc {
	String aucNo;
	String userId;
	
	int status;
	
	int highestPrice;
	int lowestPrice;
	String highestUserId;
	
	int participants;
	String payment;

	Date regDate;
	Date startDate;
	Date endDate;
	
	Product product;
	
	public Auc(String aucNo, String userId, int highestPrice,Date startDate, Date endDate) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.highestPrice = highestPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Auc(String aucNo, String userId, int status, int hightestPrice, int lowestPrice, String highestUserId, int participants, String payment) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.status = status;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.highestUserId = highestUserId;
		this.participants = participants;
		this.payment = payment;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getaucNo() {
		return aucNo;
	}
	public void setaucNo(String aucNo) {
		this.aucNo = aucNo;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public int getstatus() {
		return status;
	}
	public void setstatus(int status) {
		this.status = status;
	}
	public int gethighestPrice() {
		return highestPrice;
	}
	public void sethighestPrice(int highestPrice) {
		this.highestPrice = highestPrice;
	}
	public int getlowestPrice() {
		return lowestPrice;
	}
	public void setlowestPrice(int lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String gethighestUserId() {
		return highestUserId;
	}
	public void sethighestUserId(String highestUserId) {
		this.highestUserId = highestUserId;
	}
	public int getparticipants() {
		return participants;
	}
	public void setparticipants(int participants) {
		this.participants = participants;
	}
	public String getpayment() {
		return payment;
	}
	public void setpayment(String payment) {
		this.payment = payment;
	}
	public Date getregDate() {
		return regDate;
	}
	public void setregDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getstartDate() {
		return startDate;
	}
	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getendDate() {
		return endDate;
	}
	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}
}
