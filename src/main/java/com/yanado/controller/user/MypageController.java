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
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.AlarmDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Alarm;
import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.Product;
import com.yanado.dto.User;
import com.yanado.service.CommonService;

// 해당 회원 아이디로 정보 가져와서 마이페이지로 이동
@WebServlet("/user/mypage")
@Controller
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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		User dto = userDAO.getUserByUserId(userId);

		request.setAttribute("dto", dto);

		RequestDispatcher disp = request.getRequestDispatcher("/user/user_mypage.jsp");
		disp.forward(request, response);
	}

	@RequestMapping("/user/list/my")
  public ModelAndView myList(HttpServletRequest request) {
		 UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/userList");
		
		// 3 : common, 5 : alarm

		userId = "admin";
		int type = Integer.parseInt(request.getParameter("type"));

		if (type == 3) {
			List<Common> comList = commonService.findCommonByUserId(userId);
			List<CommonDTO> commonList = new ArrayList<CommonDTO>();
			
			for(Common common : comList) {
				Product p = productDao.getProductByProductId(common.getProductId());
				commonList.add(new CommonDTO(common, p));
			}
			
			mav.addObject("list", commonList);
		}
		
		if(type == 5) {
			List<Alarm> alarmList = alarmDao.findAllAlarmByUserId(userId);
			mav.addObject("list", alarmList);
		}
		
		mav.addObject("type", type);
		
		return mav;
	}
}