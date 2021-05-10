package service.dto;

import javax.validation.constraints.NotNull;

public class CommonJoin {
	@NotNull
	String commonId;
	@NotNull
	String userId;
	int payment;

	public CommonJoin(String commonId, String userId, int payment) {
		this.commonId = commonId;
		this.userId = userId;
		this.payment = payment;
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
