package tju.att.manager;

import tju.att.domain.Check;

public interface CheckManager {
	/**
	 * ���һ�����   ���Ҹ�����ٵ�״̬
	 * @param check
	 * @return
	 */
	public boolean addCheckAndUpdateAtt(Check check);
	/**
	 * ���� ���    ���Ҹ�����ٵ�״̬
	 * @param check
	 * @return
	 */
	public boolean updateCheck(Check check);
	
}
