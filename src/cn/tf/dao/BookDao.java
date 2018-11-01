package cn.tf.dao;

import java.util.List;

import cn.tf.dao.impl.*;
import cn.tf.domain.*;

public interface  BookDao {

	void add(String title,String author,String publisherId,String publishDate,String ISBN,
			String wordsCount,String unitPrice,String contentDescription,
			String aurhorDescription,String editorComment,String TOC,String categoryId,String clicks);
	
	void update(String id,String category,String value);
	
	void delete(String id);
	
	List<Books> find();
	
	Books find(String ISBN);
	
	Books findA(String id);
	
	int getTotalRecordsNum();
	
//	List<Books> findPageBooks(int startIndex,int size);

	int getTotalRecordsNum(String categoryId);

//	List<Books> findPageBooks(int startIndex, int pageSize, String categoryId);

//	Books findOne(String bookId);

	List<Books> fillAllBook(String categoryId);
	
	List<Books> findAllBook();
	
	List<Books> fillAllBook(String bywhat,String inputWord);
	
	List<BookComment> findComment(String bookid);
	
	void addcomment(String bookid,String comment);


}
