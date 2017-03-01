/**
 * 国际过滤
 * @author windawings
 * @create.time 2017/02/28 15:28
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.filters")
    .filter("langFilter", langFilter);

function langFilter () {
    return function (lang) {
        if (lang === null || lang === undefined) return "";

        var langReflector = {
            "Chinese" : "华语",
            "English": "欧美",
            "Korean": "韩国",
            "Japanese": "日本",
            "Others": "其他",
        };

        return langReflector[lang];
    };
}