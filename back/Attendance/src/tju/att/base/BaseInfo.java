package tju.att.base;

public class BaseInfo {
	//成功状态码
	protected String OK = "OK";
	//失败状态码
	protected String ERROR = "ERROR";
	
	
	//用户等级
	//|0-员工
	protected String LEVEL_0 = "0";
	//|1-部门经理
	protected String LEVEL_1 = "1";
	//|2-副总经理
	protected String LEVEL_2 = "2";
	//|3-总经理
	protected String LEVEL_3 = "3";
	
	
	
	//同意请假
	protected int CHECKAGREE = 0;
	//不同意请假
	protected int CHECKDISAGREE = 1;
	
	
	//请假状态
	//0-	请假待审批
	protected String WAITCHECK = "0";
	//11-	第一级驳回请求
	protected String REFUSECHECK_1 = "11";
	//12-	第二级驳回请求
	protected String REFUSECHECK_2 = "12";
	//13-	第三级驳回请求
	protected String REFUSECHECK_3 = "13";
	//21-	第一级审批通过
	protected String PASS_1 = "21";
	//22-	第二级审批通过
	protected String PASS_2 = "22";
	//3- 审批通过
	protected String PASS = "3";
	
	
	//审批属性
	//1-	第一级审核
	protected String CHECK_1 = "1";
	//2-	第二级审核
	protected String CHECK_2 = "2";
	//3-	第三级审核
	protected String CHECK_3 = "3";
	
	//请假时间长度分界线
	//大于三天的需要三级审批
	//小于等于三天的需要一级审批
	protected float SEPDAYS = 3;


}
