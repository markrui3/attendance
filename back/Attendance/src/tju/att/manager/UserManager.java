package tju.att.manager;

import tju.att.domain.User;

public interface UserManager{
	//���ݵ绰�ź��������
	public User findByPhoneAndPwd(String phone,String pwd);
	//���ݵ绰������ң�������֤�Ƿ��Ѿ�ע���
	public User findByPhone(String phone);
	//���һ��user
	public boolean saveUser(User user);
	//����һ���û�
	public boolean updateUser(User user);
}
