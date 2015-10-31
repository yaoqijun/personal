package personal.block.monkeycode.mail.smtp;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

/**
 * Created by yaoqijun.
 * Date:2015-08-13
 * Email:yaoqj@terminus.io
 * Descirbe: 默认采用POP3 的邮件接受服务器
 */
public class ReceiverMail {

    private Properties props = null ;

    private Session session = null;

    private String account;

    private String password;

    public Folder folder = null;      //邮箱信息

    public Store store = null;

    public Message[] messages = null; //对应的邮件内容

    public ReceiverMail(String host,String port, String account, String password){
        // 准备连接服务器的会话信息
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3");       // 协议
        props.setProperty("mail.pop3.port", port);             // 端口
        props.setProperty("mail.pop3.host", host);    // pop3服务器
        session = Session.getInstance(props);

        this.account = account;
        this.password = password;
    }

    public void getConnection() throws Exception{
        //获取邮件Store
        Store store = session.getStore("pop3");
        store.connect(account, password);

        // 获得收件箱
        folder = store.getFolder("INBOX");
        /* Folder.READ_ONLY：只读权限
         * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
         */
        folder.open(Folder.READ_WRITE); //打开收件箱

        // 得到收件箱中的所有邮件,并解析
        messages = folder.getMessages();
    }

    public void close() throws Exception {
        if(folder!=null) {folder.close(true);}
        if(store!=null) {store.close();}
    }
}
