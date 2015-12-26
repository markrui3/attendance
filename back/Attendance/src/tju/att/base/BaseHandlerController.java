package tju.att.base;

import java.util.ArrayList;
import java.util.List;

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
		obj.setSign(sign);
		obj.setUsername(userManager.findById(sign.getUserid()).getName());
		return obj;
	}

}
