package cn.tf.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.tf.dao.BookDao;
import cn.tf.domain.*;
import cn.tf.utils.C3P0Util;

public class BookDaoImpl implements BookDao {

	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public void add(String title,String author,String publisherId,String publishDate,String ISBN,
			String wordsCount,String unitPrice,String contentDescription,
			String aurhorDescription,String editorComment,String TOC,String categoryId,String clicks)
	{
		Date date=new Date();
		try {
			qr.update("insert into Books (Title,Author,PublisherId,PublishDate,ISBN,WordsCount,UnitPrice,ContentDescription,AurhorDescription,EditorComment,TOC,CategoryId,Clicks) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", 
					title,author,publisherId,date,ISBN,wordsCount,unitPrice,contentDescription,aurhorDescription,editorComment,TOC,categoryId,clicks);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(String id,String category,String value)
	{
		String sql="update Books set "+category+" ='"+value+"' where Id="+id;
		try
		{
			qr.update(sql);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(String id)
	{
		try
		{
			qr.update("delete from Books where Id=?", id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Books> find()
	{
		try
		{
			return qr.query("select * from Books", new BeanListHandler<Books>(Books.class));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Books find(String ISBN)
	{
		try
		{
			return qr.query("select * from Books where ISBN=?", new BeanHandler<Books>(Books.class), ISBN);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Books findA(String id)
	{
		try
		{
			return qr.query("select * from Books where Id=?", new BeanHandler<Books>(Books.class), id);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public int getTotalRecordsNum() {
		
		try {
			Long num=(Long) qr.query("select count(id) from books ",new ScalarHandler(1));
			return num.intValue();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
/*	@Override
	public List<Books> findPageBooks(int startIndex, int size) {
	
		try {
			List<Books>  books=qr.query("select * from books limit ?,? ",new BeanListHandler<Books>(Books.class),startIndex,size);
			if(books!=null){
				for (Book book : books) {
					String sql = "select * from categorys where id=(select categoryId from books where id=?)";
					Categories category = qr.query(sql, new BeanHandler<Categories>(Categories.class), book.getId());
					book.setCategory(category);
				}
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	@Override
	public int getTotalRecordsNum(String categoryId) {
		try {
			Long num=(Long) qr.query("select count(id) from Books where categoryId=? ",new ScalarHandler(1),categoryId);
			return num.intValue();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
/*	@Override
	public List<Books> findPageBooks(int startIndex, int pageSize,
			String categoryId) {
		
		try {
			List<Book>  books=qr.query("select * from books  where categoryId=?  limit  ?,? ",new BeanListHandler<Book>(Book.class),categoryId,startIndex,pageSize);
			if(books!=null){
				for (Book book : books) {
					String sql = "select * from categorys where id=?";
					Categories category = qr.query(sql, new BeanHandler<Categories>(Categories.class),categoryId);
					book.setCategory(category);
				}
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	*/
	//鏍规嵁澶氱殑鏌ュ皯鐨�
/*	@Override
	public Books findOne(String bookId) {
		
		try {
			Books book = qr.query("select * from Books where Id=?", new BeanHandler<Books>(Books.class), bookId);
			if(book!=null){
					String sql = "select * from categorys where id=(select categoryId from books where id=?)";
					Categories category = qr.query(sql, new BeanHandler<Categories>(Categories.class), book.getId());
					book.setCategoryId(category);
			}
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	public List<Books> fillAllBook(String categoryId){
		try {
			return	qr.query("select * from Books where CategoryId=?", new BeanListHandler<Books>(Books.class),categoryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Books> findAllBook(){
		try {
			return	qr.query("select * from Books order by Clicks DESC", new BeanListHandler<Books>(Books.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Books> fillAllBook(String bywhat,String inputWord) {
		try {
			String sql="select * from Books where "+bywhat+" like '%"+inputWord+"%'";
			System.out.println(sql);
			return qr.query(sql, new BeanListHandler<Books>(Books.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<BookComment> findComment(String bookid){
		try {
			String sql="select * from BookComment where BookId like '%"+bookid+"%'";
			System.out.println(sql);
			return qr.query(sql, new BeanListHandler<BookComment>(BookComment.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addcomment(String bookid,String comment) {
		Date date = new Date();
		try {
			qr.update("insert into BookComment (Msg,CreateDateTime,BookId) values (?,?,?)",comment,date,bookid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
