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
	RoleDao rd = new RoleDaoImpl();
	Role role = rd.find(id);
%>
<body>
<table>
	<tr>
		<td>ID</td>
		<td>RoleName</td>
		<td>DelFlag</td>
		<td>RoleType</td>
		<td>SubTime</td>
		<td>Remark</td>
	</tr>
	<tr>
		<td><%=role.getID() %></td>
		<td><%=role.getRoleName() %></td>
		<td><%=role.getDelFlag() %></td>
		<td><%=role.getRoleType() %></td>
		<td><%=role.getSubTime() %></td>
		<td><%=role.getRemark() %></td>
	</tr>
</table>
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateRole&op0=update">
		<select name="category" >
			<option>ID</option>
			<option>RoleName</option>
			<option>DelFlag</option>
			<option>RoleType</option>
			<option>SubTime</option>
			<option>Remark</option>
		</select>
		<br>
		新值：<input type="text" name="value" >
		<br>
		<input type="hidden" name="id" value=<%=id %>>
		<input type="submit" value="提交" >
</form>
</body>
</html>