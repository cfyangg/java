package cn.tf.service;

import java.util.List;

import cn.tf.commons.Page;
import cn.tf.domain.*;


public interface  BusinessService0 {
	

	Users login(String username,String password);
	void registUser(Users user);
	List<Categories>  findAllCategories();

}

