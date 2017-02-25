package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.musicbeat.web.model.AlbumComment;
import com.musicbeat.web.model.MusicComment;
import com.musicbeat.web.service.CommentService;
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
 * CommentServiceImpl Tester.
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
public class CommentServiceImplTest {
    private static Logger logger = Logger.getLogger(CommentServiceImplTest.class);
    @Resource
    private CommentService commentService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addCommentMusic(Integer userId, Integer musicId, String Comment)
     */
    @Test
    public void testAddCommentMusic() throws Exception {
        MusicComment musicComment = new MusicComment(
          null,
          1,
          2,
          "test test test"
        );
        commentService.addCommentMusic(musicComment);
        logger.info(JSON.toJSONString(musicComment));

//TODO: Test goes here... 
    }

    /**
     * Method: addCommentAlbum(Integer userId, Integer albumId, String Comment)
     */
    @Test
    public void testAddCommentAlbum() throws Exception {
        AlbumComment albumComment = new AlbumComment(
          null,
          1,
          2,
          "testA testB testC"
        );
        commentService.addCommentAlbum(albumComment);
        logger.info(JSON.toJSONString(albumComment));
//TODO: Test goes here... 
    }

} 
