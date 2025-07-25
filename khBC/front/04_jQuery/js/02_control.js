function func1(){
    //js방식
    /*const divs = document.querySelectorAll("#test1>div");
    for(let i = 0; i<divs.length; i++){
        console.log(`${i} : ${divs[i].innerText}`)
    }

    divs.forEach(function(item,i){
        console.log(`${i} : ${item.innerText}`)
    });

    //내부 수행 코드에서 반복회차 번호가 필요없으면 선언하지 않고 사용
    divs.forEach(function(item){
        console.log(item.innerText);
    })
    */


    /*
    //jQuery 방식
    const divs = $("#test1>div");
    for(let i=0; i<divs.length; i++){
        console.log(`${i} : ${divs.eq(i).text()}`);
    }
    //each : js의 forEach 와 유사한 함수로 배열 전체를 순회
    //배열.each(function(i, item){})    
    // -> param  순서가 forEach 하고 반대
    // -> 첫번째 매개변수가 순회번호 / 두번째 매개변수가 해당 순번의 배열에서 꺼내온 데이터
    // -> 이 때 두번째 매겨변수 item 은 javascript 객체
    // -> jQuery 형식으로 사용하려면 $(item) 형식으로 사용

    divs.each(function(i,item){
        console.log(i + " :" + $(item).text());
    });
    //내부 수행코드에서 반복회차번호가 필요없는 경우
    // -> i값을 사용하지 않더라도 반드시 선언해야함
    divs.each(function(i,item){
        console.log($(item).text());
    });
    */
   const divs = $("#test1>div");
   //객체.is("선택자") : 객체가 해당 선택자에 해당되면 true / 아니면 false 를 리턴
   $.each(divs,function(i,item){}

    );//-> 동일 문법
   divs.each(function(i,item){
        const div = $(item);
        console.log(i+" : "+div.text());
        //이번회차의 객체가 d1클래스를 가지고 있는지 체크
        const test1 = div.is(".d1");
        console.log(test1);
        if(div.is(".d1")){
            div.css("color","red");
        }else if(div.is(".d2")){
            div.css("color","blue");
        }else{
            div.css("background-color","yellow");
        }
   });
}

function func2(){
    //js 문법
    /*const divs = document.querySelectorAll("#test2>div");
    divs[0].classList.add("t-red");
    divs[1].classList.add("t-red");
    divs[2].classList.add("t-red");
    divs[3].classList.add("t-red");
    divs[4].classList.add("t-red");*/
    /*divs.forEach(function(item){
        item.classList.add("t-red");
    });*/
    const divs = $("#test2>div");
    /*
    divs.eq(0).addClass("t-red");
    
    divs.each(function(i,item){
        $(item).addClass("t-red");
    });
    */
   divs.addClass("t-red");
   divs.eq(2).addClass("bg-yellow");
   divs.eq(3).addClass("bg-yellow");
}
function func3(){
    const divs = $("#test2>div");
    divs.removeClass("t-red");
    divs.removeClass("bg-yellow");
}
function func4(){
    const divs = $("#test2>div");
    const data1 = divs.eq(1).hasClass("bg-yellow");
    const data2 = divs.eq(2).hasClass("bg-yellow");
    console.log(data1);
    console.log(data2);
}
function func5(){
    const divs = $("#test2>div");
    divs.toggleClass("bg-yellow");
}
function func6(){
    //const inputs = $("#test3>input");
    const labels = $("#test3>label");
    //객체.attr(param1, param2) : 객체의 param1 속성에 param2 값을 대입
    //객체.attr(param1) : param1 속성에 해당하는 값을 리턴
    /*
    const id1 = inputs.eq(0).prev().attr("id");
    
    labels.eq(0).attr("for",id1);
    labels.eq(1).attr("for","oracle");
    labels.eq(2).attr("for","front");
    */
   labels.each(function(i,label){
    const id = $(label).prev().attr("id");
    $(label).attr("for",id);
   })
}
function func7(){
    const labels = $("#test3>label");
    labels.removeAttr("for");
}

function func8(){
    const inputs = $("#test3>input");
    const data = inputs.first().prop("checked");
    inputs.prop("checked",true);
    console.log(data);
}
function func9(){
    const divs = $("#test4>div");
    //css 함수에 매개변수 1개 (css속성이름) 넣으면 해당 속성에 적용된 값을 가져옴
    const data1 = divs.eq(0).css("float");
    console.log(data1);
    const data2 = divs.eq(0).css("background-color");
    console.log(data2);
    //css 함수에 매개변수 2개 넣으면 속성을 변경
    divs.eq(1).css("background-color","blue");
    //대상 객체에 css 속성을 한번에 여러개 변경하려면?
    //divs.first().css("background-color","red").css("float","none");
    divs.first().css({
        backgroundColor : "red",
        float : "none"
    });
}

function func10(){
    const h1 = $("#test5>h1");
    //html()을 매개변수 없이 사용하면 값을 가져옴
    const data = h1.html();
    console.log(data);
    //html(param1) : 매개변수를 주면 매개변수로 컨텐츠 영역을 변경
    h1.html("<span>hh</span>");
}
function func11(){
    const h1 = $("#test5>h1");
    const data = h1.text();
    console.log(data);
    //text(param1) : 매개변수를 주면 매개변수로 컨텐츠 영역을 변경
    h1.text("<span>hh</span>");

}
function func12(){
    const input = $("#test5>input");
    //val() 을 매개변수 없이 사용하면 value 속성에 있는 값을 가져옴
    const inputValue = input.val();
    console.log(inputValue);
    //val(param1) : 매개변수를 주면 매개변수로 value 속성 값을 변경
    input.val("값변경");
}
let i = 5;
function func13(){
    //const p = document.createElement("p");
    //jQuery 에서 새로운 dom 객체를 생성하는 방법
    const p = $("<p>");//<p></p>
    p.text("text - " + i);
    i++;

    const div = $("#test6");
    //객체1.append(객체2) : 객체1의 마지막 자식으로 객체2를 추가
    div.append(p);
    //객체2.appendTo(객체1) -> p.appendTo(div);
}

function func14(){
    const p = $("<p>");
    p.text ("test -- " + i);
    i++;
    const div = $("#test6");
    //객체1.prepend(객체2) : 객체1의 첫번째 자식으로 객체2를 추가
    div.prepend(p);
    //객체2. prependTo(객체1)
}
function func15(){
    const p = $("<p>");
    p.text ("test -- " + i);
    i++;
    const div = $("#test6");
    //객체1.after(객체2) : 객체1의 객체1의 다음 요소로 객체2를 추가
    div.after(p);
    //객체2. insertAfter(객체1)
}
function func16(){
    const p = $("<p>");
    p.text ("test -- " + i);
    i++;
    const div = $("#test6");
    //객체1.before(객체2) : 객체1의 객체1의 이전 요소로 객체2를 추가
    div.after(p);
    //객체2. insertBefore(객체1)
}
const btn17 = $("#btn17");
btn17.on("click",function(){
    const h3 = $("#test7>h3");
    h3.remove();//대상객체 제거
});
$("#btn18").on("click",function(){
    const div = $("#test7");
    div.empty();    //대상 객체는 남겨두고 내부의 모든 후손을 삭제
});
$("#btn19").on("click",function(){
    const h2 = $("#test7>h2");
    const div = $("#test8");
    div.append(h2);
});
$("#btn20").on("click",function(){
    const h2 = $("test7>h2").clone();
    const div = $("#test8");
    div.append(h2);
});