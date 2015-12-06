package tju.att.manager;

import java.util.List;
import java.util.Map;

import tju.att.domain.Attendance;

public interface AttendanceManager {
	/**
	 *  根据id获取 一条 请假信息
	 * @param id
	 * @return
	 */
	public Attendance getById(Long id);
	
	/**
	 * 获取一个请假记录及审核信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> getOneById(Long id);
	
	/**
	 *  根据 部门 和 申请所处的状态 得到请假列表
	 * @param department
	 * @param status
	 * @return
	 */
	public List<Attendance> getByDepartAndStatus(String department,String status);
		
	/**
	 * 根据 用户的  id 和 申请所处的状态 获取请假列表
	 * @param userid
	 * @param status
	 * @return
	 */
	public List<Attendance> getByUseridAndStatus(Long userid,String status);
		
	/**
	 * 根据  申请所处的状态 获取请假列表
	 * @param status
	 * @return
	 */
	public List<Attendance> getByStatus(String status);
	/**
	 * 添加请假记录
	 * @param attendance
	 * @return
	 */
	public boolean add(Attendance attendance);
	
	/**
	 * 更新请假记录
	 * @param attendance
	 * @return
	 */
	public boolean update(Attendance attendance);
	
	/**
	 * 获取处理完  或者 正在处理中的请假
	 * @param userid
	 * @param status
	 * @return
	 */
	public List<Attendance> getPassOrNot(Long userid, String status);
}
