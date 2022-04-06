$(document).ready(
    function (){
        $("#id_card").blur(
            function (){
                if ($("#id_card").val().length>0){
                    let id_card=$("#id_card").val();
                    let id_cardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
                    if (!id_card.match(id_cardReg)){
                        $("#id_card1").html("身份证不合法,重新输入");
                    }else{
                        $("#id_card1").html("身份合法");
                    }
                }else{
                    $("#id_card1").html("");
                    $("#id_card").html("");
                }
            }
        )
    }



)
