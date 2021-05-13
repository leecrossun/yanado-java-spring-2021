package controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.CommonDAO;
import service.dto.Common;
import service.dto.Criteria;

@Controller
@RequestMapping("/common/list")
public class GetCommonListController {
	
	@Autowired	
	private CommonDAO commonDao;

	// 공동구매 리스트
	public ModelAndView getList(@RequestParam int page) {
		int total = commonDao.getCount();
		Criteria c = new Criteria(page, total);
		
		List<Common> commonList = commonDao.findAllCommon(c.getStartIndex(), c.getEndIndex());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);

		return mav;
	}

}
