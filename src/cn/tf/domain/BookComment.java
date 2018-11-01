package cn.tf.domain;

public class BookComment {
	private String Id;
	private String Msg;
	private String CreateDateTime;
	private String BookId;
	public BookComment() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public String getCreateDateTime() {
		return CreateDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		CreateDateTime = createDateTime;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	
}
