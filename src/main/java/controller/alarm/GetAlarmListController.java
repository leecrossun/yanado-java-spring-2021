package controller.alarm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.AlarmDAO;
import service.dto.Alarm;

@Controller
public class GetAlarmListController {
	@Autowired
	private AlarmDAO alarmDao;

	// common에서 알람 리스트
	@RequestMapping("/common/alarm")
	public ModelAndView getCommonList(@RequestParam String commonId) {
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(commonId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/common/alarm/list");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

	// auction에서 알람 리스트
	@RequestMapping("/auction/alarm")
	public ModelAndView getAuctionList(@RequestParam String autionId) {
		List<Alarm> alarmList = alarmDao.findAlarmByCommonId(autionId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/auction/alarm/list");
		mav.addObject("alarmList", alarmList);

		return mav;
	}

}
