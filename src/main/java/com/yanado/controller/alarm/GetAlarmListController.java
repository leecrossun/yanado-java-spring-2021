package com.yanado.controller.alarm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.AlarmDAO;
import com.yanado.dto.Alarm;

@Controller
public class GetAlarmListController {
	@Autowired
	private AlarmDAO alarmDao;

	// common에서 알람 리스트
	@RequestMapping("/common/alarm/list")
	public ModelAndView getCommonList(@RequestParam String commonId) {
		
		System.out.println(commonId);
		
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(commonId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alarm/alarmList");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

	// auction에서 알람 리스트
	@RequestMapping("/auction/alarm/list")
	public ModelAndView getAuctionList(@RequestParam String aucId) {
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(aucId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alarm/alarmList");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

}
