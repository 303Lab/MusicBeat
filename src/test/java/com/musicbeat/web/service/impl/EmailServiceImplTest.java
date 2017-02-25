package com.musicbeat.web.service.impl;

import com.musicbeat.web.model.User;
import com.musicbeat.web.service.EmailService;
import com.musicbeat.web.utils.JUnit4ClassRunner;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * EmailServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2, 16, 2017</pre>
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class EmailServiceImplTest {

    private static Logger logger = Logger.getLogger(EmailServiceImplTest.class);

    private User user = null;

    @Resource
    private EmailService emailService;

    @Before
    public void before() throws Exception {
        user = new User();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sendActiveEmail(String to)
     */
    @Test
    public void testSendActiveEmail() throws Exception {
        user.setUsername("windawings");
        user.setEmail("windawings@foxmail.com");
        emailService.sendActiveEmail(user, "random password");
    }

    /**
     * Method: sendRetrieveEmail(String to)
     */
    @Test
    public void testSendRetrieveEmail() throws Exception {
        user.setEmail("windawings@foxmail.com");
        emailService.sendRetrieveEmail(user, "localhost");
    }

} 
