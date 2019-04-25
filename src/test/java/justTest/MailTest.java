package justTest;

import org.junit.Test;
import utils.MailUtil;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/22 17:39
 * @Description version 1.0
 */
public class MailTest {



    @Test
    public void testMail()throws Exception{
        String sendMail = "15516549468@163.com";
        String receiveMail = "643180667@qq.com";
        String pwd = "hzy15516549468";
        Properties props = new Properties();
        props.setProperty("mail.host","smtp.163.com");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(props);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect(sendMail,pwd);
        Message message = MailUtil.createMail(session, sendMail, receiveMail);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }



}
