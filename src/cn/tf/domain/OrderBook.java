package cn.tf.domain;

public class OrderBook {
	private String Id;
	private String OrderID;
	private String BookID;
	private String Quantity;
	private String UnitPrice;
	public OrderBook() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		UnitPrice = unitPrice;
	}
	
}
