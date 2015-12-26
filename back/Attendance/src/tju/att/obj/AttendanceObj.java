package tju.att.obj;

import tju.att.domain.Attendance;

public class AttendanceObj {
	private Attendance attendance;
	private String tempUsername;
	private String holidayName;
	public Attendance getAttendance() {
		return attendance;
	}
	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
	public String getTempUsername() {
		return tempUsername;
	}
	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
}
