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
		String statusArray[] = new String[7];
		if(status.equals("0")){
			//11 12 13 3
			statusArray[0] = "11";
			statusArray[1] = "12";
			statusArray[2] = "13";
			statusArray[3] = "3";
			statusArray[4] = "3";
			statusArray[5] = "3";
			statusArray[6] = "3";
		}else if(status.equals("1")){
			//0 21 22
			statusArray[0] = "0";
			statusArray[1] = "21";
			statusArray[2] = "22";
			statusArray[3] = "0";
			statusArray[4] = "0";
			statusArray[5] = "0";
			statusArray[6] = "0";
			
		}else if(status.equals("2")){
			statusArray[0] = "0";
			statusArray[1] = "21";
			statusArray[2] = "22";
			statusArray[3] = "11";
			statusArray[4] = "12";
			statusArray[5] = "13";
			statusArray[6] = "3";
		}
		String sql = "FROM Attendance a WHERE a.userid =? "
				+ "AND a.status IN(:statusArray) order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameter(0, userid)
				.setParameterList("statusArray", statusArray)
				.list();
	}

	@Override
	public List<Object[]> getCheckedAtt(Long userid) {
		String sql = "From Attendance a,Check c WHERE a.id = c.attendanceid AND c.userid = ?";
		return getSession().createQuery(sql)
				.setParameter(0, userid)
				.list();
	}

	@Override
	public List<Attendance> getByStatusList(String status) {
		String statusArray[] = new String[7];
		if(status.equals("0")){
			//11 12 13 3
			statusArray[0] = "11";
			statusArray[1] = "12";
			statusArray[2] = "13";
			statusArray[3] = "3";
			statusArray[4] = "3";
			statusArray[5] = "3";
			statusArray[6] = "3";
		}else if(status.equals("1")){
			//0 21 22
			statusArray[0] = "0";
			statusArray[1] = "21";
			statusArray[2] = "22";
			statusArray[3] = "0";
			statusArray[4] = "0";
			statusArray[5] = "0";
			statusArray[6] = "0";
			
		}else if(status.equals("2")){
			statusArray[0] = "0";
			statusArray[1] = "21";
			statusArray[2] = "22";
			statusArray[3] = "11";
			statusArray[4] = "12";
			statusArray[5] = "13";
			statusArray[6] = "3";
		}
		String sql = "FROM Attendance a WHERE a.status IN(:statusArray) order by a.applyday DESC";
		return getSession().createQuery(sql)
				.setParameterList("statusArray", statusArray)
				.list();
	}

}
