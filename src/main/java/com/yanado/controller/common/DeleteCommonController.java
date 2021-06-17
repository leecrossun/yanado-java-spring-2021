package com.yanado.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yanado.service.CommonService;


@Controller

public class DeleteCommonController {
	@Autowired	
	private CommonService commonService;
	
	// 공동구매 파기하기
	@RequestMapping("/common/delete")
	public String delete(@RequestParam String commonId) {
		commonService.deleteAllCommonJoin(commonId);
		commonService.deleteCommonByCommonId(commonId);
		
		return "redirect:/common/list";

	}
}
