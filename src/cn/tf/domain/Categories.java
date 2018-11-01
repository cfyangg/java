package cn.tf.domain;

public class Categories {
	private String Id;
	private String Name;
	public Categories() {
		
	}
	public String getId() {
		return Id.toString();
	}
	public void setId(String id) {
		Id = id.toString();
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
