package com.musicbeat.web.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * SMTP邮件服务认证类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/16 15:39
 * @since 1.0.0
 */
public class SmtpAuthenticatorUtil extends Authenticator {
    private String username;
    private String password;

    public SmtpAuthenticatorUtil(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
