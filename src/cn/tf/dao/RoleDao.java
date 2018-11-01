package cn.tf.dao;

import java.util.List;
import cn.tf.domain.*;

public interface RoleDao {
	
	void add(String roleName,String delFlag,String roleType,String subTime,String remark);
	
	void update(String id,String td,String value);
	
	void delete(String id);
	
	List<Role> find();
	
	Role find(String id);
}
