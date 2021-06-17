package com.yanado.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
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
	),
	@NamedQuery
	(
			name = "getReviewByReviewId",
			query = "SELECT r FROM Review r WHERE r.reviewId=:id and r.shopping.shoppingId=:id2"
	)
})
public class Review implements Serializable{
	@Id
	@GeneratedValue(generator = "REVIEW_GEN")
	@GenericGenerator(name = "REVIEW_GEN", strategy = "uuid")
	@Column(name="REVIEWID")
	String reviewId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="SHOPPINGID")
	Shopping shopping;
	
	@OneToOne
	@JoinColumn(name="USERID")
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
