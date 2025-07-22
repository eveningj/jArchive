const btn1 = document.querySelector("#q1");
btn1.onclick = function(){
    let inputName = prompt("이름 입력");
    let inputAge = prompt("나이 입력");
    let inputAddr = prompt("주소 입력");

    const name = document.querySelector("#name");
    const age = document.querySelector("#age");
    const addr = document.querySelector("#addr");

    name.innerText = inputName;
    age.innerText = inputAge;
    addr.innerText = inputAddr;
}

const btn2 = document.querySelector("#q2");
btn2.onclick = function(){
    const input = document.querySelector("#input1");
    const val = input.value;
    const result = document.querySelector(".result");
    
    if (isFinite(val)){
        if (val%2 === 0) {
            result.innerText = "짝수";
        }else {
            result.innerText = "홀수";
        }
    }else if (val === null ||val == "") {
        result.innerText = "입력";
    }
    else{
        result.innerText = "숫자아님";
    }
    input.value = "";
}

const img = document.querySelector("img")
img.onclick = function(){
    img.src = "img/angel.png";
}

const btn3 = document.querySelector("#q4");
btn3.onclick = function(){
    const result = document.querySelector("#result");
    result.style.color = "navy";
}