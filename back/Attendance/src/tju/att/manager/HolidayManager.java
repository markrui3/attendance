package tju.att.manager;

import java.util.List;
import java.util.Map;

import tju.att.domain.Holiday;
import tju.att.domain.User;

public interface HolidayManager {
	/**
	 * 获取所有的假期信息
	 * @return
	 */
	public List<Holiday> getAll();
	
	/**
	 * 获取一个用户的所有假期和剩余天数
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
