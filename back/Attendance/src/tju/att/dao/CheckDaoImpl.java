package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.Check;

public class CheckDaoImpl extends BaseDaoImpl<Check> implements CheckDao{

	@Override
	public List<Check> getByAttId(Long attId) {
		String sql="FROM Check c WHERE c.attendanceid = ?";
		return getSession().createQuery(sql)
				.setParameter(0, attId)
				.list();
	}

}
