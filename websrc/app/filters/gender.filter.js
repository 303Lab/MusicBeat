/**
 * 性别显示过滤
 * @author windawings
 * @create.time 2017/02/07 23:07
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.filters")
    .filter("genderFilter", genderFilter);

function genderFilter () {
    return function (gender) {
        if (gender === undefined) return "";
        return gender === null ? "嬲" : gender ? "男" : "女";
    };
}