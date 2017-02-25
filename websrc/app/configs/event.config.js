/**
 * 认证业务常量
 * @author windawings
 * @time.creation 2017/02/06 17:29
 * @version 1.0.0
 * @since 1.0.0
 */

angular.module("app.configs")
    .constant("appEvent", {
        // web base const
        ok: "ok",
        fail: "fail",
        error: "Server Internal Error",
        notOk: "Server Error, Try Again!",

        // auth event
        registerOk: "Success! Look Out Your Email Please.",
        registerWait: "Waiting... Look Out Your Email later.",
        registerDefault: "A Password Will Be E-Mailed To You.",
        retrieveOk: "Success! Look Out Your Email Please.",
        retrieveDefault: "Your Retrieve Web Page Will Be E-Mailed To You.",
        changeDefault: "Change Password & Confirm.",
        changeOk: "Success! Redirect: Home Page...",
        changeCheckFailed: "Password Input Above Doesn't Match!",

        // music event
        noneMusic: "Error: No Music Found!",

        // singer event
        noneSinger: "Error: No Singer Found!",
});