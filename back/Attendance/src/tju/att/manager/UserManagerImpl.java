package tju.att.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import tju.att.base.BaseInfo;
import tju.att.dao.UserDao;
import tju.att.domain.User;

@Service
public class UserManagerImpl extends BaseInfo implements UserManager{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByPhoneAndPwd(String phone,String pwd) {
		return userDao.findByNameAndPwd(phone, pwd);
	}

	@Override
	public User findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}

	@Override
	public boolean saveUser(User user) {
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public List<User> getPage(String pageNow, String pageSize) {
		return userDao.getPage(Integer.parseInt(pageNow), Integer.parseInt(pageSize));
	}

	@Override
	public User findById(Long userid) {
		return this.userDao.getById(userid);
	}

	@Override
	public boolean delete(Long id) {
		try {
			userDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
