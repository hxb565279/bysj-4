$(document).ready(
    function (){
        $("#shadow-password2").blur(
            function (){
                if ($("#shadow-password2").val().length>0){
                   let password2 = $("#shadow-password2").val();
                   let password1 = $("#shadow-password1").val();
                   if (password1===password2){

                   }else{
                   alert("两次密码不一致");}
                }
            }
        )
    }
)



function quit(){
    document.getElementById("shadow-username1").value = "";
     document.getElementById("shadow-password1").value= "";
     document.getElementById("shadow-password2").value = "";
}


















$("#shadow1").hide();
