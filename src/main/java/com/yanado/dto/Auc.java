package com.yanado.dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.relational.core.mapping.Table;

<<<<<<< HEAD
=======
@Entity
@Table(name="Auction")
>>>>>>> branch 'master' of https://github.com/leecrossun/Yanado.git
public class Auc {
	@Id
	String aucId;
	
	@Range(min=0,max=4)
	int status; //1:등록 2:경매진행 3:경매종료 4:경매삭제
	
	int highestPrice;
	int lowestPrice;
	
	String highestUserId;
	
	@PositiveOrZero
	int participants;

	Date regDate;
	@NotNull
	Date startDate;
	@NotNull
	Date endDate;
	
	String productId;
	
	public Auc() {
	}
	
	public Auc(String aucId, int highestPrice, Date startDate, Date endDate, String productId) {
		this.productId = productId;
		this.aucId = aucId;
		this.highestPrice = highestPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Auc(String aucId, int status, int highestPrice, int lowestPrice, String highestUserId, int participants, Date regDate, Date startDate, Date endDate, String productId) {
		this.aucId = aucId;
		this.status = status;
		this.highestPrice = highestPrice;
		this.lowestPrice= lowestPrice;
		this.highestUserId = highestUserId;
		this.participants = participants;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
	}

	public String getAucId() {
		return aucId;
	}

	public void setAucId(String aucId) {
		this.aucId = aucId;
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

	public int getLowestPrice() {
		return lowestPrice;
	}

	public void setMinimumAmount(int lowestPrice) {
		this.lowestPrice = lowestPrice;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setLowestPrice(int lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	
}
