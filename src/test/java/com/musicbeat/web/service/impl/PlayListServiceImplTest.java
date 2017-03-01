package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.service.PlayListService;
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

/**
 * PlayListServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2 16, 2017</pre>
 */

@RunWith(JUnit4ClassRunner.class)//表示继承了JUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"}) //指定Spring配置文件的位置
//很多情况下单元测试离不开事务，下面的注解指明使用的事务管理器
//如果defaultRollback为true，测试运行结束后，默认回滚事务，不影响数据库
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class PlayListServiceImplTest {
    private static Logger logger = Logger.getLogger(PlayListServiceImplTest.class);

    @Resource
    private PlayListService playListService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getByUser(Integer userId)
     */
    @Test
    public void testGetByUserUserId() throws Exception {
        JSONArray playLists = playListService.getByUser(1);
        logger.info(JSON.toJSONString(playLists));
    }

    /**
     * Method: getByUser()
     */
    @Test
    public void testGetByUser() throws Exception {
    }

    /**
     * Method: addMusic(Integer mId, Integer uId)
     */
    @Test
    public void testAddMusic() throws Exception {
     /*PlayList playList = new PlayList(
             3,
             4
     );
     playListService.addMusic(playList);
     logger.info(JSON.toJSONString(playList));*/
    }

    /**
     * Method: deleteMusic(Integer mId, Integer uId)
     */
    @Test
    public void testDeleteMusic() throws Exception {
    /*PlayList playList = new PlayList(
            3,
            4
    );
    playListService.deleteMusic(playList);
    logger.info(JSON.toJSONString(playList));*/
    }

    /**
     * Method: downloadMusic(Integer musicId)
     */
    @Test
    public void testDownloadMusic() throws Exception {
        String url = playListService.downloadMusic(1);//慎用缓存 查询不更新。。。。。
        logger.info(url);
    }

} 
