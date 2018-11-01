package cn.tf.domain;

import java.util.Date;

public class SearchDetails {
	private String Id;
	private String KeyWords;
	private Date SearchDateTime;
	public  SearchDetails() {

	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getKeyWords() {
		return KeyWords;
	}
	public void setKeyWords(String keyWords) {
		KeyWords = keyWords;
	}
	public Date getSearchDateTime() {
		return SearchDateTime;
	}
	public void setSearchDateTime(Date searchDateTime) {
		SearchDateTime = searchDateTime;
	}
	

}
