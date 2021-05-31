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
import service.dto.Search;

@Controller
@RequestMapping("/common/search")
public class SearchCommonController {
	@Autowired
	private CommonDAO commonDao;

	// 공동구매 찾기
	public ModelAndView searchList(@RequestParam int page, @RequestParam String condition,
			@RequestParam String searchKey) {
		
		int totalcount = commonDao.getCount();
		Criteria c = new Criteria(page, totalcount);
		Search search = new Search(condition, searchKey, c.getStartIndex(), c.getEndIndex());

		List<Common> commonList = commonDao.findCommonBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		
		return mav;
	}
}
