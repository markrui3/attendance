package tju.att.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tju.att.base.BaseController;
import tju.att.domain.Holiday;
import tju.att.domain.User;

@Controller
@RequestMapping("/holiday")
public class HolidayController extends BaseController{
	
	/**
	 * 获取所有的假期类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holiday> list = holidayManager.getAll();
		map.put("listHoliday", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getOneHoli")
	public Map<String, Object> getOneHoli(HttpSession httpSession){
		User user = (User)httpSession.getAttribute("user");
		Map<String, Object> map = holidayManager.getOnePer(user);
		return map;
	}
}
