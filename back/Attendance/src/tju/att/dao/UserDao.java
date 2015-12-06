package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.User;

public interface UserDao extends BaseDao<User>{
	//�����û�������������û�
	public User findByNameAndPwd(String phone, String pwd);
	//�����û��������û�
	public User findByPhone(String phone);
	//��ȡһ�����ŵ�Ա��
	public List<User> findByDep(String department);
}
