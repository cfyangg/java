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
        // �����ļ��ϴ����������, ����FileItem����
        DiskFileItemFactory fac = new DiskFileItemFactory();
        // ���������ϴ��ļ���ʱĿ¼
        String temp = getServletContext().getRealPath("/img");
        fac.setRepository(new File(temp));
         
        // �����ļ��ϴ����������
        ServletFileUpload upload = new ServletFileUpload(fac);
        // һ�������ļ���С
        upload.setFileSizeMax(30*1024*1024);// �����ļ����ܳ���30M
        upload.setSizeMax(50*1024*1024);    // ���ļ����ܳ���50M
         
        // ���������ϴ��ļ����ݱ���
        String newName="";
        upload.setHeaderEncoding("UTF-8");
            try {
                // ���ϴ��������ù�����ת��ΪList<FileItem>
            	@SuppressWarnings("unchecked") 
                List<FileItem> list = upload.parseRequest(request);
                // �������е��ļ���
                for (FileItem item : list) {
                    // �ж��Ƿ�Ϊ��ͨ�ı���
                    if (item.isFormField()) {
                        // ��ȡ�ı�������
                        String filedName = item.getFieldName();
                        // ��ȡ�ı������ƶ�Ӧ��ֵ
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
                        // �ļ���
                         
                        // ��ȡ�ļ���
                    	String fileName = item.getName();//a.txt
                    	System.out.println(fileName);
                        // ����IE�����
                        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                        String[] fileNames = fileName.split("\\.");
                        System.out.println(fileNames[0]+"   "+fileNames[1]);
                        // �ļ�������
                        String filedName = item.getFieldName();
                        System.out.println(filedName);
                         
                        // ��ȡ�ϴ�Ŀ¼·��
                        String basePath = getServletContext().getRealPath("/img");
                        System.out.println(basePath);
                        
                        // �ġ�����ļ�����������
                        // ��ȡ��ǰʱ��
                        newName = newName+"."+fileNames[1];
                        System.out.println(newName);
                        // �ϴ�
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
                        // ����ɾ����ʱĿ¼
                        item.delete();
                    }
                }
                System.out.println("iii");
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.getWriter().write("�ϴ�ͼƬ�ɹ�");
            response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/upload.jsp?id="+newName+"&op=1");
 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
