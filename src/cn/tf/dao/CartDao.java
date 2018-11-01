package cn.tf.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tf.domain.*;

public interface  CartDao {
	List<Books> findCart(String Id);
	List<Cart> findCount(String Id);
	void addcart(String userid,String bookid,String count);
	void getCart(HttpServletRequest request, HttpServletResponse response);
	void deleteCart(String bookid,String userid);

}
