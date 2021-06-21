package com.yanado.dto;

public class AucJoin {
	String aucId;
	String userId;
	
	int bidPrice;
	int bidCount;
	
	public AucJoin() {
	}
	
	public AucJoin(String aucId, String userId, int bidPrice) {
		this.aucId = aucId;
		this.userId = userId;
		this.bidPrice = bidPrice;
	}
	
	public AucJoin(String aucId, String userId, int bidPrice, int bidCount) {
		this.aucId = aucId;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidCount = bidCount;
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

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getBidCount() {
		return bidCount;
	}

	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
	}
}
	

