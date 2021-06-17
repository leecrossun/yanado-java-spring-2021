package com.yanado.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanado.dto.Review;
import com.yanado.dto.Shopping;
@Service
public class ReviewDAO {
	
	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	public List<Review> getReviewByShoppingId (String shoppingId) {
		ArrayList<Review> result;
		TypedQuery<Review> query = em.createNamedQuery("getReviewByShoppingId", Review.class);
		query.setParameter("id", shoppingId);
		try {
			result = (ArrayList<Review>) query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
		return result;
	}
	
	@Transactional
	public Review getReviewByReviewId (String reviewId, String shoppingId) throws DataAccessException
	{
		Review result;
		TypedQuery<Review> query = em.createNamedQuery("getReviewByReviewId", Review.class);
		query.setParameter("id", reviewId);
		query.setParameter("id2", shoppingId);
		try {
			result = (Review) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		return result;
	}
	
	@Transactional
	public void createReview(Review review) throws DataAccessException 
	{
		em.persist(review);
	}
	
	@Transactional
	public void updateReview(Review review) throws DataAccessException
	{
		em.merge(review);
	}
	
	@Transactional
	public void deleteReview(Review review) throws DataAccessException
	{
		em.remove(review);
	}

	
	

}
