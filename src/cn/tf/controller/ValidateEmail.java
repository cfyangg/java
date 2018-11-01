package cn.tf.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import cn.tf.service.impl.*;

/**
 * Created by admin on 2018/5/29.
 */
@WebServlet(name ="validateEmail",urlPatterns = {"/validateEmail"})
public class ValidateEmail extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("发送执行");
    //    String validateCode="1234xx";
        int validateCode=0;
        for (int i = 0; i <= 200; i++)
        {
            validateCode =(int)(Math.random() * 1000000);
         
            String flag = String.valueOf(validateCode);
            if (flag.length() == 6 && flag.substring(0, 1).equals("9"))
            {
            	System.out.println(validateCode);
            }
            else
            {
            	validateCode = validateCode + 100000;
               // System.out.println(intFlag);
            }        
        }
        String v=String.valueOf(validateCode);
        System.out.println(validateCode);
        HttpSession session=req.getSession();
        session.setAttribute("v",v);//将验证码存储到Session传到前端
        String username=req.getParameter("Mail");
        session.setAttribute("Mail",username);
        String code="<h1>您的验证码是"+v+"  请不要把验证码透露给人，以免泄露信息！";
        SendMail.sendEmail(username,code);
        System.out.println("验证码已发送");
        resp.getWriter().write("发送成功");
        resp.setHeader("Refresh", "1;URL="+req.getContextPath()+"/regist1.jsp");
		
    }
}