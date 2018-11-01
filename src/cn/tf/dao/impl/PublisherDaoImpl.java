package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tf.dao.PublisherDao;
import cn.tf.domain.Publishers;
import cn.tf.utils.C3P0Util;

public class PublisherDaoImpl implements PublisherDao{
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public void add(String name)
	{
		try
		{
			qr.update("insert into Publishers (Name) values (?)", name);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String id,String name)
	{
		try
		{
			qr.update("update Publishers set Name=? where Id=?", name, id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id)
	{
		try
		{
			qr.update("delete from Publishers where Id=?", id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		try
		{
			qr.update("delete from Books where PublisherId=?", id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Publishers> find()
	{
		try
		{
			return qr.query("select * from Publishers", new BeanListHandler<Publishers>(Publishers.class));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Publishers find(String id)
	{
		try
		{
			return qr.query("select * from Publishers where Id=?", new BeanHandler<Publishers>(Publishers.class), id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
