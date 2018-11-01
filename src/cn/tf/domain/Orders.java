package cn.tf.domain;

public class Orders {
	private String OrderId;
	private String OrderDate;
	private String UserId;
	private String TotalPrice;
	private String PostAddress;
	private String state;
	public Orders() {
		
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getPostAddress() {
		return PostAddress;
	}
	public void setPostAddress(String postAddress) {
		PostAddress = postAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
