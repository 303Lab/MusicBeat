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
    public static final String REQUEST_NEW_PASSWORD_JSON = "newpass";
    public static final String REQUEST_EMAIL_JSON = "email";
    public static final String REQUEST_CITY_JSON = "city";
    public static final String REQUEST_SEX_JSON = "sex";
    public static final String REQUEST_QQ_JSON = "qq";
    public static final String REQUEST_COMMENT_JSON ="comment";
    //add by gyz 2.22
    public static final String REQUEST_SINGERID_JSON = "singerid";
    public static final String REQUEST_SINGERNAME_JSON = "singername";
    public static final String REQUEST_SINGERPIC_JSON = "singerpic";
    public static final String REQUEST_SINGERGENDER_JSON = "gender";
    public static final String REQUEST_SINGERLANG_JSON = "lang";
    public static final String REQUEST_SINGERISBAND_JSON = "isBand";
    public static final String REQUEST_SINGERINFO_JSON = "introduction";
 	public static final String REQUEST_ALBUMID_JSON = "albumid";
    public static final String REQUEST_ALBUMNAME_JSON = "albumname";
    public static final String REQUEST_ALBUMRELEASETIME_JSON = "albumrt";
    public static final String REQUEST_ALBUMPIC_JSON = "albumpic";
    public static final String REQUEST_ALBUMINFO_JSON = "albuminfo";
	public static final String REQUEST_MUSICID_JSON = "musicid";
    public static final String REQUEST_MUSICNAME_JSON = "musicname";
    public static final String REQUEST_MUSICLINK_JSON = "musiclink";
    public static final String REQUEST_MUSICLYRICS_JSON = "musiclyrics";

    public static final String REQUEST_LABELGROUPID_JSON = "labelgroupid";
    public static final String REQUEST_LABELGROUPNAME_JSON = "labelgroupname";
    public static final String REQUEST_LABELID_JSON = "labelid";
    public static final String REQUEST_LABELNAME_JSON = "labelname";
    






    // === Session ===
    public static final String SESSION_USER = "userData";
    //add by gyz 2.22
    public static final String SESSION_SINGER = "singerData";
    public static final String SESSION_ALBUM = "albumData";
    public static final String SESSION_MUSIC = "musicData";
    public static final String SESSION_LABEL = "labelData";
    public static final String SESSION_LABELGROUP = "labelgroupData";

    // === Auth Role ===
    public static final String AUTH_ROLE = "roleName";

    // === Response Status ===
    public static final String RESPONSE_STATUS = "status";

    // === Response Login Error Message ===
    public static final String RESPONSE_MESSAGE = "message";

    // === Response Login Status ===
    public static final String RESPONSE_SUCCESS = "ok";
    public static final String RESPONSE_FAIL = "fail";

    // === Response Update Password Error Message
    public static final String RESPONSE_ERROR_PARAM_NOT_EXIST = "Params Lost, Try Again!";
    public static final String RESPONSE_ERROR_USERNAME_DUPLICATION = "Params Lost or UserName Dumplication!";
    public static final String RESPONSE_ERROR_NOTHING_UPDATE = "Nothing to Update!";

    // === Response Server Error Message
    public static final String RESPONSE_ERROR_EXCEPTION = "Server Error, Try Again!";

    // === Response Login Error Message ===
    public static final String RESPONSE_ERROR_CREDENTIAL = "Username or Password Error!";

    public static final String RESPONSE_ERROR_PASSWORD = "Old Password Error!";

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
    public static final String LOG_NEW_USER = "userUpdate";
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
