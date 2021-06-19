package com.yanado.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class CommonJoin {
	@NotNull
	String commonId; // 참여한 공동구매 ID
	
	@NotNull
	String userId; // 공동구매에 참여한 회원 ID
	
	@Range(min= 0, max=1)
	int payment; // 지불 여부, 1 : 지불 함 / 0 : 지불 안함

	public CommonJoin(@NotNull String commonId, @NotNull String userId, int payment) {
		this.commonId = commonId;
		this.userId = userId;
		this.payment = payment;
	}
	
	public CommonJoin(String commonId,String userId) {
		this.commonId = commonId;
		this.userId = userId;
	}


	public String getCommonId() {
		return commonId;
	}

	public void setCommonId(String commonId) {
		this.commonId = commonId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
