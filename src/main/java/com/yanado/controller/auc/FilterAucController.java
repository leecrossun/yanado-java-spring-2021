package com.yanado.controller.auc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ProductDAO;
import com.yanado.service.AucService;

@Controller
public class FilterAucController {
	@Autowired
	private AucService aucService;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("auc/filter")
	public ModelAndView filterList(@RequestParam(required = false, defaultValue = "1") int page, String filterKey) {
		
		return null;
	}
}
