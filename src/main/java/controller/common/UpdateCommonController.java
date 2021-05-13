package controller.common;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import persistence.dao.CommonDAO;
import service.dto.Common;

@Controller
@RequestMapping("/common/update")
public class UpdateCommonController {
	@Autowired	
	private CommonDAO commonDao;
	
	// 공동구매 수정 폼으로 가기
		@RequestMapping(method = RequestMethod.GET)
		public String form(@ModelAttribute("common") Common common) {
			return "common/form";
		}

		// 공동구매 수정하기
		@RequestMapping(method = RequestMethod.POST)
		public String updateCommon(@Valid @ModelAttribute("common") Common updateCommon, BindingResult result,
				SessionStatus status) {

			if (result.hasErrors()) {
				return "common/updateForm";
			}

			status.setComplete();
			commonDao.updateCommon(updateCommon);
			return "common/list";
		}

}
