package com.yanado.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;

//회원 목록 생성 작업 후 회원목록페이지로 이동
@Controller
@RequestMapping("/user/allUserlist")
public class UserListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	public UserDAO userDAO;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<User> list = userDAO.selectList();

		request.setAttribute("list", list);

		RequestDispatcher disp = request.getRequestDispatcher("/resources/templates/mypage/loginPage.html");
		disp.forward(request, response);
	}
} 

//@Controller
//@RequestMapping("/user/allUserlist")
//public class UserListController {
//	
//	@Autowired
//	public UserDAO userDAO;
//	
//	@RequestMapping
//	public ModelAndView viewUserList() {
//		List<User> user = userDAO.selectList();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userList", user);
//		
//		return mav;
//	}
//}
