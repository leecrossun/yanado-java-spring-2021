package persistence.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.dto.Product;

public class ProductDAO {

	private SqlSessionFactory factory = null;

	// 객체 생성 시 커넥터에서 factory 전달받음
	public ProductDAO() {
//			factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		}

	// 물품 목록 조회 시 사용
	public List<Product> selectList() {
		List<Product> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("product.procduct_list");

		sqlSession.close();

		return list;
	}

	public int createProduct(Product dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.insert("product.procduct_create", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int updateProduct(Product dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.update("product.procduct_update", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int deleteProduct(String productId) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.delete("product.procduct_delete", productId);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int updateManager(Product dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.update("product.procduct_update_manager", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	// productId 로  물품 정보 가져오기
	public Product getUserByProductId(String productId) {
		Product dto = null;

		SqlSession sqlSession = factory.openSession();
		// selectList()와는 다르게 하나의 객체만을 반환받는 메서드
		dto = sqlSession.selectOne("product.procduct_byProductId", productId);

		sqlSession.close();

		return dto;
	}
	
}
