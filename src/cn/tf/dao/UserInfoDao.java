package cn.tf.dao;
import cn.tf.domain.*;
import java.util.List;

public interface UserInfoDao {
	void add(String userName,String userPass,String email);
	
	void update(String id,String category,String value);
	
	void delete(String id);
	
	List<UserInfo> find();
	
	UserInfo find(String id);
	
	UserInfo find(String username,String password);
	
	void setAdd(String userInfo_ID,String role_ID);
	
	void setDelete(String userInfo_ID,String role_ID);
	
	List<UserInfoRole> findUIR();
}
