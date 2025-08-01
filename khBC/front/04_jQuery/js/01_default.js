function func1(){
    /*const p1 = document.getElementById("p1");
    console.log(p1.innerText);*/
    /*const p1 = document.querySelector("#p1");
    console.log(p1.innerText);*/
    
    //jquery 는 dom객체 접근 : $("선택자");
    const p1 = $("#p1");
    //js에서 가져온 dom 객체와, jquery 로 가져온 dom 객체는 다름
    //(지칭하는 태그는 같음, 객체 내부 구성이 다름)
    //  -> 객체의 형태가 다르기 때문에, 사용할 수 있는 속성/함수가 다름.
    //  -> jQuery 에서는 직접 속성에 접근하는 방식은 없음. -> jQuery 가 함수로 제공.
    const text = p1.text();//innerText -> text();
    console.log(text);
    const html= p1.html(); //innerHTML -> html();
    console.log(html);
    //innerHTML or innerText를 수정하려면?
    //js -> 객체.innerHTML = "수정값"; -> 객체.html("수정값");
    //객체.innerText = "수정값";    -> 객체.text("수정값");
    p1.text("수정 데이터");
    //CSS 변경
    //글씨색, 배경색 변경
    //js
    //p1.style.color = "red";
    //p1.style.backgroundColor = "yellow";
    
    //jQuery -> css() 함ㅁ수를 사용 -> 객체.css("속성이름", "속성 값");
    //p1.css("color","red");
    //p1.css("background-color","yellow");
    //css 속성을 한번에 여러개 변경하는 경우1 -> css() 함수를 이어서 여러개 사용 가능
    //p1.css("color","red").css("background-color","yellow");
    //css 속성을 한번에 여러개 변경하는 경우2
    p1.css({"color" : "red ",
        "backgroundColor" : "yellow"
    });
    //css 함수 사용할 때 매개변수를 1개만 주면 -> 해당 css 속성 이름만 주면 현재 적용된 값 리턴
    const color = p1.css("color")
    console.log(color);
}
/*
const p = document.querySelectorAll(".p");
p.forEach(function(item){
    item.addEventListener("click", function(){
        const text = this.innerText;
        console.log(text);
    })
});
*/
const p = $(".p");
//dom 객체 관련 설정을 여러개의 dom 객체도 일괄적용이 가능.

p.on("click",function(){
    //this 는 클릭이벤트를 발생시킨 dom 객체
    //this 는 javascript dom 객체 -> jquery 함수를 바로 사용 불가능
    //javascript dom 객체를 jQuery dom 객체로 변환 -> $(객체);
    const text = $(this).text();
    console.log(text);
});

/*p[0].addEventListener("click",function(){
    const text = this.innerText;
    console.log(text);
});
p[1].addEventListener("click",function(){
    const text = this.innerText;
    console.log(text);
});
p[2].addEventListener("click",function(){
    const text = this.innerText;
    console.log(text);
});*/

function func2(){
    const pp = $(".p");
    console.log(pp.text());
    //이벤트 설정, css 변경, 속성 변경 일괄처리 -> 반복문 사용 X
    pp.text("변경~");
    pp.css("background-color","yellow").css("color","red");

    //set 하는 행위는 일괄 설정이 가능
    //get 하는 행위는 각각 사용을 권고
}

function func3(){
    const pp = $(".filter>p");
    console.log("선택된 엘리먼트 수 : "+pp.length);
    //first() : 선택자로 선택된 요소 중 첫번째 요소
    //last() : 선택자로 선택된 요소 중 마지막 요소
    const first = pp.first();
    const last = pp.last();

    console.log(first.text());
    console.log(last.text());
    //eq(인덱스 번호)   : 인덱스 번째에 해당하는 요소
    const eq = pp.eq(1);
    console.log(eq.text());

    for(let i = 0; i<pp.length; i++){
        const obj = pp.eq(i);
        console.log(obj.text());
    }

    //first -> eq(0);
    //last -> eq(length-1);


    //filter("선택자") : 이미 선택자로 선택된 요소 중 다시 선택자로 한번 더 필터링
    const filter = pp.filter(".pp1");
    filter.css("color","red");

    //not("선택자") : 선택자로 선택된 요소 중 다시 선택자에 해당되지 않는 요소만!
    const not = pp.not(".pp3");
    not.css("background-color", "yellow");
}

