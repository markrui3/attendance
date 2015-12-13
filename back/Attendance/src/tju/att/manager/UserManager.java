package tju.att.manager;

import tju.att.domain.User;

public interface UserManager{
	//根据电话号和密码查找
	public User findByPhoneAndPwd(String phone,String pwd);
	//根据电话号码查找，用于验证是否已经注册过
	public User findByPhone(String phone);
	//添加一个user
	public boolean saveUser(User user);
	//更新一个用户
	public boolean updateUser(User user);
}
