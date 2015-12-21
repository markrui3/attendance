package tju.att.dao;

import java.util.Date;
import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Sign;

public interface SignDao extends BaseDao<Sign>{
	
	/**
	 * ��ȡһ��ʱ���ڵ�ǩ�����
	 * @param dateStart
	 * @param endDate
	 * @return
	 */
	public List<Sign> getByDate(Date dateStart,Date dateEnd,Long uerid);

}
