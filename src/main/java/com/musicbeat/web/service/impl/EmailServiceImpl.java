package com.musicbeat.web.service.impl;

import com.musicbeat.web.model.User;
import com.musicbeat.web.service.EmailService;
import com.musicbeat.web.service.UserService;
import com.musicbeat.web.utils.RandomUtil;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Future;

/**
 * 邮件激活实现类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/16 9:42
 * @since 1.0.0
 */
@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Resource
    private MimeMessage mimeMessage;

    @Resource
    private MimeMessageHelper mimeMessageHelper;

    @Override
    public boolean sendActiveEmail(User user, String randomString) {
        try {
            mimeMessageHelper.setSubject(MAIL_ACTIVE_SUBJECT);
            mimeMessageHelper.setTo(user.getEmail());

            //装配邮件内容
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer
              .append("<html><head></head><body><h1>")
              .append("Hello ")
              .append(user.getUsername())
              .append("!</h1><h1>Your Random Password: <u>")
              .append(randomString)
              .append("</u></h1></body></html>");

            mimeMessageHelper.setText(stringBuffer.toString(), true);

            // 发送邮件
            Transport.send(mimeMessage);

            return true;
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
    }

    @Override
    public boolean sendRetrieveEmail(User user, String url) {
        try {
            mimeMessageHelper.setSubject(MAIL_RETRIEVE_SUBJECT);
            mimeMessageHelper.setTo(user.getEmail());

            String hash = "233";

            //装配邮件内容
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer
              .append("<html><head></head><body><h3>")
              .append("Hello ")
              .append(user.getUsername())
              .append("!</h3><p>Change Password Link: <a href=\"")
              .append(url)
              .append("\"></p>")
              .append(url)
              .append("</a></body></html>");

            mimeMessageHelper.setText(stringBuffer.toString(), true);

            // 发送邮件
            Transport.send(mimeMessage);

            return true;
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
    }
}
