package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDaoImpl;
import tju.att.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByNameAndPwd(String phone, String pwd) {
		if (phone == null || pwd == null) {
			System.out.println("userid or pwd == null");
			return null;
		} else {
			String sql = "FROM User u WHERE u.phone =? AND u.pwd =?";
			return (User) getSession().createQuery(sql)
					.setParameter(0, phone).setParameter(1, pwd)
					.uniqueResult();
		}
	}

	@Override
	public User findByPhone(String phone) {
		if (phone == null) {
			System.out.println("phone == null");
			return null;
		} else {
			String sql = "FROM User u WHERE u.phone =?";
			return (User) getSession().createQuery(sql)
					.setParameter(0, phone)
					.uniqueResult();
		}
	}

	@Override
	public List<User> findByDep(String department) {
		String sql = "FROM User u WHERE u.department =?";
		return getSession().createQuery(sql)
				.setParameter(0, department)
				.list();
	}

	@Override
	public List<User> getPage(int pageNow, int pageSize) {
		String sql="from User u limit "
				+((pageNow-1)*pageSize)+","+pageSize;
		return null;
	}

}
