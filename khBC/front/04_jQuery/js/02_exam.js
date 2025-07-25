
const btn1 = $("#btn1");
const tbl = $("#tbl1 td");
const tbl1 = $("#tbl1");

btn1.on("click", function () {
    const dataArray = new Array();

    tbl.each(function(i, item) {
        dataArray.push($(item).text());
    });

    let output = "";
    for (let i = 0; i < dataArray.length; i += 3) {
        output += `${dataArray[i]}/${dataArray[i + 1]}/${dataArray[i + 2]}<br>`;
    }

    $("#result1").html(output);
});

const btn2 = $("#btn2");
btn2.on("click", function () {
    
    const tr = $("#tbl1 tr").not(":first");
    
    tr.each(function () {
        $(this).children().eq(0).addClass("name");
        $(this).children().eq(1).addClass("age");
        $(this).children().eq(2).addClass("addr");
    });

    $("#tbl1").find("th").addClass("title");
});

const btn3 = $("#btn3");
btn3.on("click", function () {
    
    const tr = $("#tbl1 tr").not(":first");
    
    tr.each(function () {
        $(this).children().eq(0).removeClass("name");
        $(this).children().eq(1).removeClass("age");
        $(this).children().eq(2).removeClass("addr");
    });

    $("#tbl1").find("th").removeClass("title");
});

/*
let copy;
$(".copy").on("click",function(){
    copy = $(this).clone();
});

$("#exam3").children("fieldset").not(":first").children("div").on("click",function(){
    $(this).append(copy);
})

const btn4 = $("#btn4");
btn4.on("click",function(){
    const divs = $("#exam3").children("fieldset").not(":first").find(".copy");
    divs.removeAttr("style");
    const divd = $("#exam3").children("fieldset").not(":first").children("div");
    divd.empty();
});
*/
$(".copy").on("click",function(){
    let color = $(this).css("background-color");
    $("#exam3").children("fieldset").not(":first").children("div").on("click",function(){
        $(this).css("background-color",color);
    });
});

const btn4 = $("#btn4");
btn4.on("click",function(){
$("#exam3").children("fieldset").not(":first").children("div").removeAttr("style");
});



const tbl2 = $("#tbl2");


const btn5 = $("#btn5");
btn5.on("click",function(){
    const dataArray = new Array();
    const td = $("#tbl2").find("[type=checkbox]:checked").parent().parent().children("td");
    td.each(function(i, item) {
        console.log($(item).text());
        dataArray.push($(item).text());
    });
    
    let output = "";
    for (let i = 0; i < dataArray.length; i += 3) {
        output += `${dataArray[i]}/${dataArray[i + 1]}/${dataArray[i + 2]}<br>`;
    }
    $("#result2").html(output);
});
