package cn.tf.service.impl;

import java.util.List;
import java.util.UUID;

import cn.tf.commons.Page;
import cn.tf.dao.*;
import cn.tf.dao.impl.*;
import cn.tf.domain.*;
import cn.tf.service.BusinessService0;

public class BusinessServiceimpl0 implements BusinessService0{
	private UsersDao usersDao=new UsersDaoImpl();
	private CategoryDao categoryDao=new CategoryDaoImpl();
	private BookDao bookDao=new BookDaoImpl();
	
	
public Users login(String username, String password) {
		
		Users users = usersDao.find(username,password);
		if(users==null)
			return null;
		if(users.getUserStateId()=="0")
			return null;
		return users;
	}

@Override
public void registUser(Users user) {
	user.setId(UUID.randomUUID().toString());
	usersDao.save(user);
	
}



public List<Categories> findAllCategories() {
	
	return categoryDao.findAll();
}

}
