package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import com.musicbeat.web.utils.JUnit4ClassRunner;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.musicbeat.web.utils.BeatifyUtil.beatifyPassword;

/**
 * UserServiceImpl Tester.
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 1/8/2017
 * @since 1.0.0
 */
@RunWith(JUnit4ClassRunner.class)//表示继承了JUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"}) //指定Spring配置文件的位置
//很多情况下单元测试离不开事务，下面的注解指明使用的事务管理器
//如果defaultRollback为true，测试运行结束后，默认回滚事务，不影响数据库
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class UserServiceImplTest {
    private static Logger logger = Logger.getLogger(UserServiceImplTest.class);

    @Resource
    private UserService userService;

    private User user = null;
    private List<User> users = null;

    @Before
    public void before() throws Exception {
        user = new User();
    }

    @After
    public void after() throws Exception {
        if (users != null) {
            users.clear();
        }
    }

    /**
     * Method: register(User user)
     */
    /*@Test
    public void testRegister() throws Exception {
        user.setEmail("windawings@foxmail.com");
        boolean result = userService.register(user);
        users = userService.findByEmail(user.getEmail(), false);
        if (!users.isEmpty()) {
            users = beatifyPassword(users);
            logger.info(JSON.toJSONString(users.get(0)) + ", " + result);
        } else {
            logger.info(JSON.toJSONString(user) + ", " + result);
        }
    }*/

    /**
     * Method: deleteByEmail(String email)
     */
    @Test
    public void testDeleteByEmail() throws Exception {
        user.setEmail("windawings@foxmail.com");
        boolean result = userService.deleteByEmail(user.getEmail());
        logger.info(JSON.toJSONString(user) + ", " + result);
    }

    /**
     * Method: deleteByUserName(String username)
     */
    @Test
    public void testDeleteByUserName() throws Exception {
        user.setUsername("windawings");
        boolean result = userService.deleteByUserName(user.getUsername());
        logger.info(JSON.toJSONString(user) + ", " + result);
    }

    /**
     * Method: add(User user)
     */
    @Test
    public void testAdd() throws Exception {
        user.setUsername("test");
        user.setPassword("123");
        user.setPrivilege("admin");
        user.setEmail("test@test.com");
        user.setPicture("images/user.png");
        boolean result = userService.add(user);
        user.setPassword(beatifyPassword(user));
        logger.info(JSON.toJSONString(user) + ", " + result);
    }

    /**
     * Method: update(User user)
     */
    @Test
    public void testUpdate() throws Exception {
        user.setId(2);
        user.setPicture("images/user.png");
        boolean result = userService.update(user);
        user.setPassword(beatifyPassword(user));
        logger.info(JSON.toJSONString(user) + ", " + result);
    }

    /**
     * Method: delete(Integer id)
     */
    @Test
    public void testDelete() throws Exception {
        users = userService.findByUserName("windawings", false);
        boolean result = false;
        if (!users.isEmpty()) {
            users = beatifyPassword(users);
            result = userService.delete(users.get(0).getId());
        }
        logger.info(JSON.toJSONString(users) + ", " + result);
    }

    /**
     * Method: findById(Integer id)
     */
    @Test
    public void testFindById() throws Exception {
        List<User> users = userService.findById(2);
        for (User user : users) {
            user.setPassword(beatifyPassword(user));
        }
        logger.info(JSON.toJSONString(users));
    }

    /**
     * Method: findByUserName(String name, Boolean like)
     */
    @Test
    public void testFindByUserName() throws Exception {
        List<User> users = userService.findByUserName("windawings", true);
        users = beatifyPassword(users);
        logger.info(JSON.toJSONString(users));

        users = userService.findByUserName("windawings", false);
        users = beatifyPassword(users);
        logger.info(JSON.toJSONString(users));
    }

    /**
     * Method: findByRealName(String realname)
     */
    @Test
    public void testFindByRealName() throws Exception {
        List<User> result = userService.findByRealName("www", true);
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));
    }

    /**
     * Method: findAdmin()
     */
    @Test
    public void testFindAdmin() throws Exception {
        List<User> result = userService.findAdmin();
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));
    }

    /**
     * Method: findByPhone(String phone)
     */
    @Test
    public void testFindByPhone() throws Exception {
        List<User> result = userService.findByPhone("13066666666", false);
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));
    }

    /**
     * Method: findByEmail(String email)
     */
    @Test
    public void testFindByEmail() throws Exception {
        List<User> result = userService.findByEmail("windawings@foxmail.com", true);
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));
    }

    /**
     * Method: findAdminByPage(PaginationContextUtil page)
     */
    @Test
    public void testFindAdminByPage() throws Exception {
        PageHelper.startPage(1, 2);
        List<User> result = userService.findAdmin();
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));

        PageHelper.startPage(2, 2);
        result = userService.findAdmin();
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));

        PageHelper.startPage(3, 2);
        result = userService.findAdmin();
        result = beatifyPassword(result);
        logger.info(JSON.toJSONString(result));
    }
}