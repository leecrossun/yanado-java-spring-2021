package com.yanado.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.yanado.dto.User;

@Mapper
@Service
@Transactional
public interface UserDAO {
	
	// 회원 목록 조회 시 사용
	public List<User> selectList();
	
	public void createUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(String userId);
	
	public int updateManager(User user);
	
	// 아이디로 개인정보 가져오기
	public User getUserByUserId(String userId);
	
	// 아이디로 알림 / 경매(완료, 진행중) / 주문내역 / 장바구니 리스트 가져오기
//	public List<T> getListByUserId(String userId) {
//		
//	}
	
	public int changeRankCount(String userId);

	public int Login(User user);
}
