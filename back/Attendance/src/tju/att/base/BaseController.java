package tju.att.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import tju.att.manager.AttendanceManager;
import tju.att.manager.CheckManager;
import tju.att.manager.HolidayManager;
import tju.att.manager.UserManager;

public class BaseController extends BaseInfo{
	@Resource(name="holidayManager")
	protected HolidayManager holidayManager;
	@Resource(name="userManager")
	protected UserManager userManager;
	@Resource(name="attendanceManager")
	protected AttendanceManager attendanceManager;
	@Resource(name="checkManager")
	protected CheckManager checkManager;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Timestamp.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
