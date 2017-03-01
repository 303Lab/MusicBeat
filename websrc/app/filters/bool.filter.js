/**
 *
 * @author windawings
 * @create.time 2017/02/28 15:31
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.filters")
    .filter("boolFilter", boolFilter);

function boolFilter () {
    return function (bool) {
        if (bool === undefined) return "";
        return bool === null ? "??" : bool ? "是" : "否";
    };
}