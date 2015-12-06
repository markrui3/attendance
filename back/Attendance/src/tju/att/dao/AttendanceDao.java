package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Attendance;

public interface AttendanceDao extends BaseDao<Attendance>{
	
	//���� id���� �� ����������״̬ �õ�����б�
	public List<Attendance> getByIdsAndStatus(Long ids[],String status);
	
	//���� �û���  id �� ����������״̬ ��ȡ����б�
	public List<Attendance> getByUseridAndStatus(Long userid,String status);
	
	//����  ����������״̬ ��ȡ����б�
	public List<Attendance> getByStatus(String status);
	
	//��ȡ �������  ����������˵������Ϣ
	public List<Attendance> getPassOrNot(Long userid, String status);
	
	
}
