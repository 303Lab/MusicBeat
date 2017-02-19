package com.musicbeat.web.service;

import com.musicbeat.web.model.User;
import org.apache.log4j.Logger;

/**
 *
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/16 9:30
 * @since 1.0.0
 */
public interface EmailService {

    Logger logger = Logger.getLogger(EmailService.class);

    static final int MAIL_ACTIVE_CODE_LENGTH = 8;

    static final int MAIL_RETRIEVE_CODE_LENGTH = 6;

    static final String MAIL_ACTIVE_SUBJECT = "[Music Beat] Account Active Email";

    static final String MAIL_RETRIEVE_SUBJECT = "[Music Beat] Account Retrieve Email";

    public boolean sendActiveEmail(User user, String randomString);

    public boolean sendRetrieveEmail(User user, String url);
}
