package com.yanado.dto;

import javax.validation.constraints.NotNull;

public class Favorite {
	@NotNull
	String userId; // 좋아요를 누른 회원

	@NotNull
	String productId; // 좋아요를 누른 상품 ID

	String typeId; // 좋아요를 누른 상품의 게시글 ID
	int type; // 상품의 category, 1: shopping, 2 : transaction, 3: common, 4: auc

	public Favorite(String userId, String productId, String typeId, int type) {
		this.userId = userId;
		this.productId = productId;
		this.typeId = typeId;
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
