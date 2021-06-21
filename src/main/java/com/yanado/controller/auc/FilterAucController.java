package com.yanado.controller.auc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ProductDAO;
import com.yanado.dto.Auc;
import com.yanado.dto.AucDTO;
import com.yanado.dto.Product;
import com.yanado.dto.Search;
import com.yanado.service.AucService;


@Controller
public class FilterAucController {
	@Autowired
	private AucService aucService;
	
	@Autowired
	private ProductDAO productDAO;

	
	@RequestMapping("/auc/filter")
	public ModelAndView filterList(String filterKey) {
		
		List<Auc> auc = aucService.filterAuc(Integer.parseInt(filterKey));
		List<AucDTO> aucList = new ArrayList<AucDTO>();
		
		for (Auc a : auc) {
			System.out.println(a.getAucId());
			Product product = productDAO.getProductByProductId(a.getProductId());
			aucList.add(new AucDTO(a, product));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/aucList");
		mav.addObject("aucList", aucList);
		return mav;
	}
	
}
