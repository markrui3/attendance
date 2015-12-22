package tju.att.manager;

import java.util.List;

import tju.att.domain.Sign;

public interface SignManager {
	
	/**
	 * 加入签到情况
	 * @param sign
	 * @return
	 */
	public boolean add(Sign sign,Long userid);
	
	/**
	 * 获取一个签到
	 * @return
	 */
	public Sign get(Long signid);
	
	/**
	 * 获取输入月份的签到情况
	 * @param dateStr
	 * @param userid
	 * @return
	 */
	public List<Sign> getMonth(String dateStr,Long userid);
	
	/**
	 * 获取当天的打卡记录
	 * @return
	 * @param userid
	 */
	public Sign getToday(Long userid);
}
