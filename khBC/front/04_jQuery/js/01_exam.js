const bt1 = $("#text").text();
const bt2 = $(".text").text();
const bt3 =$("[name=text]").text();

function func1(){
    console.log(bt1);
}
function func2(){
    console.log(bt2);
}
function func3(){
    console.log(bt3);
}


function func4(){
    const checkBox = $("[name=study]:checked"); 
    let count = checkBox.length;
    console.log(count);
}


function func5(){
const pp = $("#pp");
pp.prev().children().first().css("border","1px solid red");
}

function func6(){
    const ul = $(".test ul");
    ul.next().children().not("#pica").first().css("border","1px solid red");
}

function func7(){
    const pica = $("#pica");
    pica.parentsUntil(".test").not("#pp").css("border-color","blue");
}

function func8(){
    const div = $(".test");
    const ppp = div.children().find("ul").children();
    for (let i = 0; i<ppp.length; i++){
        console.log(ppp.eq(i).text());
    }
}