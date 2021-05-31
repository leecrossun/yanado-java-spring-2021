package persistence.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.dto.User;

public class UserDAO {

	// 싱글톤패턴 --------------------------------------------------------------------
	static UserDAO single = null;

	public static UserDAO getInstance() {
		if (single == null)
			single = new UserDAO();
		return single;
	}
	// -----------------------------------------------------------------------------

	private SqlSessionFactory factory = null;

	// 객체 생성 시 커넥터에서 factory 전달받음
	public UserDAO() {
//		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	// 회원 목록 조회 시 사용
	public List<User> selectList() {
		List<User> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("user.user_list");

		sqlSession.close();

		return list;
	}

	public int createUser(User dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.insert("user.user_create", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int updateUser(User dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.update("user.user_update", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	public int deleteUser(String userId) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.delete("user.user_delete", userId);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}
	
	public int updateManager(User dto) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.update("user.user_update_manager", dto);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}
	
	// 아이디로 개인정보 가져오기
	public User getUserByUserId(String userId) {
		User dto = null;

		SqlSession sqlSession = factory.openSession();
		// selectList()와는 다르게 하나의 객체만을 반환받는 메서드
		dto = sqlSession.selectOne("user.user_byUserId", userId);

		sqlSession.close();

		return dto;
	}
	
	// 아이디로 알림 / 경매(완료, 진행중) / 주문내역 / 장바구니 리스트 가져오기
//	public List<T> getListByUserId(String userId) {
//		
//	}
	
	public int changeRankCount(String userId) {
		int result = 0;

		SqlSession sqlSession = factory.openSession();
		result = sqlSession.update("user.user_changeRankcount", userId);

		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();

		return result;
	}
}
