package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tf.dao.CategoryDao;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;

public class CategoryDaoImpl implements CategoryDao  {

	
	private QueryRunner  qr=new QueryRunner(C3P0Util.getDataSource());
	public void add(String name)
	{
		try
		{
			qr.update("insert into Categories (Name) values(?)", name);
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(String id,String name)
	{
		String sql="update Categories set Name='"+name+"' where Id="+id;
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
			qr.update("delete from CateGories where Id=?", id);
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Categories find(String id)
	{
		try
		{
			return qr.query("select * from Categories where Id=?", new BeanHandler<Categories>(Categories.class), id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void save(Categories category) {
		try {
			qr.update("insert into Categories(Id ,Name) values(?,?)",
					category.getId(),category.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Categories> findAll() {
		try {
			return	qr.query("select * from Categories", new BeanListHandler<Categories>(Categories.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		 
	}

	
		
		 
	
	@Override
	public Categories findByName(String categoryName) {
		
		try {
			return 	qr.query("select * from Categories  where name=? ", new BeanHandler<Categories>(Categories.class),categoryName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public  void deleteByName(String categoryName) {
		
		try {
			  qr.update("delete from categorys where name=? ", categoryName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Categories findOne(String categoryId) {
		
		try {
			return 	qr.query("select * from Categories  where Id=? ", new BeanHandler<Categories>(Categories.class),categoryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
