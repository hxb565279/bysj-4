$(document).ready(
    function (){
        $("#username").blur(
            function (){
                if ($("#username").val().length>0){
                    let username=  $("#username").val();
                    let username_1 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/
                    if (username.match(username_1)){

                    }else{
                        alert("账号不符合规范");
                    }
                }else{

                }
            }

        )
    }
)