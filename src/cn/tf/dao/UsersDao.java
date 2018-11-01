package cn.tf.dao;
import cn.tf.domain.*;
import java.util.List;

public interface UsersDao {
	void save(Users Users);

	//Users findByCode(String code);

	Users find(String username, String password);
	
	Users find(String mail);
	
	void changepw(String newPw, String userid);

}
