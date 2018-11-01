package cn.tf.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tf.dao.*;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;


public class UsersDaoImpl implements UsersDao{
	private QueryRunner  qr=new QueryRunner(C3P0Util.getDataSource());
	
	public Users find(String LoginId, String LoginPwd) {
		try {
			return qr.query("select * from Users where LoginId=? and LoginPwd=?", new BeanHandler<Users>(Users.class),LoginId,LoginPwd);
		} catch (SQLException e) {			
			return null;
			//throw new RuntimeException(e);
		}
		
	}
	
	public Users find(String mail) {
		try {
			return qr.query("select * from Users where Mail=?", new BeanHandler<Users>(Users.class),mail);
		} catch (SQLException e) {			
			return null;
			//throw new RuntimeException(e);
		}
		
	}
	
	public void save(Users user) {
		try {
			qr.update("insert into Users (LoginId,LoginPwd,Name,Phone,Address,Mail,UserStateId) values (?,?,?,?,?,?,?)", 
					user.getLoginId(),user.getLoginPwd(),user.getName(),user.getPhone(),user.getAddress(),
					user.getMail(),user.getUserStateId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void changepw(String newPw,String userid) {
		try {
			qr.update("update Users set LoginPwd=? where Id=?",newPw,userid );
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
