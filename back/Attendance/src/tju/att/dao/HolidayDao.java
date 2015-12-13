package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Holiday;

public interface HolidayDao extends BaseDao<Holiday>{
	
	/**
	 * 根据用户id获取该用户所有假期的使用天数
	 * @param userid
	 * @return
	 */
	public List<Object[]> getSumDay(Long userid);
}
