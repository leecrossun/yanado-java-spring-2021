package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.service.AucService;

@Controller
public class JoinAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("auc/join")
	public String join(HttpServletRequest request, @RequestParam String ancNo, RedirectAttributes red) {
		return null;
	}
}
