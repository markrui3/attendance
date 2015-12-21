package tju.att.dao;

import java.util.List;

import tju.att.base.BaseDao;
import tju.att.domain.Attendance;

public interface AttendanceDao extends BaseDao<Attendance>{
	
	//根据 id集合 和 申请所处的状态 得到请假列表
	public List<Attendance> getByIdsAndStatus(Long ids[],String status);
	
	//根据 用户的  id 和 申请所处的状态 获取请假列表
	public List<Attendance> getByUseridAndStatus(Long userid,String status);
	
	//根据  申请所处的状态 获取请假列表
	public List<Attendance> getByStatus(String status);
	
	//根据  申请所处的状态 获取请假列表列表
	public List<Attendance> getByStatusList(String status);
	
	//获取 处理完成  或者正在审核的请假信息
	public List<Attendance> getPassOrNot(Long userid, String status);
	
	//获取处理过的请求
	public List<Object[]> getCheckedAtt(Long userid);
	
}
