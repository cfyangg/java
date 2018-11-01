<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserInfoRole</title>
</head>
<%
	UserInfoDao ud = new UserInfoDaoImpl();
	List<UserInfoRole> userInfoRole = ud.findUIR();
%>
<body>
<div align="center">
<form method="post" name="updateUIRForm">
	<table>
		<tr>
			<td></td>
			<td>UserInfo_ID</td>
			<td>Role_ID</td>
		</tr>
		<%
		for(UserInfoRole uir : userInfoRole)
		{
		%>
		<tr>
			<td><input type="radio" name="Double_ID" value=<%=uir.getUserInfo_ID()+"."+uir.getRole_ID() %>></td>
			<td><%=uir.getUserInfo_ID() %></td>
			<td><%=uir.getRole_ID() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<input type="submit" value="add" onclick="updateUIRForm.action='${pageContext.request.contextPath }/addUserInfoRole.jsp';updateUIRForm.submit()">	
	<input type="submit" value="delete" onclick="updateUIRForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updateUserInfo&op0=setDelete';updateUIRForm.submit()">
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</body>
</html>