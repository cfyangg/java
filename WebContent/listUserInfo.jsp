<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/bootstrapv3.css">
<script src="./js/jquery-1.9.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/bootstrap-paginator.min.js"></script>
<title>用户列表</title>
</head>
<%
	UserInfoDao ud=new UserInfoDaoImpl();
	List<UserInfo> users=ud.find();
%>
<body>
<div align="center">
<form method="post" name="updateUserInfoForm">
	<table>
		<tr>
			<td></td>
			<td>ID</td>
			<td>UserName</td>
			<td>UserPass</td>
			<td>RegTime</td>
			<td>Email</td>
		</tr>
		<%
		for(UserInfo ui : users)
		{
		%>
		<tr>
			<td><input type="radio" name="id" value=<%=ui.getID() %>></td>
			<td><%=ui.getID() %></td>
			<td><%=ui.getUserName() %></td>
			<td><%=ui.getUserPass() %></td>
			<td><%=ui.getRegTime() %></td>
			<td><%=ui.getEmail() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<input type="submit" value="add" onclick="updateUserInfoForm.action='${pageContext.request.contextPath }/addUserInfo.jsp';updateUserInfoForm.submit()">	
	<input type="submit" value="update" onclick="updateUserInfoForm.action='${pageContext.request.contextPath }/updateUserInfo.jsp';updateUserInfoForm.submit()">
	<input type="submit" value="delete" onclick="updateUserInfoForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updateUserInfo&op0=delete';updateUserInfoForm.submit()">
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</div>
</body>
</html>