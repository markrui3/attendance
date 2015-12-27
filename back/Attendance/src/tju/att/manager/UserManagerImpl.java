package tju.att.manager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
		return this.userDao.getUserList();
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
	

	@Override
	public boolean readXls(String path) throws Exception{
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		User user = null;
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					user = new User();
					HSSFCell phone = hssfRow.getCell(0);
					HSSFCell name = hssfRow.getCell(1);
					HSSFCell department = hssfRow.getCell(2);
					HSSFCell pwd = hssfRow.getCell(3);
					HSSFCell gender = hssfRow.getCell(4);
					HSSFCell birthday = hssfRow.getCell(5);
					HSSFCell position = hssfRow.getCell(6);
					HSSFCell startworkdate = hssfRow.getCell(7);
					HSSFCell email = hssfRow.getCell(8);

					user.setPhone(getCellValue(phone));
					user.setName(getCellValue(name));
					user.setDepartment(getCellValue(department));
					user.setPwd(getCellValue(pwd));
					user.setGender(Integer.parseInt(getCellValue(gender)));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					user.setBirthday(sdf.parse(getCellValue(birthday)));
					user.setPosition(getCellValue(position));
					user.setStartworkdate(sdf.parse(getCellValue(startworkdate)));
					user.setEmail(getCellValue(email));
					
					User userhas = userDao.findByPhone(getCellValue(phone));
					if(userhas != null){
						user.setId(userhas.getId());
						userDao.update(user);
					}else{
						userDao.save(user);
					}
				}
			}
		}
		return true;
	}

	private String getCellValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			System.out.println("============="+String.valueOf(hssfCell.getNumericCellValue()));
			return String.valueOf((int)hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

}
