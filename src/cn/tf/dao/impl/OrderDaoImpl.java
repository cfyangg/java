package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tf.dao.CartDao;
import cn.tf.dao.OrderDao;
import cn.tf.domain.*;


import cn.tf.utils.C3P0Util;

public class OrderDaoImpl implements OrderDao {

	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	//调用QueryRunner类的方法对表实现增删查
	//淇濆瓨璁㈠崟
	@Override
	public void save(Order order) {
		
		try {
			qr.update("insert into orders (ordernum,price,number,status,customerId) values (?,?,?,?,?)", 
					order.getOrdernum(),order.getPrice(),order.getNumber(),order.getStatus(),
					order.getCustomer()==null?null:order.getCustomer().getId());
			List<OrderItem> items = order.getItems();
			for(OrderItem item:items){
				qr.update("insert into orderitems (id,number,price,ordernum,bookid) values (?,?,?,?,?)", 
						item.getId(),item.getNumber(),item.getPrice(),order.getOrdernum(),item.getBook()==null?null:item.getBook().getId());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public Order findByNum(String ordernum) {
		try {
			Order order = qr.query("select * from orders where ordernum=?", new BeanHandler<Order>(Order.class), ordernum);
			if(order!=null){
				Customer customer = qr.query("select * from customers where id=(select customerId from orders where ordernum=?)", new BeanHandler<Customer>(Customer.class), ordernum);
				order.setCustomer(customer);
			}
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(Order order) {
		try {
			qr.update("update orders set price=?,number=?,status=? where ordernum=?", order.getPrice(),order.getNumber(),order.getStatus(),order.getOrdernum());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public List<Order> findByCustomerId(String customerId) {
		try {
			List<Order> orders=qr.query("select * from orders where customerId=?  order by ordernum desc ", new BeanListHandler<Order>(Order.class),customerId);
			if(orders!=null){
				Customer customer=qr.query("select * from customers where id=? ",new BeanHandler<Customer>(Customer.class),customerId);
				for (Order order : orders) {
					order.setCustomer(customer);
				}
			}
			return orders;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Orders> findByUserId(String userId) {
		try {
			List<Orders> orders=qr.query("select * from Orders where UserId=?", new BeanListHandler<Orders>(Orders.class),userId);	
			return orders;						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public List<OrderItem> findOrderItem(String ordernum) {
		
		try {
			List<OrderItem> items = qr.query("select * from orderitems where ordernum=?", new BeanListHandler<OrderItem>(OrderItem.class), ordernum);
			if(items!=null){
				for(OrderItem o:items){
					Book book = qr.query("select * from books where id=(select bookId from orderitems where id=?)", new BeanHandler<Book>(Book.class), o.getId());
					o.setBook(book);
				}
			}
			return items;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addorder(String id,String postad,String sum,int size,String[] orderbook,String[] ocount,String[] oprice) {
		Date date = new Date();
		OrderDao od=new OrderDaoImpl();
		CartDao cd=new CartDaoImpl();
		String dates=date.toString();
		String orderid=dates+id;
		
		try {
			qr.update("insert into Orders (OrderId,OrderDate,UserId,TotalPrice,PostAddress,state) values (?,?,?,?,?,?)",orderid,date,id,sum,postad,0);
			for(int i=0;i<size;i++) {
				if(orderbook[i].equals("null"))
					continue;
				else {
					od.addorderbooks(orderid,orderbook[i], ocount[i], oprice[i]);
					cd.deleteCart(orderbook[i],id);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addorderbooks(String orderId,String bookid,String quantity,String price) {
	
		
		try {
			qr.update("insert into OrderBook (OrderId,BookID,Quantity,UnitPrice) values (?,?,?,?)",orderId,bookid,quantity,price);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
