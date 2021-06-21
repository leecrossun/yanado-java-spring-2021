package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;

@Controller

public class JoinAucController {

	@Autowired
	private AucDAO aucService;

	@RequestMapping("/auc/join")
	public String join(HttpServletRequest request, @RequestParam String aucId, @RequestParam int price,
			RedirectAttributes red) throws Exception {

		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());

		Auc auc = aucService.getAuc(aucId);

		if (auc.getHighestPrice() < price) {
			auc.setHighestPrice(price);
			auc.setHighestUserId(userId);
			aucService.updateAuc(auc);
		}

		AucJoin join = new AucJoin(aucId, userId, price);
		aucService.joinAuc(join);

		red.addAttribute("aucId", aucId);

		return "redirect:/auc/view/detail";
	}

	@RequestMapping("/auc/join/price")
	public ModelAndView form(@RequestParam String aucId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/priceForm");
		mav.addObject("aucId", aucId);

		return mav;
	}

}
