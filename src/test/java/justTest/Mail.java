package justTest;

import org.junit.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/22 17:39
 * @Description version 1.0
 */
public class Mail {


    @Test
    public void testMail()throws Exception{
        Properties prop = new Properties();
        prop.setProperty("mail.host","mail.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(prop);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect("mail.qq.com","643180667@qq.com","");
        Message message = createMail(session);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }


    public Message createMail(Session session)throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("643180667@qq.com"));
        message.setSubject("simple mail");
        message.setContent("你好呀","text/html;charset=UTF-8");
        return message;
    }



}
