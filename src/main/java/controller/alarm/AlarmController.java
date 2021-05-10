package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AlarmDao;
import dto.Alarm;

@RequestMapping("/alarm/*")
@Controller
public class AlarmController {
	@Autowired
	private AlarmDao alarmDao;

	// 알람 리스트
	@RequestMapping("common/list")
	public ModelAndView getCommonList(@RequestParam String commonId) {
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(commonId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/alarmList");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

	// 알람 리스트
	@RequestMapping("auction/list")
	public ModelAndView getAuctionList(@RequestParam String autionId) {
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(autionId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auction/alarmList");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

	// 알람상세보기
	@RequestMapping("read")
	public ModelAndView read(@RequestParam String alarmId) {
		Alarm alarm = alarmDao.findAlarmByAlarmId(alarmId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("readAlarm");
		mav.addObject("alarm", alarm);

		return mav;
	}
}
