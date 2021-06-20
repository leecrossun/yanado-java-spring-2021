package com.yanado.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanado.dto.Item;
import com.yanado.dto.Order;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
@Service
public class OrderDAO {
	
	@PersistenceContext
	public EntityManager em;
	
	@Transactional
	public void createOrder(Order order, List<Item> items) throws DataAccessException
	{
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			item.setOrder(order);
			em.persist(item);
		}
		em.persist(order);
	}
	
	@Transactional
	public void deleteOrder(Order order, List<Item> items) throws DataAccessException
	{
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			em.remove(item);
		}
		em.remove(order);
		System.out.println("delete order");
	}
	
	@Transactional
	public Order getOrderByOrderId(String orderId) throws DataAccessException
	{
		Order result;
		TypedQuery<Order> query;
		try {
			query = em.createNamedQuery("getOrderByOrderId", Order.class);
			query.setParameter("id", orderId);
			result = (Order)query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("fail getOrder");
			return null;
		}
		System.out.println("success getOrder");
		return result;
	}

}
