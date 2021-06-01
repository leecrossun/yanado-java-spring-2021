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

import com.yanado.dto.Shopping;

@Service
public class ShoppingDAO {

	// JPA
	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	public void createShopping(Shopping shopping) throws DataAccessException
	{
		em.persist(shopping);
	}
	
	@Transactional
	public void updateShopping(Shopping shopping) throws DataAccessException
	{
		em.merge(shopping);
	}
	
	// Shopping 삭제 (cascade Product)
	@Transactional
	public void deleteShopping(Shopping shopping) throws DataAccessException 
	{
		em.remove(shopping);
	}
	
	// 모든 Shopping 가져오기 (필요없으면 삭제)
	@Transactional
	public List<Shopping> getShoppingList () throws DataAccessException
	{
		ArrayList<Shopping> result;
		TypedQuery<Shopping> query = em.createNamedQuery("getShoppingList", Shopping.class);
		try {
			result = (ArrayList<Shopping>) query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
		return result;
	}
	
	// 카데고리 별로 Shopping 가져오기
	@Transactional
	public List<Shopping> getShoppingByCategory (String detailCategory) throws DataAccessException
	{
		ArrayList<Shopping> result;
		TypedQuery<Shopping> query = em.createNamedQuery("getShoppingByCategory", Shopping.class);
		query.setParameter("id", detailCategory);
		try {
			result = (ArrayList<Shopping>) query.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
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
	

}
