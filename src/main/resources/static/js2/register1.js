$(document).ready(
    function () {

        $("#username1").blur(function () {
            if ($("#username1").val().length > 0) {
                let username = $("#username1").val();
                $.ajax({
                    url:  "/checkUser",
                    type: "POST",
                    data: JSON.stringify({username: $("#username4").val()}),
                    contentType: "application/json;charset=UTF-8",
                    dataType: "json",
                    success: function (data) {
                        if (data != null) {
                            alert("23232")
                            $("#message4").html("该账号已经存在,请登录");
                        }
                    },
                    error: function () {
                        $("#message4").html("");
                    }
                })
            }else{
                alert("空")
                $("#message2").html("");
            }
        })
    }
)


$(document).ready(
    function (){
        $("#re_password1").blur(
            function (){
                if ($("#re_password1").val().length>0){
                    let password2 = $("#password1").val();
                    let password1 = $("#re_password1").val();
                    if (password1===password2){

                    }else{
                        alert("两次密码不一致");}
                }
            }
        )
    }
)
