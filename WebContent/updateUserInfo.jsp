<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>
</head>
<%
	String id=request.getParameter("id");
	UserInfoDao ud = new UserInfoDaoImpl();
	UserInfo ui = ud.find(id);
%>
<body>
<table>
	<tr>
		<td>ID</td>
		<td>UserName</td>
		<td>UserPass</td>
		<td>RegTime</td>
		<td>Email</td>
	</tr>
	<tr>
		<td><%=ui.getID() %></td>
		<td><%=ui.getUserName() %></td>
		<td><%=ui.getUserPass() %></td>
		<td><%=ui.getRegTime() %></td>
		<td><%=ui.getEmail() %></td>
	</tr>
</table>
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateUserInfo&op0=update">
		<select name="category" >
			<option>UserName</option>
			<option>UserPass</option>
			<option>Email</option>
		</select>
		<br>
		新值：<input type="text" name="value" >
		<br>
		<input type="hidden" name="id" value=<%=id %>>
		<input type="submit" value="提交" >
</form>
</body>
</html>