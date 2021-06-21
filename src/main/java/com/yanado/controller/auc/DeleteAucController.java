package com.yanado.controller.auc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.AlarmDAO;
import com.yanado.dao.FavoriteDAO;
import com.yanado.dto.User;
import com.yanado.service.AucService;
import com.yanado.service.UserService;

@Controller
public class DeleteAucController {
	@Autowired
	private AucService aucService;
	private AlarmDAO alarmDao;
	private UserService userService;
	private FavoriteDAO favoriteDao;
	
	@RequestMapping("auc/delete")
	public String delete(@RequestParam String productId, @RequestParam String userId, @RequestParam String aucNo) {
		User user = userService.getUserByUserId(userId);
		if(user==null) {
			alarmDao.deleteAllAcuAlarm(aucNo);
			favoriteDao.deleteAllFavorite(productId);
			aucService.cancelAllAucJoin(aucNo);
			aucService.deleteAuc(aucNo);
		}

		return "redirect:/auc/list";
	}
}
