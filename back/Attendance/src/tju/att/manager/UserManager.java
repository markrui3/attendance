package tju.att.manager;

import java.util.List;

import tju.att.domain.User;

public interface UserManager{
	//��ҳ��ȡ
	public List<User> getPage(String pageNow,String pageSize);
	//��ȡ�����û�
	public List<User> getAll();
	//���ݵ绰�ź��������
	public User findByPhoneAndPwd(String phone,String pwd);
	//���ݵ绰������ң�������֤�Ƿ��Ѿ�ע���
	public User findByPhone(String phone);
	//����id����
	public User findById(Long userid);
	//���һ��user
	public boolean saveUser(User user);
	//����һ���û�
	public boolean updateUser(User user);
}
