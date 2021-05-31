package controller.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.AlarmDAO;
import service.dto.Alarm;

@RequestMapping("/alarm/read")
@Controller
public class ReadAlarmController {
	@Autowired
	private AlarmDAO alarmDao;

	// 알람상세보기
	public ModelAndView read(@RequestParam String alarmId) {
		Alarm alarm = alarmDao.findAlarmByAlarmId(alarmId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("readAlarm");
		mav.addObject("alarm", alarm);

		return mav;
	}
}
