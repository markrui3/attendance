package tju.att.manager;

import org.springframework.stereotype.Service;

import tju.att.base.BaseInfo;
import tju.att.dao.AttendanceDao;
import tju.att.dao.CheckDao;
import tju.att.domain.Attendance;
import tju.att.domain.Check;

@Service
public class CheckManagerImpl extends BaseInfo implements CheckManager{
	private CheckDao checkDao;
	private AttendanceDao attendanceDao;

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

	@Override
	public boolean addCheckAndUpdateAtt(Check check) {
		try {
			checkDao.save(check);
			Attendance attendance = attendanceDao.getById(check.getAttendanceid());
			if(check.getCheckresult() == CHECKAGREE){
				if(check.getProperty() == CHECK_1){
					if(attendance.getLastday() > SEPDAYS){
						attendance.setStatus(PASS_1);
					}else {
						attendance.setStatus(PASS);
					}
				}else if(check.getProperty() == CHECK_2){
					attendance.setStatus(PASS_2);
				}else if(check.getProperty() == CHECK_3){
					attendance.setStatus(PASS);
				}
			}else if(check.getCheckresult() == CHECKDISAGREE){
				if(check.getProperty() == CHECK_1){
					attendance.setStatus(REFUSECHECK_1);
				}else if(check.getProperty() == CHECK_2){
					attendance.setStatus(REFUSECHECK_2);
				}else if(check.getProperty() == CHECK_3){
					attendance.setStatus(REFUSECHECK_3);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCheck(Check check) {
		try {
			checkDao.update(check);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
