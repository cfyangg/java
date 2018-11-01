package cn.tf.domain;

public class Cart {
	private String Id;
	private String UserId;
	private String BookId;
	private String Count;
	public Cart() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	
}
