package utils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/24 19:55
 * @Description version 1.0
 */
public class MailUtil {


    /**
     * https://blog.csdn.net/TangLingGuang/article/details/78419581
     * qq邮箱默认SMTP/POP3服务是关闭的,其他邮箱是默认开启的。
     * qq邮箱开启SMTP/POP3服务时会要求使用授权码，并在使用第三方客户端发送
     * 邮件时用授权码代替密码。所以使用qq邮箱的SMTP服务时，邮箱+授权码。
     * 使用其他邮箱的SMTP服务时，邮箱+密码：
     * 163 邮箱异常
     *      http://help.163.com/09/1224/17/5RAJ4LMH00753VB8.html
     * */
    static final String STMP_163 = "smtp.163.com";
    static final String STMP = "smtp";



    public static void sendMail(String sendMail, String pwd, String content, String receiveMail){

    }



    public static Message createMail(Session session, String sendMail, String receiveMail)throws Exception{
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));
        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("welcome", "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("gou dan dan ...","text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

}
