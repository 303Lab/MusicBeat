package com.musicbeat.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/08 18:17
 * @since 1.0.0
 */
public class TimeConvertUtil {

  /**
   * TimeStamp to Date time String, millisecond
   *
   * @param timestamp the timestamp
   * @return the string
   */
  public static String timeStamp2DateTimeMSec(long timestamp) {
    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp));
  }

  /**
   * TimeStamp to Date time String
   *
   * @param timestamp the timestamp
   * @return the string
   */
  public static String timeStamp2DateTime(long timestamp) {
    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp * 1000));
  }
}
