package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import persistence.dao.CommonDAO;
import persistence.dao.ProductDAO;
import service.dto.Common;


@Controller
@SessionAttributes("common")
@RequestMapping("common/create")
public class CreateCommonController {
	
	@Autowired
	private CommonDAO commonDao;
	
	@Autowired
	private ProductDAO proudcutDAO;
	
	// 공동구매 생성 폼으로 가기
	@ModelAttribute("common")
	public Common formBacking(HttpServletRequest request) {
		Common common = new Common();
		common.setMin(0);
		return common;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String form() {
		return "common/form";
	}

	// 공동구매 생성하기
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createCommon(@Valid @ModelAttribute("common") Common newCommon, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "common/form";
		}

		status.setComplete();
		commonDao.insertCommon(newCommon);
		return "common/list";
	}

}
