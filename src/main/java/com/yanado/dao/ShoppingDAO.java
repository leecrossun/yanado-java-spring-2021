package com.yanado.dao;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanado.dto.Product;
import com.yanado.dto.Shopping;

@Service
public class ShoppingDAO {

	// JPA
	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	public void createShopping(Shopping shopping, Product product) throws DataAccessException
	{
		em.persist(product);
		em.persist(shopping);
	}
	
	@Transactional
	public void updateShopping(Shopping shopping, Product product) throws DataAccessException
	{
		em.merge(product);
		em.merge(shopping);
	}
	
	// Shopping 삭제 (cascade Product)
	@Transactional
	public void deleteShopping(String shoppingId) throws DataAccessException 
	{
		Shopping result;
		TypedQuery<Shopping> query;
		try {
			query = em.createNamedQuery("getShoppingByshoppingId", Shopping.class);
			query.setParameter("id", shoppingId);
			result = (Shopping) query.getSingleResult();
			Product product = result.getProduct();
			em.remove(result);
			em.remove(product);
		} catch (NoResultException ex) {
			System.out.println("fail getShopping");
		}
	}
	
	// 모든 Shopping 가져오기 
	@Transactional
	public List<Shopping> getShoppingList () throws DataAccessException
	{
		List<Shopping> result;
		TypedQuery<Shopping> query;
		try {
			query = em.createNamedQuery("getShoppingList", Shopping.class);
			result = (List<Shopping>) query.getResultList();
		} catch (NoResultException ex) {
			System.out.println("fail getShoppingList");
			return null;
		}
		System.out.println("success getShoppingList");
		return result;
	}
	
	// Shopping detail 가져오기
	public Shopping getShoppingByshoppingId(String shoppingId) throws DataAccessException
	{
		Shopping result;
		TypedQuery<Shopping> query;
		try {
			query = em.createNamedQuery("getShoppingByshoppingId", Shopping.class);
			query.setParameter("id", shoppingId);
			result = (Shopping) query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("fail getShopping");
			return null;
		}
		System.out.println("success getShopping");
		return result;
	}
	
	// 카데고리 별로 Shopping 가져오기
	@Transactional
	public List<Shopping> getShoppingByCategory (String category) throws DataAccessException
	{
		List<Shopping> result;
		TypedQuery<Shopping> query = em.createNamedQuery("getShoppingByCategory", Shopping.class);
		query.setParameter("id", category);
		try {
			result = (List<Shopping>) query.getResultList();
		} catch (NoResultException ex) {
			System.out.println("fail" + category);
			return null;
		}
		System.out.println("success" + category);
		return result;
	}
	
	// 내가 올린 Shopping 가져오기
	@Transactional
	public List<Shopping> getShoppingByUserId (String userId) throws DataAccessException 
	{
		ArrayList<Shopping> result;
		TypedQuery<Shopping> query = em.createNamedQuery("getShoppingByUserId", Shopping.class);
		query.setParameter("id", userId);
		try {
			result = (ArrayList<Shopping>) query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
		return result;
	}
	
	// Stock 수 줄이기
	@Transactional
	public void updateStockByShoppingId (String shoppingId) throws DataAccessException 
	{
		TypedQuery<Shopping> query = em.createNamedQuery("updateStockByShoppingId", Shopping.class);
		query.setParameter("id", shoppingId);
	}
	

}
