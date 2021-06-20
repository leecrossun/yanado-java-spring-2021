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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
// 마이페이지 메인에서 상세정보 페이지로 이동
@Controller
public class MainToDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("user/update")
	protected ModelAndView service(HttpServletRequest request) throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		User dto = userDAO.getUserByUserId(userId);
		
		request.setAttribute("dto", dto);
		
		mav.setViewName("user/update");
		mav.addObject("user", dto);
		return mav;

	}
}