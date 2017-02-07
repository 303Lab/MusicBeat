package com.musicbeat.web.model.constant;

/**
 * 常量类
 *
 * @author windawings
 * @time.creation 2017/01/26 13:30
 * @version 1.0.0
 * @since 1.0.0
 */
public class Constants {
  // === Request ===
  public static final String REQUEST_USERNAME = "username";
  public static final String REQUEST_PASSWORD = "password";

  // === Session ===
  public static final String SESSION_USER = "userData";

  // === Access Token ===
  public static final String Access_Token = "accessToken";

  // === Auth Role ===
  public static final String Auth_Role = "roleName";

  // === Response Status ===
  public static final String RESPONSE_STATUS = "status";

  // === Response Login Error Message ===
  public static final String RESPONSE_MESSAGE = "message";

  // === Response Login Status ===
  public static final String RESPONSE_SUCCESS = "success";
  public static final String RESPONSE_FAIL = "failed";

  // === Response Login Error Message ===
  public static final String RESPONSE_ERROR_CREDENTIAL = "用户名或密码错误!";
  public static final String RESPONSE_ERROR_EXCEPTION = "服务器出错，请重试!";

  // === Response Login Success Message ===
  public static final String RESPONSE_MESSAGE_SUCCESS = "OK";
}
