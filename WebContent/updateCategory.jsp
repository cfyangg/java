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
	CategoryDao cd = new CategoryDaoImpl();
	Categories category = cd.find(id);
%>
<body>
<table>
	<tr>
		<td>Id</td>
		<td>Name</td>
	</tr>
	<tr>
		<td><%=category.getId() %></td>
		<td><%=category.getName() %></td>
	</tr>
</table>
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateCategory&op0=update">
		Name的新值：<input type="text" name="Name" >
		<br>
		<input type="hidden" name="id" value=<%=id %>>
		<input type="submit" value="提交" >
</form>
</body>
</html>