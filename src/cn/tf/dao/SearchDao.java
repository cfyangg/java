package cn.tf.dao;

import java.util.List;

import cn.tf.domain.SearchDetails;

public interface SearchDao {
	void addSearchDetails(String sd);
	
	List<SearchDetails> getSearchDetails();
	
	
}
