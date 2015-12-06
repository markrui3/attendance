package tju.att.manager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import tju.att.base.BaseInfo;
import tju.att.dao.AttendanceDao;
import tju.att.dao.CheckDao;
import tju.att.dao.UserDao;
import tju.att.domain.Attendance;
import tju.att.domain.Check;
import tju.att.domain.User;

@Service
public class AttendanceManagerImpl extends BaseInfo implements
		AttendanceManager {
	private AttendanceDao attendanceDao;
	private UserDao userDao;
	private CheckDao checkDao;
	
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	@Override
	public Attendance getById(Long id) {
		return attendanceDao.getById(id);
	}

	@Override
	public List<Attendance> getByDepartAndStatus(String department,
			String status) {
		List<User> userList = userDao.findByDep(department);
		Long ids[] = new Long[userList.size()];
		for(int i=0;i<userList.size();i++){
			ids[i] = userList.get(i).getId();
		}
		return attendanceDao.getByIdsAndStatus(ids, status);
	}

	@Override
	public List<Attendance> getByUseridAndStatus(Long userid, String status) {
		return attendanceDao.getByUseridAndStatus(userid, status);
	}

	@Override
	public List<Attendance> getByStatus(String status) {
		return attendanceDao.getByStatus(status);
	}

	@Override
	public boolean add(Attendance attendance) {
		try {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = sdf.format(new Date());
			attendance.setApplyday(str);
			attendanceDao.save(attendance);
			return true;
		} catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}
	}

	@Override
	public boolean update(Attendance attendance) {
		try {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = sdf.format(new Date());
			attendance.setApplyday(str);
			attendanceDao.update(attendance);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Attendance> getPassOrNot(Long userid, String status) {
		return attendanceDao.getPassOrNot(userid, status);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Map<String, Object> getOneById(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Attendance attendance = attendanceDao.getById(id);
		List<Check> checkList = checkDao.getByAttId(attendance.getId());
		List<User> userList = new ArrayList<User>();
		int checkNum = checkList.size();
		for(int i=0;i<checkNum;i++){
			User user = userDao.getById(checkList.get(i).getUserid());
			userList.add(user);
		}
		map.put("att", attendance);
		map.put("checkList", checkList);
		map.put("userList", userList);
		return map;
	}

}
