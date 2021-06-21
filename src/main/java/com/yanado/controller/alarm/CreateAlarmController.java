package com.yanado.controller.alarm;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.AlarmDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dto.Alarm;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Product;
import com.yanado.service.AucService;
import com.yanado.service.CommonService;

@Controller
@SessionAttributes("alarm")
public class CreateAlarmController {
	@Autowired
	private AlarmDAO alarmDao;

	@Autowired
	private CommonService commonService;

	@Autowired
	private ProductDAO productDao;

	@Autowired
	private AucService aucService;

	// 알람 생성 폼으로 가기
	@ModelAttribute("alarm")
	public Alarm formBacking(HttpServletRequest request) {
		Alarm alarm = new Alarm();
		int flag = Integer.parseInt(request.getParameter("flag"));

		if (flag == 1) {
			String commonId = request.getParameter("commonId");
			Common common = commonService.findCommonByCommonId(commonId);
			Product product = productDao.getProductByProductId(common.getProductId()); // 나중에 수정

			alarm.setDeadline(common.getDeadline());
			alarm.setPrice(product.getPrice());
			alarm.setCommonId(commonId);
			alarm.setAucId(null);

		} else {
			// 옥션일 때 채우기
			String aucId = request.getParameter("aucId");
			Auc auc = aucService.getAuc(aucId);
			Product product = productDao.getProductByProductId(auc.getProductId()); // 나중에 수정

			alarm.setPrice(auc.getHighestPrice());
			alarm.setCommonId(null);
			alarm.setAucId(aucId);
		}

		return alarm;
	}

	@RequestMapping(value = "/alarm/create", method = RequestMethod.GET)
	public String form() {
		return "alarm/alarmForm";
	}

	// 알람 생성하기
	@RequestMapping(value = "/alarm/create", method = RequestMethod.POST)
	public String createalarm(@Valid @ModelAttribute("alarm") Alarm newalarm, BindingResult result,
			RedirectAttributes red, SessionStatus status) {

		if (result.hasErrors()) {
			return "/alarm/alarmForm";
		}

		if (newalarm.getCommonId() != null) {

			List<CommonJoin> commonJoin = commonService.findAllCommonJoinByCommonId(newalarm.getCommonId());

			newalarm.setUserId(null);
			alarmDao.insertAlarm(newalarm);

			System.out.println(newalarm.getAlarmId());

			for (CommonJoin j : commonJoin) {
				newalarm.setUserId(j.getUserId());
				alarmDao.insertAlarm(newalarm);
			}
		} else {
			// auction

			List<AucJoin> aucJoin = aucService.getAucJoinByAucId(newalarm.getAucId());
			newalarm.setUserId(null);
			alarmDao.insertAlarm(newalarm);

			System.out.println(newalarm.getAlarmId());

			for (AucJoin j : aucJoin) {
				newalarm.setUserId(j.getUserId());
				alarmDao.insertAlarm(newalarm);
			}
		}

		status.setComplete();

		if (newalarm.getCommonId() != null) {
			red.addAttribute("commonId", newalarm.getCommonId());
			return "redirect:/common/alarm/list";
		} else {
			red.addAttribute("aucId", newalarm.getAucId());
			return "redirect:/auc/alarm/list";
		}

	}
}
