package tju.att.manager;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tju.att.base.BaseInfo;
import tju.att.dao.SignDao;
import tju.att.domain.Sign;

@Service
public class SignManagerImpl extends BaseInfo implements SignManager{
	private SignDao signDao;
	
	public void setSignDao(SignDao signDao){
		this.signDao = signDao;
	}
	
	@Override
	public boolean add(Sign sign) {
		try {
			Date dateNow = new Date();
			if(dateNow.getTime() < getDateTime(12).getTime()){
				if(dateNow.getTime() > getDateTime(8).getTime()){
					sign.setTimecome(COMENOTTIME);
				}else{
					sign.setTimecome(COMEONTIME);
				}
				sign.setTimeleave(COMENO);
				sign.setTime((Timestamp)getDateTime(12));
				signDao.save(sign);
			}else if(dateNow.getTime() >= getDateTime(12).getTime()){
				List<Sign> list = signDao.getByDate(getDateTime(0), getDateTime(24));
				if(list.size() == 0){
					if(dateNow.getTime() < getDateTime(18).getTime()){
						sign.setTimeleave(COMENOTTIME);
					}else{
						sign.setTimeleave(COMEONTIME);
					}
					sign.setTimecome(COMENO);
					sign.setTime((Timestamp)getDateTime(12));
					signDao.save(sign);
				}else{
					Sign signToday = list.get(0);
					if(dateNow.getTime() < getDateTime(18).getTime()){
						signToday.setTimeleave(COMENOTTIME);
					}else{
						signToday.setTimeleave(COMEONTIME);
					}
					signDao.update(signToday);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Sign get(Long signid) {
		return signDao.getById(signid);
	}

	@Override
	public List<Sign> getMonth(String dateStr,Long userid) {
		return signDao.getByDate(getDateMonth(dateStr, 1), getDateMonth(dateStr, 0),userid);
	}
	
	private Date getDateTime(int hour){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,hour);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		Date date = calendar.getTime();
		return date;
	}
	
	private Date getDateMonth(String dateStr,int day){
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date daystart = df.parse(dateStr);    //dateStrÊÇÀàËÆ"2013-02-02"µÄ×Ö·û´®
			calendar.setTime(daystart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(day == 1){
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		}else if(day == 0){
			calendar.add(Calendar.MONTH, 1);  
			calendar.set(Calendar.DAY_OF_MONTH, 0);
		}
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		Date date = calendar.getTime();
		return date;
	}

	@Override
	public Sign getToday(Long userid) {
		List<Sign> list = signDao.getByDate(getDateTime(0), getDateTime(24),userid);
		if(list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
