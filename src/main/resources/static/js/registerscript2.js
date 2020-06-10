/**
 * Created by Intellij IDEA.
 * @Author CAIXIANGYU
 * @Date 2020/06/03
 * @Comment js文件，用于页面发送ajax请求
 */

//定义一个avalonjs的控制器
var viewmodel = avalon.define({
    //id必须和页面上定义的ms-controller名字相同，否则无法控制页面
    $id: "registermodel",
    datalist: {},
    text: "请求数据",

    request: function () {
        $.ajax({
            url: "/test/registerUser",    //向后台请求的数据库地址
            //success为成功载入后的回调函数
            //data为成功调用后的返回数据
            data: {"username": $("username").val()},
            datatype: "json",
            success: function (data) {
                $('button').removeClass("btn-primary").addClass("btn-success").attr('disabled', true);

                viewmodel.datalist = data;

                viewmodel.text = "数据请求成功，已渲染";
            }
        });
    }
});