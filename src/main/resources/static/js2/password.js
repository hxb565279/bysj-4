$(document).ready(
    function () {
        $("#username").blur(function () {
            if ($("#username").val().length > 0) {
                $.ajax({
                    url:  "/checkUser.action",
                    type: "POST",
                    data: JSON.stringify({username: $("#username").val()}),
                    contentType: "application/json;charset=UTF-8",
                    dataType: "json",
                    success: function (data) {
                        if (data != null) {
                            $("#message").html("");

                        }
                    },
                    error: function () {
                        $("#message").html("该账号不存在,请注册");
                    }
                })
            }
        })
    }
)