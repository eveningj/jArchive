const d1 = $(".d1");


//좋지 않은 예시 (성능저하)
//////////////
/////////////////////
///////////////////////////////////////////
//문서 전체에 클릭이벤트를 적용 -> 그 중 특정 대상이 클릭되었을 때만 동작하게 만드는 코드
//문서 전체에 클릭이벤트를 적용했는데 그 중 대상이 .d1이면 동작
//페이지에 요소가 많아지면 -> 클릭이벤트가 많아짐. -> 페이지 속도가 느려짐.
/*$(document).on("click",".d1",function(){
    console.log($(this).text());
});*/


/*
$(".d1").eq(0).on("click",function(){
    console.log(0 + " : " + this.text());
});
$(".d1").eq(1).on("click",function(){
    console.log(1 + " : " + this.text());
});*/

/*$(".d1").each(function(i,item){
    $(item).on("click", function(){
        console.log(i+ " : " + $(item).text());
    })
})*/


$(".d1").on("click",function(){
    //this : 이벤트를 동작시킨 해당 요소
    //해당 요소가 몇번째 요소인지 찾는 방법
    const i = d1.index(this);
    console.log(i + " : " + $(this).text());
});

$("#btn1").on("click",function(){
    const div = $("<div>");
    div.addClass("d1");
    div.text("test");
    /*
    div.on("click",function(){
        console.log(div.text());
    })
        */
    $("#test1").append(div);
});

$(".btn").on("click",function(){
    //$(this).parent().children("span").last().text();
    $(this).each(function(i,item){
        const span = $(item).parent().children("span").last();
        let lvl = $(item).parent().children("span").last().text();
        span.text(Number(lvl)+1);
    })
    
});