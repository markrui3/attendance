package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Check;

public interface CheckDao extends BaseDao<Check>{
	/**
	 * 根据请假id获取所有的审核
	 * @param attId
	 * @return
	 */
	public List<Check> getByAttId(Long attId);
}
