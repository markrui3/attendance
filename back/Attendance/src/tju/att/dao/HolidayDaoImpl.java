package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.Holiday;

public class HolidayDaoImpl extends BaseDaoImpl<Holiday> implements HolidayDao{

	@Override
	public List<Object[]> getSumDay(Long userid) {
		String sql = "select a.holidayid as id, sum(a.lastday) as days from Attendance a "
				+ "WHERE a.userid = ? AND a.status <> ? AND a.status <> ? AND a.status <> ?"
				+ "  GROUP BY a.holidayid";
		return getSession().createSQLQuery(sql)
				.setParameter(0, userid)
				.setParameter(1, REFUSECHECK_1)
				.setParameter(2, REFUSECHECK_2)
				.setParameter(3, REFUSECHECK_3)
				.list();
	}

}
