package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.musicbeat.web.service.CategoryService;
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

/**
 * CategoryServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2 15, 2017</pre>
 */

@RunWith(JUnit4ClassRunner.class)//表示继承了JUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"}) //指定Spring配置文件的位置
//很多情况下单元测试离不开事务，下面的注解指明使用的事务管理器
//如果defaultRollback为true，测试运行结束后，默认回滚事务，不影响数据库
@Rollback(false)
@Transactional(transactionManager = "transactionManager")
public class CategoryServiceImplTest {
    private static Logger logger = Logger.getLogger(CategoryServiceImplTest.class);

    @Resource
    private CategoryService categoryService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findByReleaseTime()
     */
    @Test
    public void testFindByReleaseTime() throws Exception {
        PageHelper.startPage(1, 10);
        JSONArray mvs = categoryService.findByReleaseTime();
        logger.info(JSON.toJSONString(mvs));
//TODO: Test goes here... 
    }

    /**
     * Method: findByPlayAmount()
     */
    @Test
    public void testFindByPlayAmount() throws Exception {
        JSONArray musicsTest = categoryService.findByPlayAmount();
        logger.info(JSON.toJSONString(musicsTest));
//TODO: Test goes here... 
    }

    /**
     * Method: findByDownloadAmount()
     */
    @Test
    public void testFindByDownloadAmount() throws Exception {
        JSONArray musicsTest = categoryService.findByDownloadAmount();
        logger.info(JSON.toJSONString(musicsTest));
//TODO: Test goes here... 
    }

    /**
     * Method: findByLaber(Integer laberId)
     */
    @Test
    public void testFindByLabelName() throws Exception {
        JSONArray musicList = categoryService.findByLabelName("夜晚");
        logger.info(JSON.toJSONString(musicList));
//TODO: Test goes here... 
    }

} 
