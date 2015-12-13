package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.Holiday;

public class HolidayDaoImpl extends BaseDaoImpl<Holiday> implements HolidayDao{

	@Override
	public List<Object[]> getSumDay(Long userid) {
		String sql = "select a.holidayid as id, sum(a.lastday) as days from Attendance a "
				+ "WHERE a.userid = ? GROUP BY a.holidayid";
		return getSession().createSQLQuery(sql)
				.setParameter(0, userid)
				.list();
	}

}
