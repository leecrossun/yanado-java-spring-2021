package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.service.AucService;

@Controller
@RequestMapping("/auc/winner")
public class winningAucController {
	@Autowired
	private AucService aucService;
	
	public String search(HttpServletRequest request,@RequestParam String aucNo, Object userId) {
		aucService.getBuyerListByAucNo(int userId);
		return null;
	}
}
