package com.yanado.dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Auction")
public class Auc {
	@Id
	String aucId;
	
	@NotNull
	String userId;
	
	@Range(min=0,max=4)
	int status; 
	
	int highestPrice;
	int minimumAmount;
	
	String highestUserId;
	
	@PositiveOrZero
	int participants;
	String payment;

	Date regDate;
	@NotNull
	Date startDate;
	@NotNull
	Date endDate;
	@NotNull
	Date deadline;
	
	String productId;
	
	public Auc() {
	}
	
	public Auc(String aucId, String userId, int highestPrice, Date startDate, Date endDate, Date deadline, String productId) {
		this.productId = productId;
		this.aucId = aucId;
		this.userId = userId;
		this.highestPrice = highestPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Auc(String aucId, String userId, int status, int highestPrice, int minimumAmount, String highestUserId, int participants, String payment, Date regDate, Date startDate, Date endDate, Date deadline, String productId) {
		this.aucId = aucId;
		this.userId = userId;
		this.status = status;
		this.highestPrice = highestPrice;
		this.minimumAmount = minimumAmount;
		this.highestUserId = highestUserId;
		this.participants = participants;
		this.payment = payment;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
		this.productId = productId;
	}

	public String getAucId() {
		return aucId;
	}

	public void setAucId(String aucId) {
		this.aucId = aucId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(int highestPrice) {
		this.highestPrice = highestPrice;
	}

	public int getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public String getHighestUserId() {
		return highestUserId;
	}

	public void setHighestUserId(String highestUserId) {
		this.highestUserId = highestUserId;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	

	
}
