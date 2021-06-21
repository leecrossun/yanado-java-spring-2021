package com.yanado.controller.auc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dto.AucJoin;
import com.yanado.service.AucService;

@Controller
@RequestMapping("/auc/winner")
public class winningAucController {
	@Autowired
	private AucService aucService;
	
	public String search(HttpServletRequest request,@RequestParam String aucId) {
		List<AucJoin> list = aucService.getAucJoinByAucId(aucId);
		int high = 0;
		int num=0;
		String name="";
		for (AucJoin a : list) {
			 num = a.getBidPrice();
			if(num>high) {
				high = num;
				name = a.getUserId();
			}
		}
		return name;
	}
}
