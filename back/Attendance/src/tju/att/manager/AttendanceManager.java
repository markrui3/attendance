package tju.att.manager;

import java.util.List;
import java.util.Map;

import tju.att.domain.Attendance;

public interface AttendanceManager {
	/**
	 *  ����id��ȡ һ�� �����Ϣ
	 * @param id
	 * @return
	 */
	public Attendance getById(Long id);
	
	/**
	 * ��ȡһ����ټ�¼�������Ϣ
	 * @param id
	 * @return
	 */
	public Map<String, Object> getOneById(Long id);
	
	/**
	 *  ���� ���� �� ����������״̬ �õ�����б�
	 * @param department
	 * @param status
	 * @return
	 */
	public List<Attendance> getByDepartAndStatus(String department,String status);
		
	/**
	 * ���� �û���  id �� ����������״̬ ��ȡ����б�
	 * @param userid
	 * @param status
	 * @return
	 */
	public List<Attendance> getByUseridAndStatus(Long userid,String status);
		
	/**
	 * ����  ����������״̬ ��ȡ����б�
	 * @param status
	 * @return
	 */
	public List<Attendance> getByStatus(String status);
	/**
	 * �����ټ�¼
	 * @param attendance
	 * @return
	 */
	public boolean add(Attendance attendance);
	
	/**
	 * ������ټ�¼
	 * @param attendance
	 * @return
	 */
	public boolean update(Attendance attendance);
	
	/**
	 * ��ȡ������  ���� ���ڴ����е����
	 * @param userid
	 * @param status
	 * @return
	 */
	public List<Attendance> getPassOrNot(Long userid, String status);
}
