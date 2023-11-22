package top.tobycold.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.qq.com"); // QQ邮箱SMTP服务器地址
        props.put("mail.smtp.port", "587"); // QQ邮箱SMTP服务器端口
        props.put("mail.smtp.auth", "true"); // 是否需要授权
        props.put("mail.smtp.starttls.enable", "true"); // 启用安全连接

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tobyhome@qq.com", "fgpmteftzebygeji"); // 发件人邮箱账号和授权码
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("tobyhome@qq.com")); // 发件人地址
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tobycold@qq.com")); // 收件人地址
        message.setSubject("测试邮件"); // 邮件主题
        message.setText("这是一封测试邮件"); // 邮件内容
    }


}
