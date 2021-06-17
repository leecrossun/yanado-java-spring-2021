package com.yanado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanado.dao.CommonDAO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Product;
import com.yanado.dto.Search;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommonService {

	@Autowired
	private CommonDAO dao;

	// 나중에 지움

	public Product findProduct(String productId) {
		return dao.findProduct(productId);
	}

	public int getCount() {
		return dao.getCount();
	}

	public int getSearchCount(String search) {
		return dao.getSearchCount(search);
	}

	public int getFilterCount1(int filter) {
		return dao.getFilterCount1(filter);
	}

	public int getFilterCount2() {
		return dao.getFilterCount2();
	}

	// Common CRUD

	public void insertCommon(Common common) {
		dao.insertCommon(common);
	}

	public int updateCommon(Common common) {
		return dao.updateCommon(common);
	}

	public int deleteCommonByCommonId(String commonId) {
		return dao.deleteCommonByCommonId(commonId);
	}

	public List<Common> findAll() {
		return dao.findAll();
	}

	public List<Common> findAllCommon(Search page) {
		return dao.findAllCommon(page);
	}

	public List<Common> findCommonBySearch(Search search) {
		return dao.findCommonBySearch(search);
	}

	public List<Common> findCommonBySort(Search sort) {
		return dao.findCommonBySort(sort);
	}

	public List<Common> findCommonByFilter1(Search filter) {
		return dao.findCommonByFilter1(filter);
	}

	public List<Common> findCommonByFilter2(Search filter) {
		return dao.findCommonByFilter2(filter);
	}

	public Common findCommonByCommonId(String commonId) {
		return dao.findCommonByCommonId(commonId);
	}

	public int deleteAllCommonJoin(String commonId) {
		return dao.deleteAllCommonJoin(commonId);
	}

	// 필드 한개만 변경될 시

	public int increaseJoin(String commonId) {
		return dao.increaseJoin(commonId);
	}

	public int decreaseJoin(String commonId) {
		return dao.decreaseJoin(commonId);
	}

	public int changeStatus(String commonId, int status) {
		return dao.changeStatus(commonId, status);
	}

	// CommonJoin

	public int joinCommon(CommonJoin commonJoin) {
		return dao.joinCommon(commonJoin);
	}

	public int cancelCommon(CommonJoin commonJoin) {
		return dao.cancelCommon(commonJoin);
	}

	public int findCommonJoin(CommonJoin commonJoin) {
		return dao.findCommonJoin(commonJoin);
	}

	public List<CommonJoin> findAllCommonJoinByCommonId(String commonId) {
		return dao.findAllCommonJoinByCommonId(commonId);
	}

	public List<CommonJoin> notPayment(String commonId) {
		return dao.notPayment(commonId);
	}

	// My Page
	public List<Common> findCommonByUserId(String userId) {
		return dao.findCommonByUserId(userId);
	}

}
