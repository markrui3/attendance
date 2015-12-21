package tju.att.dao;

import java.util.Date;
import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.Sign;

public class SignDaoImpl extends BaseDaoImpl<Sign> implements SignDao{

	@Override
	public List<Sign> getByDate(Date dateStart, Date dateEnd,Long userid) {
		String sql = "FROM Sign s WHERE s.time > ? AND s.time < ? AND s.userid = ?";
		return getSession().createQuery(sql)
				.setParameter(0, dateStart)
				.setParameter(1, dateEnd)
				.setParameter(2, userid)
				.list();
	}

}
