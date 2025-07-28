const div = $("#div");

$("#btn1").on("click",function(){
    div.show(2000); //display 를 원래 속성으로.
});
$("#btn2").on("click",function(){
    div.hide(1000); //display : none;
});
$("#btn3").on("click",function(){
    div.toggle(1000);
});;

$("#btn4").on("click",function(){
    div.slideDown(400);
});
$("#btn5").on("click",function(){
    div.slideUp(5000);
});
$("#btn6").on("click",function(){
    div.slideToggle(90);
});

$("#btn7").on("click",function(){
    div.fadeIn();
});

$("#btn8").on("click",function(){
    div.fadeOut(5000);
});

$("#btn9").on("click",function(){
    div.fadeToggle();
});

$("#btn10").on("click",function(){
    div.animate(
        {
            "width" : "150px", 
            "height" : "100px", 
            "background-color" : "yellow"
        }, //animate 함수는 숫자 속성만 지원함. (단, 배경색은 jquery - ui 를 사용하면 변경 가능함.)
        5000);
});