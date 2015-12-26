package tju.att.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tju.att.base.BaseHandlerController;
import tju.att.domain.Sign;
import tju.att.domain.User;

@Controller
@RequestMapping("/sign")
public class SignController extends BaseHandlerController{

	@ResponseBody
	@RequestMapping(value="/addSign", method={RequestMethod.POST})
	public Map<String, Object> add(@RequestBody Sign sign,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			sign.setUserid(user.getId());
			signManager.add(user.getId());
			map.put("status", OK);
		}else{
			map.put("status", ERROR);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getMonth/{dateStr}")
	public Map<String, Object> getMonth(@PathVariable String dateStr,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			List<Sign> list = signManager.getMonth(dateStr,user.getId());
			map.put("status", OK);
			map.put("list", changeSignList(list));
		}else{
			map.put("status", ERROR);
			map.put("list", null);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/get/{signid}")
	public Map<String, Object> getMonth(@PathVariable Long signid,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			Sign sign = signManager.get(signid);
			map.put("status", OK);
			map.put("sign", getSignObj(sign));
		}else{
			map.put("status", ERROR);
			map.put("sign", null);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/getDay")
	public Map<String, Object> getMonth(HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			Sign sign = signManager.getToday(user.getId());
			map.put("status", OK);
			map.put("sign", getSignObj(sign));
		}else{
			map.put("status", ERROR);
			map.put("sign", null);
		}
		return map;
	}
}