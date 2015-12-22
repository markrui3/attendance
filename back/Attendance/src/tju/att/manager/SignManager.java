package tju.att.manager;

import java.util.List;

import tju.att.domain.Sign;

public interface SignManager {
	
	/**
	 * ����ǩ�����
	 * @param sign
	 * @return
	 */
	public boolean add(Sign sign,Long userid);
	
	/**
	 * ��ȡһ��ǩ��
	 * @return
	 */
	public Sign get(Long signid);
	
	/**
	 * ��ȡ�����·ݵ�ǩ�����
	 * @param dateStr
	 * @param userid
	 * @return
	 */
	public List<Sign> getMonth(String dateStr,Long userid);
	
	/**
	 * ��ȡ����Ĵ򿨼�¼
	 * @return
	 * @param userid
	 */
	public Sign getToday(Long userid);
}
