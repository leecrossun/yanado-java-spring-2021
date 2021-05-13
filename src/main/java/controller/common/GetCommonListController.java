package controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.CommonDAO;
import service.dto.Common;
import service.dto.CommonDTO;
import service.dto.Criteria;



@Controller
@RequestMapping("/common/list")
public class GetCommonListController {
	
	@Autowired	
	private CommonDAO commonDao;
	
	//@Autowired	
	//private ProductDAO productDAO;

	// 공동구매 리스트
	public ModelAndView getList(@RequestParam int page) {
		int total = commonDao.getCount();
		Criteria c = new Criteria(page, total);
		
		List<Common> common = commonDao.findAllCommon(c.getStartIndex(), c.getEndIndex());
		List<CommonDTO> commonList = new ArrayList<CommonDTO>();
		
		for(Common com : common) {
			String proudctId = com.getProductId();
			// Product product = 
			// commonList.add(new CommonDTO(com, product));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);

		return mav;
	}

}
