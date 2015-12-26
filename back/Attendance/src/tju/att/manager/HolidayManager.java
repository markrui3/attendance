package tju.att.manager;

import java.util.List;
import java.util.Map;

import tju.att.domain.Holiday;
import tju.att.domain.User;

public interface HolidayManager {
	/**
	 * ��ȡ���еļ�����Ϣ
	 * @return
	 */
	public List<Holiday> getAll();
	
	/**
	 * ��ȡһ���û������м��ں�ʣ������
	 * @param user
	 * @return
	 */
	public Map<String, Object> getOnePer(User user);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Holiday getById(Long id);
}
