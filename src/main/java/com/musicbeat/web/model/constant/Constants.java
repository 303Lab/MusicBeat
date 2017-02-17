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
    public static final String REQUEST_EMAIL_JSON = "email";

    // === Session ===
    public static final String SESSION_USER = "userData";

    // === Auth Role ===
    public static final String AUTH_ROLE = "roleName";

    // === Response Status ===
    public static final String RESPONSE_STATUS = "status";

    // === Response Login Error Message ===
    public static final String RESPONSE_MESSAGE = "message";

    // === Response Login Status ===
    public static final String RESPONSE_SUCCESS = "ok";
    public static final String RESPONSE_FAIL = "fail";

    // === Response Login Error Message ===
    public static final String RESPONSE_ERROR_CREDENTIAL = "Username or Password Error!";
    public static final String RESPONSE_ERROR_EXCEPTION = "Server Error, Try Again!";
    public static final String RESPONSE_ERROR_LOGOFF_USER_BLANK = "the User has Logged Off!";
    public static final String RESPONSE_ERROR_REGISTER = "Register Error!";
    public static final String RESPONSE_ERROR_REGISTER_DUPLICATE_EMAIL = "the Email has already registered!";
    public static final String RESPONSE_ERROR_REGISTER_DUPLICATE_USERNAME = "the UserName has already registered!";
    public static final String RESPONSE_ERROR_REGISTER_TIMEOUT = "Waiting... Look Out Your Email later.";

    // === Log Object ===
    public static final String LOG_USER = "user";
    public static final String LOG_EMAIL = "email";
    public static final String LOG_PASSWORD = "pass";
}
