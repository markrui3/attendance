package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Holiday;

public interface HolidayDao extends BaseDao<Holiday>{
	
	/**
	 * �����û�id��ȡ���û����м��ڵ�ʹ������
	 * @param userid
	 * @return
	 */
	public List<Object[]> getSumDay(Long userid);
}
