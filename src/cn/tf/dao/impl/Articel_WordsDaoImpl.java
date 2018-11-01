package cn.tf.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.tf.dao.*;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;

public class Articel_WordsDaoImpl implements Articel_WordsDao{
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public List<Articel_Words> getWordPattern(){
		try {
			return	qr.query("select top (10) WordPattern from Articel_Words", new BeanListHandler<Articel_Words>(Articel_Words.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
