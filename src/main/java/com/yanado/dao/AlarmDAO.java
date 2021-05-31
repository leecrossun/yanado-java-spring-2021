package com.yanado.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yanado.dto.Alarm;


@Mapper
public interface AlarmDAO {

	// Alarm CRUD
	void insertAlarm(Alarm alarm);

	Alarm findAlarmByAlarmId(String alarmId);

	
	// typeId = commonId or AuctionId, type = 수정, 결과 통보 등...
	// 해당 common (or auction)에 대한 alarm을 찾을 때는, typeId가 겹칠 수 있으므로 type을 이용
	// common은 1 - 3 / auction은 4 - 6 사이의 type을 찾는다.
	//List<Alarm> findAlarmByTypeIdAndType(String typeId, int type);

	List<Alarm> findAlarmByCommonId(String typeId);

	List<Alarm> findAlarmByAuctionId(String typeId);

	// MyPage
	List<Alarm> findAllAlarmByUserId(String userId);
}
