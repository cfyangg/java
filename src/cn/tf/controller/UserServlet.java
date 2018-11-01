package cn.tf.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.tf.commons.Page;
import cn.tf.dao.impl.*;
import cn.tf.domain.*;
import cn.tf.dao.*; 
import cn.tf.service.*;
import cn.tf.service.impl.*;
import cn.tf.utils.*;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao=new UsersDaoImpl();
	private BookDao bd=new BookDaoImpl();
	private CartDao cd=new CartDaoImpl();
	private CategoryDao cd1=new CategoryDaoImpl();
	private OrderDao od=new OrderDaoImpl();
	private SearchDao searchDao=new SearchDaoImpl();
	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private BusinessService0 s=new BusinessServiceimpl0();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op=request.getParameter("op");
	System.out.println("1111");
		if("login".equals(op))
		{
			login(request,response);
		}
		else if("userRegist".equals(op))
		{
			userRegist(request,response);
		}
		else if("confirm".equals(op)){
			confirm(request,response);
		}
		else if("listBookByCategory".equals(op)){
			
			listBookByCategory(request,response);
		}
		else if("hd".equals(op)){
			
			Hd(request,response);
		}
		else if("show".equals(op)){
			
			show(request,response);
		}
		else if("addcart".equals(op)){
			
			addcart(request,response);
		}
		else if("addorder".equals(op)){
			
			addorder(request,response);
		}
		else if("deleteCart".equals(op)){
			
			deleteCart(request,response);
		}
		else if("oldPw".equals(op)){
			
			changePw(request,response);
		}
		else if("listOrders".equals(op)){
			
			listOrders(request,response);
		}
		else if("findpw".equals(op)){
			
			findpw(request,response);
		}
		else if("addcomment".equals(op)){
			
			addcomment(request,response);
		}
		else if("visitor".equals(op)){
			
			visitor(request,response);
		}
		else if("logout".equals(op)){
			
			logout(request,response);
		}
		
		else if("buyBook".equals(op)){
		//	buyBook(request,response);
		}
		
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+"    "+password);
		Users users=s.login(username, password);
		//System.out.println(users.getId());
		if(users==null){
			request.setAttribute("message", "登陆失败！<a href='javascript:window.history.back()'>返回</a>");
			//response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/login.jsp");
			try {
				request.getRequestDispatcher("/message.jsp").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		else {
			request.getSession().setAttribute("users", users);
			List<Books> allbook=bd.findAllBook();
			Books[] book=new Books[10];
			for(int i=0;i<10;i++) {
				book[i]=allbook.get(i);
				request.getSession().setAttribute("book"+i, book[i]);
			}			
			cd.getCart(request, response);
			
			response.setHeader("Refresh", "1;URL="+request.getContextPath());
		}
		
		
		
	}
	
	private void userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
		Users user=new Users();
		HttpSession session=request.getSession();
		String loginid=request.getParameter("LoginId");
		String loginpwd=request.getParameter("LoginPwd");
		String phone=request.getParameter("Phone");
		String address=request.getParameter("Address");
		String mail=(String) session.getAttribute("Mail");
		
		String name=request.getParameter("Name");
		
		
		user.setUserStateId("1");
		
		user.setAddress(address);
		user.setLoginId(loginid);
		user.setLoginPwd(loginpwd);
		user.setMail(mail);
		user.setName(name);
		user.setPhone(phone);
		System.out.print(user.getLoginId());
		usersDao.save(user);
		request.getSession().setAttribute("users", user);
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/index.jsp");
	}
	
	private void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String code=request.getParameter("Code");
		String v=(String)request.getSession().getAttribute("v");
		if(v.equals(code)) {
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/regist.jsp");
		}
		else {
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/regist1.jsp");
		}
	}
	
	private void listBookByCategory(HttpServletRequest request,
			HttpServletResponse response) {		
		String category=request.getParameter("inputC");		
		String inputWord=request.getParameter("input");		
		
		if(inputWord.equals(""))
			return;
		else {
			searchDao.addSearchDetails(inputWord);
			
			List<Books> allbook=bd.fillAllBook(category,inputWord);
			Books[] book=new Books[allbook.size()];
			for(int i=0;i<allbook.size();i++) {
				book[i]=allbook.get(i);
				
			}
			request.getSession().setAttribute("totalnum",allbook.size());
			request.getSession().setAttribute("book", book);
			String vop=request.getParameter("vop");
			if("y".equals(vop))
				response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/vlistBooks.jsp?page=1");
			else
				response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/listBooks.jsp?page=1");
		}

		
		
	}
	
