package tju.att.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tju.att.base.BaseController;
import tju.att.domain.Attendance;
import tju.att.domain.User;

@Controller
@RequestMapping("/att")
public class AttendanceController extends BaseController {

	/**
	 * ����һ�����
	 * ���ܲ���   holidayid   lastday   startday  endday  reason
	 * @param attendance
	 * @param httpSession
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAtt", method = { RequestMethod.POST })
	public Map<String, Object> addAtt(@RequestBody Attendance attendance,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		attendance.setUserid(user.getId());   //���������
		if(user.getPosition().equals(LEVEL_0)){
			attendance.setStatus(WAITCHECK);      //������ٳ�ʼ״̬
		}else if(user.getPosition().equals(LEVEL_1)){
			attendance.setStatus(PASS_1);
		}else if(user.getPosition().endsWith(LEVEL_2)){
			attendance.setStatus(PASS_2);
		}else if(user.getPosition().endsWith(LEVEL_3)){
			attendance.setStatus(PASS);
		}
		if(attendanceManager.add(attendance)){
			map.put("status", OK);
		}else{
			map.put("status", ERROR);
		}
		return map;
	}
	
	/**
	 * ����  ����  ��  ״̬��ȡ����б�
	 * @param httpSession
	 * @param department
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getByDepAndSat/{department}/{status}")
	public Map<String, Object> getByDepAndSat(HttpSession httpSession,
			@PathVariable String department,
			@PathVariable String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		//User user = (User)httpSession.getAttribute("user");
		List<Attendance> list = attendanceManager.
				getByDepartAndStatus(department, status);
		map.put("attList", list);
		return map;
	}
	
	/**
	 * ��ȡһ����ټ�¼ �� �����Ϣ
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getAtt/{id}")
	public Map<String, Object> getAtt(@PathVariable Long id) {
		Map<String, Object> map = attendanceManager.getOneById(id);
		return map;
	}
	
	
	/**
	 * ����  �û�id  ��  ״̬��ȡ  ������ �� ���ڴ����е�����б�
	 * @param httpSession
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getMeSat/{status}")
	public Map<String, Object> getMeSat(@PathVariable String status,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		List<Attendance> list = attendanceManager.
				getPassOrNot(user.getId(), status);
		map.put("attList", list);
		return map;
	}
	
	/**
	 * ����  user��Ϣ��ȡ  ��������   ����б�
	 * @param httpSession
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getWaitCheck/{status}")
	public Map<String, Object> getWaitCheck(@PathVariable String status,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		List<Attendance> list = new ArrayList<Attendance>();
		if(status.equals("0")){
			if(user.getPosition().equals(LEVEL_1)){
				list = attendanceManager.getByDepartAndStatus(user.getDepartment(),WAITCHECK);
			}else if(user.getPosition().equals(LEVEL_2)){
				list = attendanceManager.getByDepartAndStatus(user.getDepartment(),PASS_1);
			}else if(user.getPosition().equals(LEVEL_3)){
				list = attendanceManager.getByStatus(PASS_2);
			}
		}else if(status.equals("1")){
			list = attendanceManager.getCheckedAtt(user.getId());
		}else if(status.equals("2")){
			if(user.getPosition().equals(LEVEL_1)){
				list = attendanceManager.getByDepartAndStatus(user.getDepartment(),WAITCHECK);
			}else if(user.getPosition().equals(LEVEL_2)){
				list = attendanceManager.getByDepartAndStatus(user.getDepartment(),PASS_1);
			}else if(user.getPosition().equals(LEVEL_3)){
				list = attendanceManager.getByStatus(PASS_2);
			}
			List<Attendance> list2 = attendanceManager.getCheckedAtt(user.getId());
			list.addAll(list2);
		}
		map.put("attList", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("getBySat/{status}")
	public Map<String, Object> getByStatus(@PathVariable String status,
			HttpSession httpSession) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)httpSession.getAttribute("user");
		List<Attendance> list = new ArrayList<Attendance>();
		if(user != null){
			list = attendanceManager.getByStatusList(status);
		}else{
			list = null;
		}
		map.put("attList", list);
		return map;
	}
}
