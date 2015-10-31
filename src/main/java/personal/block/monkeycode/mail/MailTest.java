package personal.block.monkeycode.mail;

import personal.block.monkeycode.mail.smtp.ReceiverMail;

import javax.mail.Message;

/**
 * Created by yaoqijun.
 * Date:2015-08-12
 * Email:yaoqj@terminus.io
 * Descirbe:    通过该项目来测试 javax.mail 的内容的学习
 */
public class MailTest {
    public static void main(String []args){

        //测试邮件文本内容的发起
//        Mailer mailer = new Mailer(LocalConstants.SMTP_HOST,LocalConstants.SMTP_PORT,LocalConstants.ACCOUNT,LocalConstants.PASSWORD);
//        EMail eMail = new EMail("yaoqijunali@aliyun.com","yaoqijunmail@foxmail.com","title hah","yaoqijun success");
//        mailer.sendMail(eMail);
//        System.out.println("finish");

        //测试邮件的收取
        ReceiverMail receiverMail = new ReceiverMail("pop.qq.com","995","yaoqijunmail@foxmail.com","yaoqijun4094230");
        try{
            receiverMail.getConnection();
            System.out.print(receiverMail.folder.getMessageCount());
            for(Message message : receiverMail.folder.getMessages()){
                System.out.println(message.getContent());
            }
        }catch (Exception e){
            System.out.print(e);
        }finally {
            try{
                receiverMail.close();
            }catch (Exception e){

            }
        }
    }
}
