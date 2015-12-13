package tju.att.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import tju.att.base.BaseInfo;
import tju.att.dao.HolidayDao;
import tju.att.domain.Holiday;
import tju.att.domain.User;

@Service
public class HolidayManagerImpl extends BaseInfo implements HolidayManager {
	private HolidayDao holidayDao;

	public void setHolidayDao(HolidayDao holidayDao) {
		this.holidayDao = holidayDao;
	}

	@Override
	public List<Holiday> getAll() {
		return holidayDao.findAll();
	}

	@Override
	public Map<String, Object> getOnePer(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> lastList = holidayDao.getSumDay(user.getId());
		Date birthday = user.getBirthday();
		Date startWork = user.getStartworkdate();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		String birStr = sdf.format(birthday);
		String staStr = sdf.format(startWork);
		String nowStr = sdf.format(now);
		// 算年龄和 工龄
		int age = getDateLength(birStr ,nowStr)[0];
		int workAge = getDateLength(staStr ,nowStr)[0]+1;
		System.out.println("age ===== " + age);
		System.out.println("workAge ===== " + workAge);
		// 性别
		int gender = user.getGender();
		// 获取所有的假期信息
		List<Holiday> hList = holidayDao.findAll();
		// 要返回的假期信息
		List<Holiday> RList = new ArrayList<Holiday>();
		for (int i = 0; i < hList.size(); i++) {
			if (hList.get(i).getHolidayid().equals("4")) {
				if (gender == 1) {
					RList.add(hList.get(i)); // 女性加入产假
				}
			} else if (hList.get(i).getHolidayid().equals("5")) {
				if (gender == 0) {
					RList.add(hList.get(i)); // 男性加入陪产假
				}
			} else if (hList.get(i).getHolidayid().equals("2")) {
				if (age <= 25) {
					RList.add(hList.get(i)); // 短期婚假
				}
			} else if (hList.get(i).getHolidayid().equals("3")) {
				if (age >= 25) {
					RList.add(hList.get(i)); // 长期婚假
				}
			} else if (hList.get(i).getHolidayid().equals("6")) {
				if (workAge < 10) {
					RList.add(hList.get(i)); // 短年假
				}
			} else if (hList.get(i).getHolidayid().equals("7")) {
				if (workAge >= 10) {
					RList.add(hList.get(i)); // 长年假
				}
			} else {
				RList.add(hList.get(i));
			}
		}
		//计算假期剩余时间
		for(int index=0;index<lastList.size();index++){
			Object[] temp = lastList.get(index);
			System.out.println("temp[0]  ==  " + temp[0]);
			for (int i = 0; i < RList.size(); i++){
				if(Long.parseLong(temp[0].toString()) == RList.get(i).getId()){
					Double remainday = Double.parseDouble(RList.get(i).getLastday())
							-(Double)temp[1];
					RList.get(i).setRemainday(remainday);
					System.out.println("remainday  ==  " + remainday);
				}
			}
		}
		map.put("RList", RList);
		return map;
	}
	//计算两个时间相差多少年
	static int[] getDateLength(String fromDate, String toDate) {
		Calendar c1 = getCal(fromDate);
		Calendar c2 = getCal(toDate);
		int[] p1 = { c1.get(Calendar.YEAR), c1.get(Calendar.MONTH),
				c1.get(Calendar.DAY_OF_MONTH) };
		int[] p2 = { c2.get(Calendar.YEAR), c2.get(Calendar.MONTH),
				c2.get(Calendar.DAY_OF_MONTH) };
		return new int[] { p2[0] - p1[0] };
	}

	static Calendar getCal(String date) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Integer.parseInt(date.substring(0, 4)),
				Integer.parseInt(date.substring(5, 7)) - 1,
				Integer.parseInt(date.substring(8, 10)));
		return cal;
	}
}
