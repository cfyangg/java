package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;

import cn.tf.dao.*;
import cn.tf.domain.SearchDetails;
import cn.tf.utils.C3P0Util;

public class SearchDaoImpl implements SearchDao {
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public static String getUUID() {
		return UUID.randomUUID().toString();//.replace("-", "");
	}
	public void addSearchDetails(String sd) {
		Date date = new Date();
		String id=SearchDaoImpl.getUUID();
		try {
			qr.update("insert into SearchDetails (Id,KeyWords,SearchDateTime) values (?,?,?)", id, sd, date);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<SearchDetails> getSearchDetails() {
		
		return null;
	}
}
