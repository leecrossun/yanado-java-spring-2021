package com.yanado.controller.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.AlarmDAO;
import com.yanado.dto.Alarm;


@Controller
public class ReadAlarmController {
	@Autowired
	private AlarmDAO alarmDao;

	// 알람상세보기
	@RequestMapping("/alarm/read")
	public ModelAndView read(@RequestParam String alarmId) {
		Alarm alarm = alarmDao.findAlarmByAlarmId(alarmId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alarm/alarmRead");
		mav.addObject("alarm", alarm);

		return mav;
	}
}
