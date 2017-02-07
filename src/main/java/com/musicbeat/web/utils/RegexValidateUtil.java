package com.musicbeat.web.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配类
 *
 * @author windawings
 * @time.creation 2017/01/26 13:45
 * @version 1.0.0
 * @since 1.0.0
 */
public class RegexValidateUtil {


  /**
   * 验证邮箱
   *
   * @param email 邮箱
   * @return boolean
   */
  public static boolean checkEmail(String email) {
    boolean flag = false;
    try {
      String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
      Pattern regex = Pattern.compile(check);
      Matcher matcher = regex.matcher(email);
      flag = matcher.matches();
    } catch (Exception e) {
      flag = false;
    }
    return flag;
  }

  /**
   * 验证手机号码
   *
   * @param mobileNumber 手机号码
   * @return boolean
   */
  public static boolean checkMobileNumber(String mobileNumber) {
    boolean flag = false;
    try {
      Pattern regex = Pattern.compile(
        "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
      Matcher matcher = regex.matcher(mobileNumber);
      flag = matcher.matches();
    } catch (Exception e) {
      flag = false;

    }
    return flag;
  }

  /**
   * 验证数字
   *
   * @param number 数字
   * @return boolean
   */
  public static boolean checkNumeric(String number) {
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher isNum = pattern.matcher(number);

    return isNum.matches();
  }
}
