package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tf.dao.UserInfoDao;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;


public class UserInfoDaoImpl implements UserInfoDao{
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public void add(String userName,String userPass,String email)
	{
		Date date=new Date();
		try
		{
			qr.update("insert into UserInfo (UserName,UserPass,RegTime,Email) values (?,?,?,?)", userName, userPass, date, email);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(String id,String category,String value)
	{
		String sql="update UserInfo set "+category+"='"+value+"' where Id="+id;
		try
		{
			qr.update(sql);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(String id)
	{
		try
		{
			qr.update("delete from UserInfo where Id=?", id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<UserInfo> find()
	{
		try
		{
			return qr.query("select * from UserInfo", new BeanListHandler<UserInfo>(UserInfo.class));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public UserInfo find(String id)
	{
		try
		{
			return qr.query("select * from UserInfo where ID=?", new BeanHandler<UserInfo>(UserInfo.class), id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public UserInfo find(String username,String password)
	{
		try
		{
			UserInfo ui=qr.query("select * from UserInfo where UserName=? and UserPass=?", new BeanHandler<UserInfo>(UserInfo.class), username, password);
			if(ui==null)
			{
				return null;
			}
			return ui;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void setAdd(String userInfo_ID,String role_ID)
	{
		try
		{
			qr.update("insert into UserInfoRole (UserInfo_ID,Role_ID) values (?,?)", userInfo_ID, role_ID);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setDelete(String userInfo_ID,String role_ID)
	{
		try
		{
			qr.update("delete from UserInfoRole where UserInfo_ID=? and Role_ID=?", userInfo_ID, role_ID);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<UserInfoRole> findUIR()
	{
		try
		{
			return qr.query("select * from UserInfoRole", new BeanListHandler<UserInfoRole>(UserInfoRole.class));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
