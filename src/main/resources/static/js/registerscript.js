/**
 * Created by Intellij IDEA.
 * @Author CAIXIANGYU
 * @Date 2020/06/09
 * @Comment 获取用户提交的数据并返回给后台
 */
$("#btn").bind("click", function () {
    $.ajax({
        type: 'get',
        url: "/test/registerUser",
        data: {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            realname: $("#realname").val()
        },
        success: function (response) {
            alert(response);
        },
    });
});

// // 点击超链接的逻辑
// $("#hreflogin").bind("click", function () {
//     $.ajax({
//         type: 'get',
//         url: "/test/register",
//
//         success: function (response) {
//             alert("回调成功");
//         },
//     });
// });