package tju.att.manager;

import java.util.List;

import tju.att.domain.User;

public interface UserManager{
	//分页获取
	public List<User> getPage(String pageNow,String pageSize);
	//获取所有用户
	public List<User> getAll();
	//根据电话号和密码查找
	public User findByPhoneAndPwd(String phone,String pwd);
	//根据电话号码查找，用于验证是否已经注册过
	public User findByPhone(String phone);
	//根据id查找
	public User findById(Long userid);
	//添加一个user
	public boolean saveUser(User user);
	//更新一个用户
	public boolean updateUser(User user);
}
