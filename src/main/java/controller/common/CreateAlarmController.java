package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import persistence.dao.AlarmDao;
import service.dto.Alarm;

@Controller
@SessionAttributes("alarm")
@RequestMapping("alarm/create")
public class CreateAlarmController {
	@Autowired
	private AlarmDao alarmDao;
	
	// 알람 생성 폼으로 가기
	@ModelAttribute("alarm")
	public Alarm formBacking(HttpServletRequest request) {
		Alarm alarm = new Alarm();
		return alarm;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String form() {
		return "alarm/form";
	}

	// 알람 생성하기
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createalarm(@Valid @ModelAttribute("alarm") Alarm newalarm, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "alarm/form";
		}

		status.setComplete();
		alarmDao.createAlarm(newalarm);
		return "alarm/list";
	}
}
