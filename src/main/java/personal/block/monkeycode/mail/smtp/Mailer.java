package personal.block.monkeycode.mail.smtp;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

/**
 * Created by yaoqijun.
 * Date:2015-08-13
 * Email:yaoqj@terminus.io
 * Descirbe:    提供邮件发送相关的服务
 */
public class Mailer {

    //发送邮件的相关属性
    private Properties props = new Properties();

    //
    private Session session = null;

    // 默认采用对应的 smtp  不采用smtps 的方式
    public Mailer(String host, String port, final String account, final String password){
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.username", account);
        props.setProperty("mail.smtp.auth","true");     //通过安全验证的方式

        //简历Session 回话
        session  = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });
    }

    /**
     * 发送对应的邮件内容
     * @param eMail
     */
    public void sendMail(EMail eMail){
        try{
            Message message = eMail.getMessage(session);
            Transport transport = session.getTransport();
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("software finish");
        }catch(Exception e){
            System.out.println("software over");
        }
    }

}
