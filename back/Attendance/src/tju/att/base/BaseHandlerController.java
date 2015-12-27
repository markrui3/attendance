package tju.att.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import tju.att.domain.Attendance;
import tju.att.domain.Check;
import tju.att.domain.Sign;
import tju.att.obj.AttendanceObj;
import tju.att.obj.CheckObj;
import tju.att.obj.SignObj;

public class BaseHandlerController extends BaseController{
	
	protected List<AttendanceObj> changeAttList(List<Attendance> list){
		List<AttendanceObj> returnList = new ArrayList<AttendanceObj>();
		for(int i=0;i<list.size();i++){
			AttendanceObj obj = getAttendanceObj(list.get(i));
			returnList.add(obj);
		}
		return returnList;
	}
	protected AttendanceObj getAttendanceObj(Attendance att) {
		AttendanceObj obj = new AttendanceObj();
		obj.setAttendance(att);
		obj.setTempUsername(userManager.findById(att.getUserid()).getName());
		obj.setHolidayName(holidayManager.getById(att.getHolidayid()).getHolidayname());
		obj.setPhone(userManager.findById(att.getUserid()).getPhone());
		return obj;
	}
	
	
	protected List<CheckObj> changeCheckList(List<Check> list){
		List<CheckObj> returnList = new ArrayList<CheckObj>();
		for(int i=0;i<list.size();i++){
			CheckObj obj = getCheckObj(list.get(i));
			returnList.add(obj);
		}
		return returnList;
	}
	protected CheckObj getCheckObj(Check check) {
		CheckObj obj = new CheckObj();
		obj.setCheck(check);
		obj.setUsername(userManager.findById(check.getUserid()).getName());
		return obj;
	}
	
	protected List<SignObj> changeSignList(List<Sign> list) {
		List<SignObj> returnList = new ArrayList<SignObj>();
		for(int i=0;i<list.size();i++){
			SignObj obj = getSignObj(list.get(i));
			returnList.add(obj);
		}
		return returnList;
	}
	protected SignObj getSignObj(Sign sign) {
		SignObj obj = new SignObj();
		obj.setUsername(userManager.findById(sign.getUserid()).getName());
		Date date = sign.getTime();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sFormat.format(date);
		obj.setTime(dateString);
		obj.setId(sign.getId());
		obj.setTimecome(sign.getTimecome());
		obj.setTimeleave(sign.getTimeleave());
		obj.setUserid(sign.getUserid());
		return obj;
	}

	protected String saveUploadFile(File upload,HttpSession httpSession) {
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath = httpSession.getServletContext().getRealPath("/WEB-INF/upload_files");
		String subPath = sdf.format(new Date());
		File dir = new File(basePath + subPath);
		if (!dir.exists()) {
			dir.mkdirs(); 
		}
		String path = basePath + subPath + UUID.randomUUID().toString();
		upload.renameTo(new File(path)); 
		return path;
	}
}
