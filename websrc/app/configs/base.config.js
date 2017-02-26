/**
 *
 * @author windawings
 * @create.time 2017/02/23 14:58
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.configs")
    .constant("baseConst", {
        // home.html casual music
        freeTypes: {
            silence: "安静",
            classical: "古典",
            sport: "运动",
            electronic: "电子",
            ballad: "嘻哈",
            cure: "下午茶"
        },

        // header.html menu
        menu: {
            singer: {
                "歌手": {
                    "华语歌手": ["华语男歌手", "华语女歌手", "华语乐队组合"],
                    "日韩歌手": ["日本男歌手", "日本女歌手", "日本乐队组合", "韩国男歌手", "韩国女歌手", "韩国乐队组合"],
                    "欧美歌手": ["欧美男歌手", "欧美女歌手", "欧美乐队组合"],
                    "其他歌手": ["其他男歌手", "其他女歌手", "其他乐队组合"],
                },
            },
            music: {
                "歌曲": {
                    "语种": ["华语", "欧美", "日韩", "其他"],
                    "风格": ["流行", "摇滚", "民谣", "电子"],
                    "场景": ["安静", "运动", "旅行", "下午茶"],
                    "主题": ["影视原声", "校园歌曲", "KTV", "网络歌曲"],
                },
            },
            billboard: {
                "排行榜": ["新歌潮流榜", "经典热歌榜", "心随乐动榜"],
            }
        },

        // header.html ui-sref url reflect
        menuReflector: {
            "华语歌手": "ch",
            "华语男歌手": "chm",
            "华语女歌手": "chwm",
            "华语乐队组合": "chbk",
            "日韩歌手": "jk",
            "日本男歌手": "jm",
            "日本女歌手": "jwm",
            "日本乐队组合": "jbk",
            "韩国男歌手": "km",
            "韩国女歌手": "kwm",
            "韩国乐队组合": "kbk",
            "欧美歌手": "ea",
            "欧美男歌手": "eam",
            "欧美女歌手": "eawm",
            "欧美乐队组合": "eabk",
            "其他歌手": "other",
            "其他男歌手": "om",
            "其他女歌手": "owm",
            "其他乐队组合": "obk"
        },

        // music.html music type
        musicLabels: {
            "心情": ["安静", "运动", "旅行", "下午茶"],
            "场景": ["影视原声", "校园歌曲", "网络歌曲", "KTV"],
            "语种": ["华语", "日韩", "欧美", "其他"],
            "风格": ["流行", "摇滚", "R&B", "嘻哈", "乡村", "民谣", "爵士", "古典", "电子"],
        }
    });