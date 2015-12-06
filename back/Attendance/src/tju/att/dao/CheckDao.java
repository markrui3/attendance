package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Check;

public interface CheckDao extends BaseDao<Check>{
	/**
	 * �������id��ȡ���е����
	 * @param attId
	 * @return
	 */
	public List<Check> getByAttId(Long attId);
}
