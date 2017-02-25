package com.musicbeat.web.model.constant;

/**
 * 常量类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/01/26 13:30
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

    public static final String REQUEST_COMMENT_JSON = "comment";

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

    // === Response Server Error Message
    public static final String RESPONSE_ERROR_EXCEPTION = "Server Error, Try Again!";

    // === Response Login Error Message ===
    public static final String RESPONSE_ERROR_CREDENTIAL = "Username or Password Error!";

    // === Response Log Off Error Message ===
    public static final String RESPONSE_ERROR_LOGOFF_USER_BLANK = "the User has Logged Off!";

    // === Response Register Error Message ===
    public static final String RESPONSE_ERROR_REGISTER = "Register Error, Try Again!";
    public static final String RESPONSE_ERROR_REGISTER_DUPLICATE_EMAIL = "the Email has already registered!";
    public static final String RESPONSE_ERROR_REGISTER_DUPLICATE_USERNAME = "the UserName has already registered!";
    public static final String RESPONSE_ERROR_REGISTER_TIMEOUT = "Waiting... Look Out Your Email later.";

    // === Response Retrieve Error Message ===
    public static final long RETRIEVE_EXPIRE_TIME = 30 * 60 * 1000;
    public static final String RESPONSE_ERROR_RETRIEVE = "Retrieve Error, Try Again!";
    public static final String RESPONSE_ERROR_RETRIEVE_NONE_USER = " doesn't be registered.";
    public static final String RESPONSE_ERROR_RETRIEVE_NONE = "None Params Found.";
    public static final String RESPONSE_ERROR_RETRIEVE_NOW_EXPIRE = "Retrieve Email has sent, try again after 30m.";
    public static final String RESPONSE_ERROR_RETRIEVE_TIMEOUT = "Retrieve Expired.";

    // === Log Object ===
    public static final String LOG_USER = "user";
    public static final String LOG_EMAIL = "email";
    public static final String LOG_PASSWORD = "pass";
    public static final String LOG_NEW_PASSWORD = "newPass";

    // === Service Error Message ===
    public static final String USERSERVICE_ERROR_DELETE = "Internal Error - Delete Failed";
    public static final String USERSERVICE_ERROR_INSERT = "Internal Error - Insert Failed";
    public static final String USERSERVICE_ERROR_RETRIEVE = "Internal Error - Retrieve Failed";

    //=== Find Error Message ===
    public static final String SEARCH_ERROR = "Failed Searching";
}
