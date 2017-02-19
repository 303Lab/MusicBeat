/**
 * 认证业务常量
 * @author windawings
 * @time.creation 2017/02/06 17:29
 * @version 1.0.0
 * @since 1.0.0
 */

angular.module("app.configs")
    .constant("authEvent", {
        ok: "ok",
        fail: "fail",
        notOk: "Server Error, Try Again!",
        registerOk: "Success! Look Out Your Email Please.",
        registerWait: "Waiting... Look Out Your Email later.",
        registerDefault: "A Password Will Be E-Mailed To You.",
        retrieveOk: "Success! Look Out Your Email Please.",
        retrieveDefault: "Your Retrieve Web Page Will Be E-Mailed To You.",
        changeDefault: "Change Password & Confirm.",
        changeOk: "Success! Redirect: Home Page...",
});