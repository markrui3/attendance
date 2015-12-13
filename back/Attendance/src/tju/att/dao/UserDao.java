package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.User;

public interface UserDao extends BaseDao<User>{
	//根据用户名和密码查找用户
	public User findByNameAndPwd(String phone, String pwd);
	//根据用户名查找用户
	public User findByPhone(String phone);
	//获取一个部门的员工
	public List<User> findByDep(String department);
}