function func4(){
    const span = $(".ancestors span");
    //parent() : 선택된 요소의 바로 상위요소
    const ele = span.parent();
    ele.css("border-color","red");

}
function func5(){
    const span = $(".ancestors span");
    //parents([매개변수])
    //매개변수가 없는 경우 : 선택된 요소 기준으로 모든 상위요소
    //매개변수가 있는 경우 : 선택된 요소 기준으로 모든 상위요소 중 매개변수로 전달한 선택자에 해당하는 요소만

    const ele = span.parents("div");
    ele.css("border","2px solid red");
}
function func6(){
    const span = $(".ancestors span");
    //parentsUntil(매개변수) : 선택된 요소부터 매개변수로 전달된 요소까지 범위에 해당하는 모든 함수
    //최초 선택요소, 매개변수로 주어지는 요소는 선택에서 제외
    const ele = span.parentsUntil("div");
    ele.css("border","2px solid red");
    ele.first().css("color","red");
    ele.eq(1).css("color","blue");
    ele.eq(2).css("color","green");
}

function func7 (){
    const div = $(".descendants");
    //children([param])   
    //매개변수 없는 경우 : 모든 직계 자손 요소만
    //매개변수 있는 경우 : 모든 직계 자손 요소 중 매개변수 선택자에 해당하는 요소만
    const ele = div.children("p");
    ele.css("border","2px solid red");
}
function func8(){
    const div = $(".descendants");
    //find(param) : 모든 후손 요소 중 매개변수 선택자에 해당하는 요소만
    const ele = div.find(".child1");
    ele.css("border","2px solid red");
}

function func9(){
    const h3 = $(".siblings h3");
    //siblings([매개변수])
    //매개변수 없는 경우 : 형제관계에 있는 모든 요소
    //매개변수 있는 경우 : 형제관계에 있는 요소 중 매개변수 선택자에 해당하는 요소만
    const ele = h3.siblings("p");
    ele.css("border", "2px solid red");
}
function func10(){
    const h3 = $(".siblings h3");
    //next() : 선택된 요소의 바로 다음 요소
    const ele = h3.next();
    ele.css("border", "2px solid red");
}
function func11(){
    const h3 = $(".siblings h3");
    const ele = h3.nextAll("h5");
    //const ele = h3.next().next()
    ele.css("border", "2px solid red");
    //nextAll([param])
    //매개변수 없는 경우 : 선택된 요소의 형제 요소 중 선택된 요소 이후에 있는 모든 요소
    //매개변수 있는 경우 : 선택된 요소의 형제 요소 중 선택된 요소 이후에 있는 요소 중 매개변수 선택자에 해당되는 요소만

}
function func12(){
    const h3 = $(".siblings h3");
    //nextUntil(매개변수) : 선택된 요소부터 매개변수로 전달한 요소 사이의 모든 요소
    const ele = h3.nextUntil("p");
    ele.css("border","2px solid red");
}
function func13(){
    //prev() : 선택된 요소 바로 이전요소
    const h3 = $(".siblings h3");
    const ele = h3.prev();
    ele.css("border","2px solid red");
}
function func14(){
    const h3 = $(".siblings h3");
    //prevAll([매개변수])
    //매개변수 없는 경우 : 선택된 요소의 이전요소 전체
    //매개변수 있는 경우 : 선택된 요소의 이전요소 중 매개변수로 전달한 선택자에 해당하는 요소만
    const ele = h3.prevAll("span");
    ele.css("border","2px solid red");
}
function func15(){
    const h3 = $(".siblings h3");
    //prevUntil(param) : 선택된 요소의 이전 요소 중 매개변수로 전달한 선택자 요소 사이에 있는 요소
    const ele = h3.prevAll("p");
    ele.css("border","2px solid red");
    ele.eq(0).css("color","red");
    ele.eq(1).css("color","blue");
}
function func16(){
    const span = $(".ancestors li>span");
    span.css("border","2px solid red");
    //const span2 = span.parent().parent().parent().next().children().children();
    const span2 = span.parent().parent().parent().parent().find("span").last();
    span2.css("border","2px solid blue");
}