package com.yanado.dao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yanado.dto.Shopping;

public class ShoppingDAO {
	
	//private static JDBCUtil jdbcUtil = null;
	private SqlSessionFactory sqlSessionFactory;
		
	String namespace = ""; // xml 작성 시 추가할 것

	public ShoppingDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public int createShopping(Shopping shopping) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.insert(namespace + "", shopping);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateShopping(Shopping shoppingId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.update(namespace + "", shoppingId);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteShopping(String shoppingId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.delete(namespace + "", shoppingId);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	// 모든 Shopping 가져오기 (필요없으면 삭제)
	public List<Shopping> getShoppingList () {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			List<Shopping> shopping = sqlSession.selectList(namespace + "");
			return shopping;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	
	// 카데고리 별로 Shopping 가져오기
	public List<Shopping> getShoppingByCategory (String detailCategory) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			List<Shopping> shopping = sqlSession.selectList(namespace + "", detailCategory);
			return shopping;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	
	// 내가 올린 Shopping 가져오기
	public List<Shopping> getShoppingByUserId (String userId) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			List<Shopping> shopping = sqlSession.selectList(namespace + "", userId);
			return shopping;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	

}
