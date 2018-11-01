package cn.tf.service.impl;



import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
	public static String account="yangcf5812@163.com";//���163����
    public static String password="yang538538";//�������

    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
    // ����163����� SMTP ��������ַΪ: smtp.163.com
    public static String myEmailSMTPHost = "smtp.163.com";

    //�����ʼ��ķ���
    public static void sendEmail(String to,String code) {//to���͵��ĸ����䣬code������ɵ���λ��֤��
        // 1.�������Ӷ������ӵ����������
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");

        // 2.�������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });
        try {
            // 3.�����ʼ�����
            Message message = new MimeMessage(session);
            // 3.1���÷�����
            message.setFrom(new InternetAddress(account));
            // 3.2�����ռ���
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 3.3�����ʼ�������
            message.setSubject("�𾴵Ĺ˿ͣ����ã�");
            // 3.4�����ʼ�������
            //message.setContent("<h1>������֤���ǣ�</h1><h3><a href='http://localhost:10080/Demo_JavaMail/active?code=" + code + "'>http://localhost:10080/Demo_JavaMail/active?code=" + code + "</h3>", "text/html;charset=UTF-8");

            message.setContent(code, "text/html;charset=UTF-8");

            // 4.�����ʼ�
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
