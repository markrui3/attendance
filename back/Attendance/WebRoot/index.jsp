<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
    <form id="questionTypesManage"  method="post" enctype="multipart/form-data" 
    action="http://localhost:8080/Attendance/user/addFromExcel">
   		选择文件：　<input id="file" name="file" type="file">
   		<input type="submit" value="提交"/>
	</form>  
  </body>
</html>
