package controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import persistence.dao.CommonDao;
import service.dto.Common;
import service.dto.CommonJoin;

@Controller
@SessionAttributes("common")
public class CommonJoinController {
	@Autowired
	private CommonDao commonDao;

	// 공동구매 참여하기
	@RequestMapping("/common/join")
	public ModelAndView join(HttpServletRequest request, @ModelAttribute("common") Common common)
			throws Exception {
		String commonId = common.getCommonId();
		String userId = null;
		
		common.setParticipants(common.getParticipants()+1);
		commonDao.updateCommon(common);
		CommonJoin join = new CommonJoin(commonId, userId, 0);
		commonDao.joinCommon(join);
		
		if(common.getMin() <= common.getParticipants() + 1) {
			commonDao.updateCommonStatus(commonId, 3);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("common", common);
		mav.setViewName("/common/read");
		return mav;
	}
	
	// 공동구매 참여 취소하기
	public ModelAndView cancel(HttpServletRequest request, @ModelAttribute("common") Common common)
			throws Exception {
		String commonId = common.getCommonId();
		String userId = null;
		
		common.setParticipants(common.getParticipants()-1);
		commonDao.updateCommon(common);
		commonDao.cancelCommon(commonId, userId);
		
		if(common.getMin() < common.getParticipants() - 1) {
			commonDao.updateCommonStatus(commonId, 2);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("common", common);
		mav.setViewName("/common/read");
		return mav;
	}
}
