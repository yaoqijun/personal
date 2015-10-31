package personal.block.monkeycode.mail.smtp;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * Created by yaoqijun.
 * Date:2015-08-13
 * Email:yaoqj@terminus.io
 * Descirbe: 对应的发送一封邮件
 */
public class EMail {

    private String from ; //发件人的信息

    private String to;  //收件人的信息

    private String subject; //主题信息

    private String content; //发送信息的内容

    public EMail(String from, String to, String subject,String content){
        this.from = from;
        this.to = to;
        this.content = content;
        this.subject = subject;
    }

    public Message getMessage(Session session) throws Exception{
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(from));
        mimeMessage.setSubject(subject);
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimeMessage.setSentDate(new Date());
        mimeMessage.setText(content);
        mimeMessage.saveChanges();
        return  mimeMessage;
    }
}
