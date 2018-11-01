<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加页面</title>
</head>
<%
	UserInfoDao ud=new UserInfoDaoImpl();
	List<UserInfo> uid=ud.find();
	//UserInfoID
	RoleDao rd=new RoleDaoImpl();
	List<Role> role=rd.find();
	//RoleId
%>
<body>
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateUserInfo&op0=setAdd">
UserInfo_ID:
<select name="UserInfo_ID" >
<%
	for(UserInfo pub : uid) {
%>
	<option value=<%=pub.getID() %>><%=pub.getUserName() %></option>
<%
	}
%>
</select>
Role_ID:
<select name="Role_ID" >
<%
	for(Role pub : role) {
%>
	<option value=<%=pub.getID() %>><%=pub.getRoleName() %></option>
<%
	}
%>
</select>
<br>
<input type="submit" value="确定">
</form>
</body>
</html>