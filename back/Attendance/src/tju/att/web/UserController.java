package tju.att.web;

import java.util.HashMap;
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
	 * ͨ���ֻ��ź������¼
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
	 * ����һ���û�
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
				httpSession.setAttribute("user", userInfo); // дsession
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
	 * ����һ���û�
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

}