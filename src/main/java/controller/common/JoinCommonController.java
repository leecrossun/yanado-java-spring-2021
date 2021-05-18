package controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import persistence.dao.CommonDAO;
import service.dto.Common;
import service.dto.CommonJoin;

@RequestMapping("/common/join")
@Controller
public class JoinCommonController {
	private CommonDAO commonDao;

	// 공동구매 참여하기
	@RequestMapping("/common/join")
	public ModelAndView join(HttpServletRequest request, @ModelAttribute("common") Common common)
			throws Exception {
		String commonId = common.getCommonId();
		String userId = null;
		
		//common.setParticipants(common.getParticipants()+1);
		commonDao.increaseJoin(commonId);
		CommonJoin join = new CommonJoin(commonId, userId, 0);
		commonDao.joinCommon(join);
		
		if(common.getMin() <= common.getParticipants() + 1) {
			commonDao.changeStatus(commonId, 3);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("common", common);
		mav.setViewName("/common/read");
		return mav;
	}

}
