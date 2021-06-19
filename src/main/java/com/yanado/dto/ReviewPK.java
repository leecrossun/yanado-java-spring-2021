package com.yanado.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")

public class ReviewPK implements Serializable{
	private String reviewId; // 리뷰 Id
	private Shopping shopping; // 리뷰를 남긴 쇼핑
	
	public ReviewPK() {}
	
	public ReviewPK(String reviewId, Shopping shopping) {
		this.reviewId = reviewId;
		this.shopping = shopping;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		ReviewPK reviewPK = (ReviewPK) o;
		return reviewId.equals(reviewPK.reviewId) &&
				shopping.equals(reviewPK.shopping);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(reviewId, shopping);
	}
	

}
