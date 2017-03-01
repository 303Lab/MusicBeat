package com.musicbeat.web.utils;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.PlayListService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.SESSION_MUSICIDS;
import static com.musicbeat.web.model.constant.Constants.SESSION_USER;

/**
 * Session事件监听器
 *
 * @author windawings
 * @time.creation 2017/02/06 21:47
 * @version 1.0.0
 * @since 1.0.0
 */
public class HttpSessionMonitorListener implements HttpSessionListener {

  @Resource
  private PlayListService playListService;

  private static Logger logger = Logger.getLogger(HttpSessionMonitorListener.class);

  private void log(HttpSessionEvent se, Boolean flag) {
    HttpSession session = se.getSession();
    JSONObject obj = new JSONObject();
    int maxInterval = 1800;

    obj.put("session", session.getId());
    obj.put("live(s)", maxInterval);
    obj.put("create", TimeConvertUtil.timeStamp2DateTimeMSec(session.getCreationTime()));
    obj.put("expire", TimeConvertUtil.timeStamp2DateTimeMSec(session.getCreationTime() + (long)maxInterval*1000));
    obj.put("lastAccess", TimeConvertUtil.timeStamp2DateTimeMSec(session.getLastAccessedTime()));

    if(flag) { logger.info(obj.toJSONString() + " Session created"); }
    else { logger.info(obj.toJSONString() + " Session destroyed"); }
  }

  /**
   * Notification that a session was created.
   *
   * @param se the notification event
   */
  @Override
  public void sessionCreated(HttpSessionEvent se) {
    this.log(se, true);
  }

  /**
   * Notification that a session is about to be invalidated.
   *
   * @param se the notification event
   */
  //过期就把缓存里的数据放到数据库中
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
      this.log(se, false);
      User user = (User) se.getSession().getAttribute(SESSION_USER);
      Integer uId = user.getId();

      List<Integer> mIds = (List<Integer>) se.getSession().getAttribute(SESSION_MUSICIDS);

      if (mIds != null) {
          for (Integer id : mIds) {
              playListService.addMusicToList(uId, id);
          }
      }
  }
}