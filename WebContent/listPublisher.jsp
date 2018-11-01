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
<title>作者列表</title>
</head>
<%
	PublisherDao pd = new PublisherDaoImpl();
	List<Publishers> publishers = pd.find();
%>
<body>
<div align="center">
<form method="post" name="updatePublisherForm">

	<table>
		<tr>
			<td></td>
			<td>Id</td>
			<td>Name</td>
		</tr>
		<%
		for(Publishers publisher : publishers)
		{
		%>
		<tr>
			<td><input type="radio" name="id" value=<%=publisher.getId() %>></td>
			<td><%=publisher.getId() %></td>
			<td><%=publisher.getName() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<input type="submit" value="add" onclick="updatePublisherForm.action='${pageContext.request.contextPath }/addPublisher.jsp';updatePublisherForm.submit()">	
	<input type="submit" value="update" onclick="updatePublisherForm.action='${pageContext.request.contextPath }/updatePublisher.jsp';updatePublisherForm.submit()">
	<input type="submit" value="delete" onclick="updatePublisherForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updatePublisher&op0=delete';updatePublisherForm.submit()">
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</div>
</body>
</html>