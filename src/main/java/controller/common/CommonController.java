package controller.common;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.CommonDao;
import service.dto.Common;

@RequestMapping("/common/*")
@Controller
public class CommonController {
	@Autowired
	private CommonDao commonDao;

	// 공동구매 리스트
	@RequestMapping("list")
	public ModelAndView getList(@RequestParam int page) {
		List<Common> commonList = commonDao.findAllCommon(page, 10);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);

		return mav;
	}

	// 공동구매 찾기
	public ModelAndView searchList(@RequestParam int page, @RequestParam String condition,
			@RequestParam String searchKey) {
		List<Common> commonList = commonDao.findCommonBySearch(condition, searchKey, page, 10);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		return mav;
	}

	// 공동구매 보기
	@RequestMapping("read")
	public ModelAndView read(@RequestParam String commonId) {
		Common common = commonDao.findCommonByCommonId(commonId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/readCommon");
		mav.addObject("common", common);

		return mav;
	}

	// 공동구매 수정 폼으로 가기
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String form(@ModelAttribute("common") Common common) {
		return "common/form";
	}

	// 공동구매 수정하기
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateCommon(@Valid @ModelAttribute("common") Common updateCommon, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "common/updateForm";
		}

		status.setComplete();
		commonDao.updateCommon(updateCommon);
		return "common/list";
	}

	// 공동구매 파기하기
	@RequestMapping("delete")
	public String delete(@RequestParam String commonId) {
		commonDao.deleteCommonByCommonId(commonId);
		return "common/list";

	}

}
