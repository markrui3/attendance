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

import tju.att.base.BaseController;
import tju.att.domain.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * 通过手机号和密码登录
	 */
	@ResponseBody
	@RequestMapping("/login/{phone}/{pwd}")
	public Map<String, Object> login(@PathVariable String phone,
			@PathVariable String pwd, HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User userLogin = userManager.findByPhoneAndPwd(phone, pwd);
		if (userLogin != null) {
			httpSession.setAttribute("user", userLogin);
			map.put("status", OK);
			map.put("user", userLogin);
		} else {
			map.put("status", ERROR);
			map.put("user", null);
		}
		return map;
	}

	/**
	 * 添加一个用户
	 */
	@ResponseBody
	@RequestMapping(value = "/regist", method = { RequestMethod.POST })
	public Map<String, Object> regist(@RequestBody User userInfo,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("userInfo" + userInfo);
		if (userManager.findByPhone(userInfo.getPhone()) != null) {
			map.put("states", "PHONEEXSIT");
			map.put("user", null);
		} else {
			if (userManager.saveUser(userInfo)) {
				httpSession.setAttribute("user", userInfo); // 写session
				map.put("states", OK);
				map.put("user", userInfo);
			} else {
				map.put("states", ERROR);
				map.put("user", null);
			}
		}
		return map;
	}

	/**
	 * 更新一个用户
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public Map<String, Object> update(@RequestBody User userInfo,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userManager.updateUser(userInfo)) {
			map.put("states", OK);
			map.put("user", userInfo);
		} else {
			map.put("states", ERROR);
			map.put("user", null);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public Map<String, Object> logout(HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		httpSession.removeAttribute("user");
		httpSession.invalidate();
		map.put("status", OK);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			List<User> list = userManager.getAll();
			map.put("status", OK);
			map.put("list", list);
		}else{
			map.put("status", ERROR);
			map.put("list", null);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getPage/{pageNow}/{pageSize}")
	public Map<String, Object> getPage(@PathVariable String pageNow,
			@PathVariable String pageSize,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			List<User> list = userManager.getPage(pageNow, pageSize);
			map.put("status", OK);
			map.put("list", list);
		}else{
			map.put("status", ERROR);
			map.put("list", null);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getById/{userid}")
	public Map<String, Object> getById(@PathVariable String userid,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		if(user != null){
			User userGet = userManager.findById(Long.parseLong(userid));
			map.put("status", OK);
			map.put("user", userGet);
		}else{
			map.put("status", ERROR);
			map.put("user", null);
		}
		return map;
	}

}
