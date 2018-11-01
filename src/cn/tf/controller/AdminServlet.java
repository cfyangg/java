package cn.tf.controller;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.tf.dao.impl.*;
import cn.tf.domain.*;
import cn.tf.dao.*;

public class AdminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookDao bd=new BookDaoImpl();
	private UserInfoDao ud=new UserInfoDaoImpl();
	private RoleDao rd=new RoleDaoImpl();
	private CategoryDao cd=new CategoryDaoImpl();
	private PublisherDao pd=new PublisherDaoImpl();
	
	public AdminServlet() {
    	super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
		String op=request.getParameter("op");
		System.out.println("1111");
		if("login".equals(op)) {
			login(request,response);
		}
		else if("logout".equals(op))
		{
			logout(request,response);
		}
		else if("updateUserInfo".equals(op)) {
			updateUserInfo(request,response);
		}
		else if("updateRole".equals(op)) {
			updateRole(request,response);
		}
		else if("updateCategory".equals(op)) {
			updateCategories(request,response);
		}
		else if("updatePublisher".equals(op)) {
			updatePublishers(request,response);
		}
		else if("updateBooks".equals(op)) {
			updateBooks(request,response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserInfo ui=ud.find(username,password);
		if(ui!=null) {
			response.getWriter().write("登陆成功");
			request.getSession().setAttribute("users", username);
			response.setHeader("Refresh", "2,URL="+request.getContextPath()+"/index0.jsp");
		}
		else {
			response.getWriter().write("登陆失败");
			response.setHeader("Refresh", "5;URL="+request.getContextPath()+"/login0.jsp");
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("username");
		response.getWriter().write("退出成功");
		response.setHeader("Refresh", "4;URL="+request.getContextPath()+"/login0.jsp");
	}
	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String op=request.getParameter("op0");
		if("add".equals(op))
		{
			String userName=request.getParameter("UserName");
			String userPass=request.getParameter("UserPass");
			String email=request.getParameter("Email");
			ud.add(userName, userPass, email);
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listUserInfo.jsp");
		}
		else if("update".equals(op))
		{
			String id=request.getParameter("id");
			String category=request.getParameter("category");
			String value=request.getParameter("value");
			ud.update(id,category,value);
			response.getWriter().write("修改成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listUserInfo.jsp");
		}
		else if("delete".equals(op))
		{
			String id=request.getParameter("id");
			ud.delete(id);
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listUserInfo.jsp");
		}
		else if("setAdd".equals(op))
		{
			String userInfo_ID=request.getParameter("UserInfo_ID");
			String role_ID=request.getParameter("Role_ID");
			ud.setAdd(userInfo_ID,role_ID);
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listUserInfoRole.jsp");
		}
		else if("setDelete".equals(op))
		{
			String double_ID=request.getParameter("Double_ID");
			System.out.println(double_ID);
			String[] double_id=double_ID.split("\\.");
			String userInfo_ID=double_id[0];
			String role_ID=double_id[1];
			ud.setDelete(userInfo_ID,role_ID);
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listUserInfoRole.jsp");
		}
	}
	private void updateRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String op=request.getParameter("op0");
		if("add".equals(op))
		{//RoleName;DelFlag;RoleType;SubTime;Remark;
			String roleName=request.getParameter("RoleName");
			String roleFlag=request.getParameter("DelFlag");
			String roleType=request.getParameter("RoleType");
			String subTime=request.getParameter("SubTime");
			String remark=request.getParameter("Remark");
			rd.add(roleName,roleFlag,roleType,subTime,remark);
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listRole.jsp");
		}
		else if("update".equals(op))
		{
			String id=request.getParameter("id");
			String category=request.getParameter("category");
			String value=request.getParameter("value");
			rd.update(id,category,value);
			response.getWriter().write("修改成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listRole.jsp");
		}
		else if("delete".equals(op))
		{
			String id=request.getParameter("id");
			rd.delete(id);
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listRole.jsp");
		}
	}
	private void updateCategories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String op=request.getParameter("op0");
		if("add".equals(op))
		{
			String name=request.getParameter("Name");
			cd.add(name);
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listCategory.jsp");
		}
		else if("update".equals(op))
		{
			String id=request.getParameter("id");
			String name=request.getParameter("Name");
			cd.update(id,name);
			response.getWriter().write("修改成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listCategory.jsp");
		}
		else if("delete".equals(op))
		{//delete Category =delete Books
			String id=request.getParameter("id");
			cd.delete(id); //delete Books(by CategoryID=id)
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listCategory.jsp");
		}
	}
	private void updatePublishers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String op=request.getParameter("op0");
		if("add".equals(op))
		{
			String name=request.getParameter("Name");
			pd.add(name);
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listPublisher.jsp");
		}
		else if("update".equals(op))
		{
			String id=request.getParameter("id");
			String name=request.getParameter("Name");
			pd.update(id,name);
			response.getWriter().write("修改成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listPublisher.jsp");
		}
		else if("delete".equals(op))
		{//delete Publishers =delete Books
			String id=request.getParameter("id");
			pd.delete(id); //delete Books(by PublisherID=id)
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listPublisher.jsp");
		}
	}
	private void updateBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String op=request.getParameter("op0");
		if("add".equals(op))
		{
			String title=request.getParameter("Title");
			String author=request.getParameter("Author");
			String publisherId=request.getParameter("PublisherId");
			String publishDate=request.getParameter("PublishDate");
			String ISBN=request.getParameter("ISBN");
			String wordsCount=request.getParameter("WordsCount");
			String unitPrice=request.getParameter("UnitPrice");
			String contentDescription=request.getParameter("ContentDescription");
			String aurhorDescription=request.getParameter("AurhorDescription");
			String editorComment=request.getParameter("EditorComment");
			String TOC=request.getParameter("TOC");
			String categoryId=request.getParameter("CategoryId");
			String clicks=request.getParameter("Clicks");
			bd.add(title,author,publisherId,publishDate,ISBN,wordsCount,
					unitPrice,contentDescription,aurhorDescription,editorComment,
					TOC,categoryId,clicks);
			String id=bd.find(ISBN).getId();
			response.getWriter().write("添加成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/upload.jsp?id="+id+"&op=0");
		}
		else if("update".equals(op))
		{
			String id=request.getParameter("id");
			String category=request.getParameter("category");
			String value=request.getParameter("value");
			bd.update(id,category,value);
			response.getWriter().write("修改成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listBook.jsp?page=1");
		}
		else if("delete".equals(op))
		{
			String id=request.getParameter("id");
			bd.delete(id);
			response.getWriter().write("删除成功");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/listBook.jsp?page=1");
		}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
