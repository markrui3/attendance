package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.Attendance;

public class AttendanceDaoImpl extends BaseDaoImpl<Attendance> implements AttendanceDao{

	@Override
	public List<Attendance> getByIdsAndStatus(Long ids[],
			String status) {
		String sql = "FROM Attendance a WHERE a.status =? "
				+ "AND a.userid IN(:ids) order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameterList("ids", ids)
				.setParameter(0, status)
				.list();
	}

	@Override
	public List<Attendance> getByUseridAndStatus(Long userid, String status) {
		String sql = "FROM Attendance a WHERE a.userid =? "
				+ "AND a.status =? order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameter(0, userid)
				.setParameter(1, status)
				.list();
	}

	@Override
	public List<Attendance> getByStatus(String status) {
		String sql = "FROM Attendance a WHERE status =? "
				+ "order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameter(0, status)
				.list();
	}

	@Override
	public List<Attendance> getPassOrNot(Long userid, String status) {
		String statusArray[] = new String[4];
		if(status.equals("0")){
			//11 12 13 3
			statusArray[0] = "11";
			statusArray[1] = "12";
			statusArray[2] = "13";
			statusArray[3] = "3";
		}else if(status.equals("1")){
			//0 21 22
			statusArray[0] = "0";
			statusArray[1] = "21";
			statusArray[2] = "22";
			statusArray[3] = "0";
			
		}
		String sql = "FROM Attendance a WHERE a.userid =? "
				+ "AND a.status IN(:statusArray) order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameter(0, userid)
				.setParameterList("statusArray", statusArray)
				.list();
	}

}
