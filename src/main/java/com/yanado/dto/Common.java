package com.yanado.dto;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

public class Common {
	String commonId; // 공동구매 ID
	
	@NotNull
	String userId; // common을 등록한 회원 ID

	@NotNull
	String productId; // 공동구매할 상품 ID
	
	@PositiveOrZero
	int participants; // 공동구매에 참여한 수
	
	@Positive
	int min; // 공동 구매 최소 인원

	@Range(min = 1, max = 5)
	int status; // 공동구매 진행 현황, 1 : 진행 전, 2 : 정원 미달, 3 : 최소인원 넘음, 4 : 파기, 5: 성공 (및 종료)

	Date regDate; // 등록일

	@NotNull
	Date startDate; // 공동구매 신청 시작일
	
	@NotNull
	Date endDate; // 공동구매 신청 종료일
	
	@NotNull
	Date deadline; // 공동구매 성공시, 결제 마감일

	public Common() {
	}

	public Common(String commonId, String userId, String productId, int participants, int min, int status, Date regDate,
			Date startDate, Date endDate, Date deadline) {
		this.commonId = commonId;
		this.userId = userId;
		this.productId = productId;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

	public Common(String userId, String productId, int participants, int min, int status, Date regDate, Date startDate,
			Date endDate, Date deadline) {
		this.userId = userId;
		this.productId = productId;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

	public Common(String productId, int min, CommonJoin join, Date startDate, Date endDate, Date deadline) {
		this.productId = productId;
		this.min = min;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommonId() {
		return commonId;
	}

	public void setCommonId(String commonId) {
		this.commonId = commonId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}
