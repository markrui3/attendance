package tju.att.manager;

import tju.att.domain.Check;

public interface CheckManager {
	/**
	 * 添加一个审核   并且更新请假的状态
	 * @param check
	 * @return
	 */
	public boolean addCheckAndUpdateAtt(Check check);
	/**
	 * 更新 审核    并且更新请假的状态
	 * @param check
	 * @return
	 */
	public boolean updateCheck(Check check);
	
}
