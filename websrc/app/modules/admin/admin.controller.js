/**
 *
 * @author windawings
 * @create.time 2017/02/13 21:37
 * @version 1.0.0
 * @since 1.0.0
 */

angular
    .module("app.ctrls")
    .controller("adminController", ["$scope", adminController]);

function adminController($scope) {


    
    /*==========  jQuery  ==========*/
    //获取class为caname的元素
    jQuery(".caname").click(function() {
        var td = jQuery(this);
        var txt = td.text();
        var input = jQuery("<input type='text' value='" + txt + "'/>");
        td.html(input);
        input.click(function() { return false; });

        //获取焦点
        input.trigger("focus");
        //文本框失去焦点后提交内容，重新变为文本
        input.blur(function() {
            var newtxt = jQuery(this).val();
            //判断文本有没有修改
            if (newtxt != txt) {
                td.html(newtxt);
                /**不需要使用数据库的这段可以不需要**/
                var caid = jQuery.trim(td.prev().text());
                //ajax异步更改数据库,加参数date是解决缓存问题
                var url = "../common/Handler2.ashx?caname=" + newtxt + "&caid=" + caid + "&date=" + new Date();
                //使用get()方法打开一个一般处理程序，data接受返回的参数（在一般处理程序中返回参数的方法 context.Response.Write("要返回的参数");）
                //数据库的修改就在一般处理程序中完成
                jQuery.get(url, function(data) {
                    if(data=="1") {
                        alert("该类别已存在！");
                        td.html(txt);
                        return;
                    }
                    alert(data);
                    td.html(newtxt);
                });
            } else {
                td.html(newtxt);
            }
        });
    });
}