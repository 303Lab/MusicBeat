/**
 * 欢迎信息过滤
 * @author windawings
 * @create.time 2017/02/07 23:07
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.filters")
    .filter("welcomeFilter", welcomeFilter)
    .filter("ngDialogFilter", ngDialogFilter);

function welcomeFilter () {
    return function (data) {
        if (data === null || data === undefined) return "";
        return data.username;
    };
}

function ngDialogFilter () {
    return function (data) {
        if (data === null || data === undefined) return "";
        return angular.toJson(data, true);
    };
}