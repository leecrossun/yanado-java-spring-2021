package com.yanado.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.AlarmDAO;
import com.yanado.dao.FavoriteDAO;
import com.yanado.service.CommonService;


@Controller

public class DeleteCommonController {
	@Autowired	
	private CommonService commonService;
	
	@Autowired
	private FavoriteDAO favoriteDao;
	
	@Autowired
	private AlarmDAO alarmDao;
	
	// 공동구매 파기하기
	@RequestMapping("/common/delete")
	public String delete(@RequestParam String commonId, @RequestParam String productId) {
		
		favoriteDao.deleteAllFavorite(productId);
		alarmDao.deleteAllCommonAlarm(commonId);
		
		commonService.deleteAllCommonJoin(commonId);
		commonService.deleteCommonByCommonId(commonId);
		
		return "redirect:/common/list";

	}
}
