package com.yanado.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@SuppressWarnings("serial")
@Entity
@IdClass(ReviewPK.class)
@NamedQueries({
	@NamedQuery
	(
			name = "getReviewByShoppingId",
			query = "SELECT r FROM Review r WHERE r.shopping.shoppingId=:id"
	)
})
public class Review implements Serializable{
	@Id
	String reviewId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="shoppingId")
	Shopping shopping;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="userId")
	User user;
	String content;
	int rating;
	
	@Temporal(TemporalType.DATE)
	Date published;
	
	
	public Review() {
		super();
	}

	public Review(String reviewId, Shopping shopping, User user, String content, int rating, Date published) {
		super();
		this.reviewId = reviewId;
		this.shopping = shopping;
		this.user = user;
		this.content = content;
		this.rating = rating;
		this.published = published;
	}
	
	public String getReviewId() {
		return reviewId;
	}

	public String getContent() {
		return content;
	}
	public int getRating() {
		return rating;
	}
	public Date getPublished() {
		return published;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public Shopping getShopping() {
		return shopping;
	}

	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setPublished(Date published) {
		this.published = published;
	}

}
