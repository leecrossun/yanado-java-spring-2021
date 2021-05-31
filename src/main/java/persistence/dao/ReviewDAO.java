package persistence.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import service.dto.Review;

public class ReviewDAO {
	
	//private static JDBCUtil jdbcUtil = null;
	private SqlSessionFactory sqlSessionFactory;
	
	String namespace = ""; // xml 작성 시 추가할 것

	public ReviewDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Review> getReviewByShoppingId (String reviewId) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			List<Review> review = sqlSession.selectList(namespace + "", reviewId);
			return review;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	
	public int createReview(Review review) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.insert(namespace + "", review);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateReview(Review review) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.update(namespace + "", review);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteReview(String reviewId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			// statement 추가할 것
			int result = sqlSession.delete(namespace + "", reviewId);
			
			if (result > 0) {sqlSession.commit();}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}

	
	

}
