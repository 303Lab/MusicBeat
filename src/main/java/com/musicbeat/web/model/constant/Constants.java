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

    // === Request URL Type ===
    public static final String HTTP_UTF8 = "UTF-8";

    // === Request Json Format===
    public static final String REQUEST_TYPE_JSON = "json";
    public static final String REQUEST_USERNAME_JSON = "username";
    public static final String REQUEST_PASSWORD_JSON = "password";
    public static final String REQUEST_DATA_JSON = "data";

    // === Session ===
    public static final String SESSION_USER = "userData";

    // === Access Token ===
    public static final String ACCESS_TOKEN = "accessToken";

    // === Auth Role ===
    public static final String AUTH_ROLE = "roleName";

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

    // === Log Object ===
    public static final String LOG_USER = "user";
    public static final String LOG_PASSWORD = "pass";
}
