package tju.att.web;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tju.att.base.BaseHandlerController;
import tju.att.domain.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseHandlerController {

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
	public Map<String, Object> logout(HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		httpSession.removeAttribute("user");
		httpSession.invalidate();
		map.put("status", OK);
		return map;
	}

	@ResponseBody
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) httpSession.getAttribute("user");
		if (user != null && user.getPosition().equals("10")) {
			List<User> list = userManager.getAll();
			map.put("status", OK);
			map.put("list", list);
		} else {
			map.put("status", ERROR);
			map.put("list", null);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/getPage/{pageNow}/{pageSize}")
	public Map<String, Object> getPage(@PathVariable String pageNow,
			@PathVariable String pageSize, HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) httpSession.getAttribute("user");
		if (user != null) {
			List<User> list = userManager.getPage(pageNow, pageSize);
			map.put("status", OK);
			map.put("list", list);
		} else {
			map.put("status", ERROR);
			map.put("list", null);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/getById/{userid}")
	public Map<String, Object> getById(@PathVariable String userid,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) httpSession.getAttribute("user");
		if (user != null) {
			User userGet = userManager.findById(Long.parseLong(userid));
			map.put("status", OK);
			map.put("user", userGet);
		} else {
			map.put("status", ERROR);
			map.put("user", null);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/delete/{userid}")
	public Map<String, Object> delete(@PathVariable String userid,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) httpSession.getAttribute("user");
		if (user != null) {
			if (userManager.delete(Long.parseLong(userid))) {
				map.put("status", OK);
			} else {
				map.put("status", ERROR);
			}
		} else {
			map.put("status", ERROR);
		}
		return map;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/addFromExcel", method = { RequestMethod.POST })
	 * public Map<String, Object> addFromExcel(@RequestBody File
	 * upload,HttpSession httpSession){ Map<String, Object> map = new
	 * HashMap<String, Object>(); User user =
	 * (User)httpSession.getAttribute("user"); if(user != null &&
	 * user.getPosition().equals("10")){ String path = saveUploadFile(upload,
	 * httpSession); map.put("status", OK); }else{ map.put("status", ERROR); }
	 * return map; }
	 */

	@ResponseBody
	@RequestMapping(value = "/addFromExcel")
	public Map<String, Object> addFromExcel(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession httpSession, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) httpSession.getAttribute("user");
		if (user != null && user.getPosition().equals("10")) {
			String path = request.getSession().getServletContext().getRealPath("/upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println(path+File.separator+fileName);  
			userManager.readXls(path+File.separator+fileName);
			/*String temp = request.getSession().getServletContext().getRealPath(File.separator)+ "temp"; // 临时目录
			System.out.println("path  === " + temp);
			File tempFile = new File(temp);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			if (uploadExcel == null){
				map.put("status", ERROR);
			}else{
				String name = uploadExcel.getOriginalFilename();// 获取上传文件名,包括路径
				//name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名
			    long size = uploadExcel.getSize();
			    if ((name == null || name.equals("")) && size == 0){
			    	map.put("status", ERROR);
			    }else{
			    	InputStream in = uploadExcel.getInputStream();
//			        List<BrandMobileInfoEntity> BrandMobileInfos = brandService
//			            .importBrandPeriodSort(in);
			    }
			}*/
			map.put("status", OK);
		} else {
			map.put("status", ERROR);
		}
		return map;
	}
}
