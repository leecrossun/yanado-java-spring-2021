package com.yanado.controller.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Shopping;

@Controller
@SessionAttributes("shopping")
@RequestMapping("shopping/delete")
public class DeleteShoppingController {
	
	@Autowired	
	private ShoppingDAO shoppingDAO;
	
	// 공동구매 파기하기
	
	public String delete(@RequestParam Shopping shopping) {
		shoppingDAO.deleteShopping(shopping);
		return "shopping/list";

	}

}
