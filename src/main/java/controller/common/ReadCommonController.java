package controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.dto.CommonDTO;

@Controller
@RequestMapping("/common/read")
public class ReadCommonController {
	
	// 공동구매 보기
	public ModelAndView read(@ModelAttribute CommonDTO common) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/read");
		mav.addObject("common", common);

		return mav;
	}
}
