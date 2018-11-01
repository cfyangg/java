package cn.tf.dao;

import java.util.List;

import cn.tf.domain.*;

public interface CategoryDao {
	
	void add(String name);
	
	void update(String id,String name);
	
	void delete(String id);
	
	Categories find(String id);

	void save(Categories category);

	List<Categories> findAll();

	Categories findByName(String categoryName);

	void deleteByName(String categoryName);

	Categories findOne(String categoryId);
	
	
}
