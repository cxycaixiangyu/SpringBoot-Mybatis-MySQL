/**
 * Created by Intellij IDEA.
 * @Author CAIXIANGYU
 * @Date 2020/06/10
 * @Comment 获取用户提交的数据并返回给后台
 */
$("#login").bind("click", function () {
    $.ajax({
        type: 'get',
        url: "/test/loginUser",
        data: {
            username: $("#username").val(),
            password: $("#password").val(),
        },
        success: function (response) {
            alert(response);
        },
    });
});
