package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.UserDAO;
import com.yanado.dto.Common;
import com.yanado.dto.User;
import com.yanado.service.UserService;

//회원 정보 업데이트
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	
	@ModelAttribute("user")
	public User formBacking(HttpServletRequest request) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		User user = userDAO.getUserByUserId(userId);
		
		return user;
	}

	@RequestMapping(value="/updateInfo", method=RequestMethod.POST)
	protected String service(HttpServletRequest request, @ModelAttribute("user") User user, SessionStatus status)
			throws ServletException, IOException {

		int res = userDAO.updateUser(user);
		
		System.out.println("userId : " + user.getUserId());
		
		status.setComplete();
		
		return "user/mypageMain";
	}
	
	@RequestMapping(value="/updateInfo", method=RequestMethod.GET)
	public String form() {
		return "user/mypageUpdate";
	}
}