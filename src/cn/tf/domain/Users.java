package cn.tf.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String Id;
	private String LoginId;
	private String LoginPwd;
	private String Name;
	private String Address ;
	private String Phone;
	private String Mail;
	private String UserStateId;	
	private List<Role> roles = new ArrayList<Role>();
	public Users (){

	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}
	public String getLoginPwd() {
		return LoginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getUserStateId() {
		return UserStateId;
	}
	public void setUserStateId(String userStateId) {
		UserStateId = userStateId;
	}
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
