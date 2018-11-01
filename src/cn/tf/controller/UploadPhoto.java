package cn.tf.controller;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadPhoto extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建文件上传工厂类对象, 产生FileItem对象
        DiskFileItemFactory fac = new DiskFileItemFactory();
        // 二、设置上传文件临时目录
        String temp = getServletContext().getRealPath("/img");
        fac.setRepository(new File(temp));
         
        // 创建文件上传核心类对象
        ServletFileUpload upload = new ServletFileUpload(fac);
        // 一、设置文件大小
        upload.setFileSizeMax(30*1024*1024);// 单个文件不能超过30M
        upload.setSizeMax(50*1024*1024);    // 总文件不能超过50M
         
        // 三、设置上传文件数据编码
        String newName="";
        upload.setHeaderEncoding("UTF-8");
            try {
                // 把上传数据利用工厂类转换为List<FileItem>
            	@SuppressWarnings("unchecked") 
                List<FileItem> list = upload.parseRequest(request);
                // 遍历所有的文件项
                for (FileItem item : list) {
                    // 判断是否为普通文本项
                    if (item.isFormField()) {
                        // 获取文本框名称
                        String filedName = item.getFieldName();
                        // 获取文本框名称对应的值
                        String value = item.getString("UTF-8");
                        /*
                        value = item.getString();
                        value = new String(value.getBytes("iso8859-1"),"utf-8");
                        */
                        System.out.println(filedName+""+value);
                        newName = value;
                        System.out.println(newName);
                    }
                    else {
                        // 文件项
                         
                        // 获取文件名
                    	String fileName = item.getName();//a.txt
                    	System.out.println(fileName);
                        // 兼容IE浏览器
                        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                        String[] fileNames = fileName.split("\\.");
                        System.out.println(fileNames[0]+"   "+fileNames[1]);
                        // 文件域名称
                        String filedName = item.getFieldName();
                        System.out.println(filedName);
                         
                        // 获取上传目录路径
                        String basePath = getServletContext().getRealPath("/img");
                        System.out.println(basePath);
                        
                        // 四、解决文件重名的问题
                        // 获取当前时间
                        newName = newName+"."+fileNames[1];
                        System.out.println(newName);
                        // 上传
                        File ff=new File(basePath,newName);
                        item.write(ff);
                        String output="G:\\eclipse\\workspace\\BookShop\\WebContent\\img";
                        System.out.println(output);
                        InputStream is = new FileInputStream(ff);
                        OutputStream os = new FileOutputStream(new File(output,newName));
                        byte[] buf = new byte[1024];
                        int len = -1;
                        while ((len = is.read(buf)) != -1) {
                        os.write(buf, 0, len);
                        }
                        is.close();
                        os.close();
                        // 二、删除临时目录
                        item.delete();
                    }
                }
                System.out.println("iii");
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.getWriter().write("上传图片成功");
            response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/upload.jsp?id="+newName+"&op=1");
 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
