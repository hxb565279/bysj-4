let s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

function create(n) {
    let b = "";
    for (let i = 0; i < n; i++) {
        let index = Math.floor(Math.random() * 62);
        b = b + s.charAt(index);
    }
    return b;
}

function show() {
    document.getElementById("Captcha").innerHTML = create(4);
}

function check() {
    let c = $("#Captcha").html();
    let d = $("#captcha").val();

    if (c === d && c !== "" && d !== "") {
        return true;
    } else {
        alert("验证码不对,请重试");
        return false;
    }
}

function password() {

}




