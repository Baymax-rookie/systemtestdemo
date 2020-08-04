package org.systemtest.demo.utils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * @author 12589
 */
public class JavaMailUtil { public static String mailAccount="1258934139@qq.com";
    public static String mailPassword="bncdnlcvmxkdbacj";
    public static String mailHost="smtp.qq.com";
    public static String receiver="";

    public static MimeMessage createMimeMessage(Session session, String sendMail, String recvMail, String html) throws IOException, MessagingException {
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail,"发件人昵称","UTF-8"));
        message.setRecipients(MimeMessage.RecipientType.TO, new InternetAddress[]{new InternetAddress(recvMail, "jjj", "UTF-8")});
        message.setSubject("邮件实验");
        message.setContent(html,"text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        OutputStream out=new FileOutputStream("D://MailTest//"+ UUID.randomUUID().toString()+".eml");
        message.writeTo(out);
        out.flush();
        out.close();
        return message;
    }

    public static String postMail(String mail) throws MessagingException, IOException {
        receiver=mail;
        Properties properties=new Properties();
        Session session=Session.getInstance(PropertyUtil.getProperty(properties));
        session.setDebug(true);
        String code=RandomUtil.getRandom();
        String html= RandomUtil.getHtml(code);
        MimeMessage message=JavaMailUtil.createMimeMessage(session,JavaMailUtil.mailAccount,JavaMailUtil.receiver,html);
        Transport transport=session.getTransport();
        transport.connect(JavaMailUtil.mailAccount,JavaMailUtil.mailPassword);
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
        return code;
    }
}
