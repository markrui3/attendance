package tju.att.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tju.att.base.BaseController;
import tju.att.domain.Check;
import tju.att.domain.User;

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
	
	/**
	 * 接受参数 check.attendanceid | check.reason | check.checkresult   
	 * 创建一个check 并且更新attendance的状态
	 * @param check
	 * @param httpSession
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addCheck", method={RequestMethod.POST})
	public Map<String, Object> addCheck(@RequestBody Check check,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		check.setUserid(user.getId());
		if(user.getPosition().equals(LEVEL_1)){
			check.setProperty(CHECK_1);
		}else if(user.getPosition().equals( LEVEL_2 )){
			check.setProperty(CHECK_2);
		}else if(user.getPosition().equals(LEVEL_3)){
			check.setProperty(CHECK_3);
		}
		if(checkManager.addCheckAndUpdateAtt(check)){
			map.put("status", OK);
		}else{
			map.put("status", ERROR);
		}
		return map;
	}
}
