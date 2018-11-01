package cn.tf.dao;

import java.util.List;

import cn.tf.domain.*;


public interface OrderDao {

	void save(Order order);

	Order findByNum(String ordernum);

	void update(Order order);
	
	List<Order> findByCustomerId(String customerId);
	
	List<Orders> findByUserId(String userId);
	
	void addorder(String userid,String postad,String sum,int size,String[] orderbook,String[] ocount,String[] oprice);
	
	void addorderbooks(String orderId,String bookid,String quantity,String price);
	
	List<OrderItem> findOrderItem(String ordernum);

}
