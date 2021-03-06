package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.User;

public interface UserDao extends BaseDao<User>{
	//分页获取
	public List<User> getPage(int pageNow,int pageSize);
	//根据用户名和密码查找用户
	public User findByNameAndPwd(String phone, String pwd);
	//根据用户名查找用户
	public User findByPhone(String phone);
	//获取一个部门的员工
	public List<User> findByDep(String department);
	//获取 除超级管理员之外的用户
	public List<User> getUserList();
}
