package com.yanado.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.AlarmDAO;
import com.yanado.dao.AucDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Alarm;
import com.yanado.dto.Auc;
import com.yanado.dto.AucDTO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.Product;
import com.yanado.dto.User;
import com.yanado.service.AucService;
import com.yanado.service.CommonService;

// 해당 회원 아이디로 정보 가져와서 마이페이지로 이동
@Controller
//@WebServlet("/user/mypageMain")
public class MypageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CommonService commonService;

	@Autowired
	private AlarmDAO alarmDao;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private AucService aucService;
	
	@RequestMapping("user/mypageMain")
	protected ModelAndView service(HttpServletRequest request) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		User dto = userDAO.getUserByUserId(userId);
		
		request.setAttribute("dto", dto);
		
		/*
		 * RequestDispatcher disp =
		 * request.getRequestDispatcher("/resources/templates/user/mypageMain.html");
		 * disp.forward(request, response);
		 */
		
		mav.setViewName("user/mypageMain");
		mav.addObject("user", dto);
		return mav;

	}

	@RequestMapping("/user/list/my")
	public ModelAndView myList(HttpServletRequest request, @RequestParam int type) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/userList");

		// 3 : common, 5 : alarm

		userId = "admin";
		//int type = Integer.parseInt(request.getParameter("type"));

		if (type == 3) {
			List<Common> comList = commonService.findCommonByUserId(userId);
			List<CommonDTO> commonList = new ArrayList<CommonDTO>();

			for (Common common : comList) {
				Product p = productDao.getProductByProductId(common.getProductId());
				commonList.add(new CommonDTO(common, p));
			}

			mav.addObject("list", commonList);
		}
		
		if(type == 4) {
			List<Auc> aucList = aucService.getAucByUserId(userId);
			
			List<AucDTO> auctionList = new ArrayList<AucDTO>();

			for (Auc auc : aucList) {
				Product p = productDao.getProductByProductId(auc.getProductId());
				auctionList.add(new AucDTO(auc, p));
			}

			mav.addObject("list", auctionList);
		}

		if (type == 5) {
			List<Alarm> alarmList = alarmDao.findAllAlarmByUserId(userId);
			mav.addObject("list", alarmList);
		}

		mav.addObject("type", type);

		return mav;
	}
}