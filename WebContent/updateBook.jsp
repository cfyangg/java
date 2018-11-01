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
	BookDao bd = new BookDaoImpl();
	Books book = bd.findA(id);
%>
<body>
<table>
	<tr>
		<td>Id</td>
		<td>Title</td>
		<td>Author</td>
		<td>PublisherId</td>
		<td>PublishDate</td>
		<td>ISBN</td>
		<td>WordsCount</td>
		<td>UnitPrice</td>
		<td>ContentDescription</td>
		<td>AurhorDescription</td>
		<td>EditorComment</td>
		<td>TOC</td>
		<td>CategoryId</td>
		<td>Clicks</td>
	</tr>
	<tr>
		<td><%=book.getId() %></td>
		<td><%=book.getTitle() %></td>
		<td><%=book.getAuthor() %></td>
		<td><%=book.getPublisherId() %></td>
		<td><%=book.getPublishDate() %></td>
		<td><%=book.getISBN() %></td>
		<td><%=book.getWordsCount() %></td>
		<td><%=book.getUnitPrice() %></td>
		<td><%=book.getContentDescription() %></td>
		<td><%=book.getAurhorDescription() %></td>
		<td><%=book.getEditorComment() %></td>
		<td><%=book.getTOC() %></td>
		<td><%=book.getCategoryId() %></td>
		<td><%=book.getClicks() %></td>
	</tr>	
</table>
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateBooks&op0=update">
		<select name="category" >
			<option>Id</option>
			<option>Title</option>
			<option>Author</option>
			<option>PublisherId</option>
			<option>PublishDate</option>
			<option>ISBN</option>
			<option>WordsCount</option>
			<option>UnitPrice</option>
			<option>ContentDescription</option>
			<option>AurhorDescription</option>
			<option>EditorComment</option>
			<option>TOC</option>
			<option>CategoryId</option>
			<option>Clicks</option>
		</select>
		<br>
		新值：<input type="text" name="value" >
		<br>
		<input type="hidden" name="id" value=<%=id %>>
		<input type="submit" value="提交" >
</form>
</body>
</html>