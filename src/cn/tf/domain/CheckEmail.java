package cn.tf.domain;

public class CheckEmail {
	private String Id;
	private String Actived;
	private String ActiveCode;
	public CheckEmail() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getActived() {
		return Actived;
	}
	public void setActived(String actived) {
		Actived = actived;
	}
	public String getActiveCode() {
		return ActiveCode;
	}
	public void setActiveCode(String activeCode) {
		ActiveCode = activeCode;
	}
}
