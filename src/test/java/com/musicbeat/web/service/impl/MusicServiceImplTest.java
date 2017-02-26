package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.musicbeat.web.mapper.AlbumMapper;
import com.musicbeat.web.mapper.MusicMapper;
import com.musicbeat.web.mapper.SingerMapper;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import com.musicbeat.web.service.MusicService;
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
 * MusicServiceImpl Tester.
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
public class MusicServiceImplTest {
    private static Logger logger = Logger.getLogger(MusicServiceImplTest.class);

    @Resource
    private MusicService musicService;

    @Resource
    private MusicMapper musicMapper;

    @Resource
    private AlbumMapper albumMapper;

    @Resource
    private SingerMapper singerMapper;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get()
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getByMusicId(Integer id)
     */
    @Test
    public void testGetByMusicId() throws Exception {
        MusicViewModel music = musicService.getByMusicId(3);
        Singer singer = singerMapper.selectByPrimaryKey(32);
        Album album = albumMapper.selectByPrimaryKey(1);
        logger.info(JSON.toJSONString(music));
        logger.info(singer.getName());
        logger.info(music.getName());
//TODO: Test goes here... 
    }

    /**
     * Method: getByMusicName(String Mname, Boolean like)
     */
    /*@Test
    public void testGetByMusicName() throws Exception {
        List<MusicViewModel> musicList = musicService.getByMusicName("她说", false);
        for (MusicViewModel music : musicList) {
            logger.info(music.getId());
        }
        logger.info(musicList);
//TODO: Test goes here...
    }*/

    /**
     * Method: getByAlbumName(String Aname, Boolean like)
     */
    @Test
    public void testGetByAlbumName() throws Exception {
        List<Album> albums = musicService.getAlbumsByAlbumName("初学者");
        logger.info(JSON.toJSONString(albums));
//TODO: Test goes here... 
    }

    /**
     * Method: getBySingerName(String Sname, Boolean like)
     */
    @Test
    public void testGetBySingerName() throws Exception {
        List<Music> musicList = musicService.getBySingerName("薛之谦");
        for (Music music : musicList) {
            logger.info(music.getId());
        }
        logger.info(JSON.toJSON(musicList));
//TODO: Test goes here... 
    }

    @Test
    public void testSelectMusicsBySingerId() throws Exception {
        PageHelper.startPage(1, 10);
        List<Album> albums = musicService.selectMusicsBySingerId(23);

        for (Album album : albums) {
            List<Music> musics = album.getMusics();
            for (Music music : musics) {
                logger.info("music信息为：" + JSON.toJSON(music));
            }
        }
        logger.info(JSON.toJSON(albums));//JSON.toJSON()转化为JSON对象
    }

    @Test
    public void testSelectById() throws Exception {
        Singer singer = musicService.selectAlbumsById(23);
        List<Singer> singers = singerMapper.selectSingersBySingerName("chinese", false);
        logger.info(JSON.toJSON(singers));
        logger.info(JSON.toJSON(singer.getAlbums()));
    }

    @Test
    public void testSelectSingerById() throws Exception {
        Album album = albumMapper.selectSingerById(6);
        logger.info(JSON.toJSON(album.getSinger()));
    }

    @Test
    public void testSelectMusicsById() throws Exception {
        PageHelper.startPage(2, 1);
        Album album = albumMapper.selectMusicsById(1);
        logger.info(JSON.toJSON(album.getMusics()));
    }

    @Test
    public void testSelectAlbumById() throws Exception {
        //PageHelper.startPage(2,1);
        Music music = musicMapper.selectAlbumById(5);
        logger.info(music.getName());
        logger.info(JSON.toJSON(music.getAlbum()));
    }

    @Test
    public void testSelectBySingerId() throws Exception {
        PageHelper.startPage(1, 10);
        JSONArray musics = musicService.selectBySingerId(23);
        logger.info(musics);
    }

    @Test
    public void selectByLangAndGenderAndBand() throws Exception {
        List<Singer> singers1 = musicService.selectByLangAndGenderAndBand("chinese", null, true);
        logger.info(JSON.toJSONString(singers1));

        List<Singer> singers2 = musicService.selectByLangAndGenderAndBand("chinese", false, false);
        logger.info(JSON.toJSONString(singers2));

        List<Singer> singers3 = musicService.selectByLangAndGenderAndBand("Others", null, false);
        logger.info(JSON.toJSONString(singers3));
    }
} 
