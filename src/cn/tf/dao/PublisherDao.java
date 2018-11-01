package cn.tf.dao;

import java.util.List;
import cn.tf.domain.*;

public interface PublisherDao {
	void add(String name);
	
	void update(String id,String name);
	
	void delete(String id);
	
	List<Publishers> find();
	
	Publishers find(String id);
}
