package controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import persistence.dao.CommonDAO;


@Controller
@RequestMapping("/common/delete")
public class DeleteCommonController {
	@Autowired	
	private CommonDAO commonDao;
	
	// 공동구매 파기하기
	
	public String delete(@RequestParam String commonId) {
		commonDao.deleteCommonByCommonId(commonId);
		return "common/list";

	}
}