/*	private void buyBook(HttpServletRequest request,
			HttpServletResponse response) {
		//得到书籍
		String bookId=request.getParameter("bookId");
		Book book=s.findBookById(bookId);
		
		//购物车
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBook2Items(book);
		//提示
		request.setAttribute("message", "购买成功！<a href='javascript:window.history.back()'>返回</a>");
		try {
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	*/
	
	private void Hd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Books> allbook=bd.findAllBook();
		Books[] book=new Books[allbook.size()];
		for(int i=0;i<allbook.size();i++) {
			book[i]=allbook.get(i);
			
		}
		request.getSession().setAttribute("totalnum",allbook.size());
		request.getSession().setAttribute("book", book);
		String vop=request.getParameter("vop");
		if("y".equals(vop))
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/vlistBooks.jsp?page=1");
		else
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/listBooks.jsp?page=1");
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String bookid=request.getParameter("bookid");
		
		List<Books> book1=bd.fillAllBook("Id",bookid);
		Books showbook=book1.get(0);
		
		PublisherDao pd=new PublisherDaoImpl();
		Categories cat=cd1.find(showbook.getCategoryId());
		Publishers sp=pd.find(showbook.getPublisherId());
		request.getSession().setAttribute("cat", cat.getName());
		request.getSession().setAttribute("sp", sp.getName());
		request.getSession().setAttribute("showbook", showbook);
		List<BookComment> comment=bd.findComment(bookid);
		request.getSession().setAttribute("comment", comment);
		String vop=request.getParameter("vop");
		if("y".equals(vop))
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/vshow.jsp");
		else
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/show.jsp");
	}
	
	private void addcart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String count=request.getParameter("count");
		Users user=(Users)request.getSession().getAttribute("users");
		String userid=user.getId();
		
		if(count!=null) {
			Books book=(Books)request.getSession().getAttribute("showbook");
			String bookid=book.getId();
			cd.addcart(userid, bookid, count);
			}
		else {
			String bookid=request.getParameter("bookid");
			cd.addcart(userid, bookid, "1");
			}
		
		
		
		cd.getCart(request, response);
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/index.jsp");
	}
	private void addorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("addddddddddd");
		Users user=(Users)request.getSession().getAttribute("users");
		String userid=user.getId();
		String postad=request.getParameter("postad");
		System.out.println(postad);
		String sum=request.getParameter("sum");
		String cartsize=request.getParameter("cartsize");
		
		String[] orderbook=(String[])request.getSession().getAttribute("obook");
		String[] ocount=(String[])request.getSession().getAttribute("ocount");
		String[] oprice=(String[])request.getSession().getAttribute("oprice");
	int size=Integer.parseInt(cartsize);
		for(int i=0;i<size;i++) {
			
					System.out.println(orderbook[i]);
					System.out.println(i);
				}
			
		
	
		
		
		
		
		
		System.out.println(cartsize);
		System.out.println(sum);
		od.addorder(userid, postad, sum,size,orderbook,ocount,oprice);
		cd.getCart(request, response);
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/account.jsp");
		
	}
	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Users user=(Users)request.getSession().getAttribute("users");
		String userid=user.getId();
		String bookid=request.getParameter("bookid");
		cd.deleteCart(bookid, userid);
		cd.getCart(request, response);
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/index.jsp");
		
	}
	private void changePw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Users user=(Users)request.getSession().getAttribute("users");
		String userid=user.getId();
		System.out.println(userid);
		String old=request.getParameter("old");
		
		String newp=request.getParameter("newp");
		System.out.println(old);
		System.out.println(user.getLoginPwd());
		System.out.println(newp);		
		if(old.equals(user.getLoginPwd())) {
			usersDao.changepw(newp, userid);	
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/account.jsp");
		}
		else {
			request.setAttribute("message", "失败！<a href='javascript:window.history.back()'>返回</a>");
			//response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/login.jsp");
			try {
				request.getRequestDispatcher("/message.jsp").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
			
		}
		
		
	}
	private void listOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Users user=(Users)request.getSession().getAttribute("users");
		String userid=user.getId();
		List<Orders> orders=od.findByUserId(userid);
		request.getSession().setAttribute("orders", orders);
		System.out.println(orders.get(0).getOrderId());
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/listOrders.jsp");
		
		
	}
	
	private void findpw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String mail=request.getParameter("mail");
		Users user=usersDao.find(mail);
		String code="您的密码是："+user.getLoginPwd();
		SendMail.sendEmail(user.getMail(), code);
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/login.jsp");
		
		
		
	}
	private void addcomment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String comment=request.getParameter("input");
		System.out.println(comment);
		// 初始化敏感词库对象
        SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
        // 从数据库中获取敏感词对象集合（调用的方法来自Dao层，此方法是service层的实现类）
        Articel_WordsDao ad=new Articel_WordsDaoImpl();
        List<Articel_Words> sensitiveWords = ad.getWordPattern();
        // 构建敏感词库
        Map sensitiveWordMap = sensitiveWordInit.initKeyWord(sensitiveWords);
        // 传入SensitivewordEngine类中的敏感词库
        SensitivewordEngine.sensitiveWordMap = sensitiveWordMap;
		String comments= SensitivewordEngine.replaceSensitiveWord(comment, 2, "*");
		System.out.println(comments);
		Books book=(Books)request.getSession().getAttribute("showbook");
		bd.addcomment(book.getId(), comments);
		List<BookComment> commentss=bd.findComment(book.getId());
		request.getSession().setAttribute("comment", commentss);
		
		
		
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/show.jsp");
		
		
		
	}
	
	private void visitor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			List<Books> allbook=bd.findAllBook();
			Books[] book=new Books[10];
			for(int i=0;i<10;i++) {
				book[i]=allbook.get(i);
				request.getSession().setAttribute("book"+i, book[i]);
			}			
			
			
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/vindex.jsp");
		
		
		
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("users");
		response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/login.jsp");
		
	
	
}

	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}
}
