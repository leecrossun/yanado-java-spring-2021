package controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.ProductDAO;
import service.dto.Common;
import service.dto.CommonDTO;
import service.dto.Product;


@Controller
@RequestMapping("/common/read")
public class ReadCommonController {
	
	@Autowired
	private ProductDAO productDAO = new ProductDAO();
	
	// 공동구매 보기
	public ModelAndView read(@ModelAttribute Common common) {
		// AlarmDao alarmDao = new AlarmDao();
		// List<Alarm> alarm;
		// List<CommonJoin> join;
		Product product = null; // = productDAO.;

		CommonDTO commonDTO = new CommonDTO(common, product);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/read");
		mav.addObject("common", commonDTO);

		return mav;
	}
}
