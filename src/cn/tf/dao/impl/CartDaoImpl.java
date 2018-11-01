package cn.tf.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.tf.dao.*;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;

public class CartDaoImpl implements CartDao{
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public List<Books> findCart(String Id){
		try {
			//int a=Integer.parseInt(Id);
			String sql="select * from Books where Id in (select BookId from Cart where UserId=" + Id +")";
			System.out.println(sql);
			return	qr.query(sql, new BeanListHandler<Books>(Books.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cart> findCount(String Id){
		try {
			//int a=Integer.parseInt(Id);
			String sql="select * from Cart where UserId=" + Id;
			System.out.println(sql);
			return	qr.query(sql, new BeanListHandler<Cart>(Cart.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addcart(String userid,String bookid,String count) {
		String sql="insert into Cart (UserId,BookId,Count) values (?,?,?)";
		System.out.println(sql);
			
			try {
				qr.update(sql,userid,bookid,count);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	public void getCart(HttpServletRequest request, HttpServletResponse response) {
		CartDao cd=new CartDaoImpl();
		Users users=(Users)request.getSession().getAttribute("users");
		List<Books> cartbooks=cd.findCart(users.getId());
		int numbook=cartbooks.size();
		Books[] cbook=new Books[cartbooks.size()];
		request.getSession().setAttribute("numbook", numbook);
		for(int i=0;i<cartbooks.size();i++) {
			cbook[i]=cartbooks.get(i);
			request.getSession().setAttribute("cbook"+i, cbook[i]);
		}
		
		List<Cart> cart=cd.findCount(users.getId());
		String[] count=new String[numbook];
		for(int i=0;i<numbook;i++) {
			count[i]=cart.get(i).getCount();
			
		}
		request.getSession().setAttribute("count", count);
		
		request.getSession().setAttribute("cartlist", cart);
	}
	public void deleteCart(String bookid,String userid) {
		
		
		
		String sql="delete from Cart where BookId=? and UserId=?";
		System.out.println(sql);
			
			try {
				qr.update(sql,bookid,userid);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}
}
			
		
	
	

