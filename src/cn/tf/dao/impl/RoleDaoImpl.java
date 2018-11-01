package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.tf.dao.RoleDao;
import cn.tf.domain.Books;
import cn.tf.domain.Role;
import cn.tf.utils.C3P0Util;

public class RoleDaoImpl implements RoleDao {
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public void add(String roleName,String delFlag,String roleType,String subTime,String remark)
	{
		Date date=new Date();
		try
		{
			qr.update("insert into Role (RoleName,DelFlag,RoleType,SubTime,Remark) values (?,?,?,?,?)", roleName, delFlag, roleType, date, remark);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String id,String td,String value)
	{
		String sql="update Role set "+td+" = '"+value+"' where ID="+id;
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
			qr.update("delete from Role where ID=?", id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Role> find()
	{
		try
		{
			return qr.query("select * from Role", new BeanListHandler<Role>(Role.class));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Role find(String id)
	{
		try
		{
			return qr.query("select * from Role where ID=?", new BeanHandler<Role>(Role.class), id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
