package com.yanado;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yanado.dao.AlarmDAO;
import com.yanado.dto.Alarm;
import com.yanado.dto.Common;
import com.yanado.dto.Product;
import com.yanado.service.CommonService;

@Component
public class Scheduler {

	@Autowired
	private CommonService service;

	@Autowired
	private AlarmDAO alarmDao;

	@Scheduled(cron = "0 0 0 * * *")
	public void chageStatus() {
		List<Common> list = service.findAll();
		Date today = new Date(System.currentTimeMillis());

		for (Common c : list) {
			Product p = service.findProduct(c.getProductId());
			
			if (c.getStartDate().compareTo(today) == 0) {
				service.changeStatus(c.getCommonId(), 2);
			}

			if (c.getEndDate().compareTo(today) == 0) {
				if (c.getParticipants() >= c.getMin()) {
					service.changeStatus(c.getCommonId(), 5);

					// alarm
					Alarm alarm = new Alarm(c.getUserId(), c.getCommonId(), null, 1, p.getPrice(),
							"최소 인원이 넘어 공동구먀가 성사되었습니다.\n 해당 날짜 이전까지 결제해주시길 바랍니다.", today, c.getDeadline());
					alarmDao.insertAlarm(alarm);

				} else {
					service.changeStatus(c.getCommonId(), 4);
					
					// alarm
					Alarm alarm = new Alarm(c.getUserId(), c.getCommonId(), null, 1, p.getPrice(),
							"최소 인원을 넘지 못하여 공동구매가 성사되지 못하였습니다.", today, c.getDeadline());
					alarmDao.insertAlarm(alarm);
				}
			}

			if (c.getDeadline().compareTo(today) == 0) {
			}
		}
	}
}
