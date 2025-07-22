function func1(){
    /*
    innerHTML : 해당 dom 객체 (HTML요소) 의 시작태그와 종료태그 사이의 내용을 모두 가져옴 (자료형은 문자열)
        -> 가져온 내용 중에 HTML태그가 포함되어 있으면 태그를 모두 포함해서 가져옴
        -> 요소 노드와 텍스트 노드를 모두 가져옴

    innerText : 해당 dom 객체 (HTML요소) 의 시작태그와 종료태그 사이의 내용을 모두 가져옴 (자료형은 문자열)
        -> 가져온 내용중에 HTML 태그가 포함되어 있으면 태그를 제외하고 글씨만 가져옴
        -> 텍스트 노드만 가져옴
    */

    const d1 = document.querySelector("#d1");
    const html = d1.innerHTML;
    const text = d1.innerText;
    console.log(html);
    console.log(text);
    /*
    innerHTML, innerText 값을 수정
    -> 수정하려는 데이터가 태그가 없으면 innerHTML이나 innerText가 동일
    -> 수정하려는 데이터에 태그가 있으면
        -> innerHTML : 문자열에 있는 태그가 HTML 태그로 동작
        -> innerText : 문자열에 있는 태그가 문자열로 표현
    */
   //d1.innerHTML = "html 값 변경";
   // d1.innerText = "text 값 변경";
   //d1.innerHTML = "<a href = '#'>테스트</a>";
   //d1.innerText = "<a href='#'>테스트</a>";


   /*
dom.appendChild(data);
    -> 데이터의 자료형이 객체(요소 노드 || 텍스트 노드) / 요소 노드, 텍스트 노드 둘다 가능 // 기존 데이터를 유지하고 가장 마지막에 추가

dom.innerHTML = data;
    -> 데이터의 자료형이 문자열     / 요소 노드, 텍스트 노드 둘다 가능 / 기존 데이터를 대체

dom.innerText = data;
    -> 데이터의 자료형이 문자열    / 텍스트 노드만 가능 /기존 데이터를 대체

    +=      -> 기존 데이터 유지(append) (뉴적가능)
    */

    //outerHTML: 해당 요소의 시작태그와 종료태그 '를 포함한 모든 내용을'  문자열로 가져옴. (읽기 전용 -> 수정 불가능)
    const out = d1.outerHTML;
    console.log(out);


}

const btn2 = document.querySelector("#btn2");
btn2.onclick = function(){
    console.log("btn2 클릭");
    const dd2 = document.querySelectorAll(".dd2");
    const d3HTML = dd2[0].innerHTML;
    const d4Text = dd2[1].innerText;
    console.log(d3HTML);
    console.log(d4Text);
    dd2[0].innerText = "값 변경 테스트1";
    dd2[1].innerHTML = "값 변경 테스트2";
}

const btn3 = document.querySelector("#btn3");
btn3.onclick = function(){
    console.log("btn3 클릭");
    const name2 = document.querySelectorAll("[name=name2]");
    
    name2.forEach(function(item){
        item.computedStyleMap.color = "blue";
    });

    /*for(let i=0;i<name2.length;i++){
        name2[i].style.color = "blue";
    }
/*    name2[0].style.color = "blue";
    name2[1].style.color = "blue";
    name2[2].style.color = "blue";
    */
}

function func4(){
    //input 태그에 현재 입력된 값을 가져오려면 value 속성을 사용
    const input = document.querySelector("#input1");
    const data = input.value;
    console.log(data);
}

const btn5 = document.querySelector("#btn5");
btn5.onclick = function(){
    const input = document.querySelector("#input1");
    input.value = "변경";
}

function func6(){
    const input = document.querySelector("#input2");
    const pw  = input.value;
    console.log(pw);
    if(pw === ""){
        alert("패스워드를 입력해주세요!");
    }else if(isFinite(pw)){
        alert("비밀번호를 누가 요즘 숫자로만 쓰나 !!");
    }
}

function func7(){
    const input = document.querySelector("#input3");
    /*    const id = input.id;
    const type = input.type;
    console.log(id,type);
    const checked = input.checked;
    console.log(checked);
    */
   //태그에서 속성이 속성이름=값 형태가 아니라 속성이름만 있는 경우
   //활호화성ㅎ -> 비활성화ㅎ : true / false 자리
   const checked = input.checked;
   console.log(checked);
   //input.checked = false
   console.log("checekd :"+checked);
   input.chekced = !checked;
   /*
   if(checked){
    input.checked = false;
   }else {
    input.checked = true;
   }*/
}

function func8(){
    const input = document.querySelector("#input2");
    console.dir(input);
    //내부 객체 처리 방식으로 인해
    // dom객체. 속성이름으로 가져올 수 없는 속성
    // -> readonly, class

    // 값 읽어올 때 getAttribute("속성이름");
    // 값 변경할 때 setAttribute("속성이름", 변경값);
    // 해당 속성 삭제 removeAtrribute("속성이름");
    const data = input.getAttribute("readonly");
    console.log(data);
    input.removeAttribute("readonly");
}

const allAgree = document.querySelector("#all-agree");
const agree = document.querySelectorAll("[name=agree]");
allAgree.onclick = function(){
    const check = allAgree.checked;
    console.log(check);

    agree.forEach(function(item){
        item.checked = check;
    });
        /* for (let i =0; i<agree.length;i++){
            agree[i].checked = check;
        }
        /*
        agree[0].checked = check;
        agree[1].checked = check;
        agree[2].chekced = check; 
        */
        
}

/*
for(let i = 0; i<agree.length;i++){
    agree[i].onclick = function(){
        let count = 0;
    for(let i = 0; i<agree.length;i++){
        if(agree[i].checked === true){
            count++;
        }
    }
    if(count === 3){
        allAgree.checked = true;
    }else{
        allAgree.checked = false;
    }
    }
}
/*
agree[0].onclick = function(){
    let count = 0;
    for(let i = 0; i<agree.length;i++){
        if(agree[i].checked === true){
            count++;
        }
    }
    console.log(count);
    if(count === 3){
        allAgree.checked = true;
    }else{
        allAgree.checked = false;
    }
}
    */
/*
agree.forEach(function(item){
    채워넣어보기.
})*/

agree.forEach(function(item){
    item.onclick = function(){
        const checkedInput = document.querySelectorAll("[name=agree]:checked");
        allAgree.checked = (checkedInput.length === 3);
        /*
        if(checkedInput.length ===3){
            allAgree.checked = true;
        }else{
            allAgree.checked = false;
        }
    }*/
}});


function plus(){
    const amount = document.querySelector("#amount");
    //현재 input 에 입력된 값
    const current = amount.innerText;
    console.log(current);
    amount.innerText = Number(current) + 1;
}

function minus(){
    const amount = document.querySelector("#amount");
    //현재 input 에 입력된 값
    const current = amount.innerText;
    console.log(current);
    amount.innerText = current -1;
}

/*
만들어야할 기능이 있는 경우
//1. 사용자가 어떤 행동을 했을 때
    //-> 구글로 이동으로 변경 버튼을 눌렀을 때
    //-> 함수 생성
//2. HTML 태그의 속성을 변경
    //-> 아이디가 link 인 태그의 내부 글씨를 구글로 이동으로 변경


*/
function funcTest(){
    const link = document.querySelector("#link");
    /*link.href = "http://www.google.com";
    link.innerText = "구글로 이동";*/
    const href = link.getAttribute("href");
    if (href === "http://www.naver.com") {
        link.href = "http://www.google.com";
        link.innerText = "구글로 이동";
        btn9.innerText = "네이버로 이동으로 변경";
    }else if (href === "http://www.google.com") {
        link.href = "http://www.naver.com";
        link.innerText = "네이버로 이동";
        btn9.innerText = "구글로 이동으로 변경";
    }
}

function pinkbtn(){
    const div = document.querySelectorAll(".test-div");
    
    for (let i = 0; i<div.length; i++){
        div[i].style.width = "300px";
        div[i].style.height = "300px";
        div[i].style.backgroundColor = "pink";
    }
}

function defbtn(){
    const div = document.querySelectorAll(".test-div");
    
       for (let i = 0; i<div.length; i++){
        div[i].removeAttribute("style");
        /*
        div[i].style.width = "150px";
        div[i].style.height = "150px";
        div[i].style.backgroundColor = "blue";
        */
    }
        
}

const btn12 = document.querySelector("#btn12");
btn12.onclick = function(){
    const div = document.querySelectorAll(".test-div");
    //dom 객체.classList.add("클래스이름"); : 매개변수로 전달한 클래스를 기존 클래스에 추가
    // -> 매개변수로 전달한 클래스를 이미 가지고 있으면 추가하지 않음.
    div.forEach(function(item){
        item.classList.add("big");
    });
    /*
    div[0].classList.add("big");
    div[2].classList.add("big");
    */
}

const btn13 = document.querySelector("#btn13");
btn13.onclick = function(){
    const div = document.querySelectorAll(".test-div");
    //dom객체 .classList.remove("클래스이름"); : 매개변수로 전달한 클래스를 기존 클래스에서 제거
    // -> 매개변수로 전달한 클래스를 가지고있지 않으면 아무 작업도 하지 않음.
    div.forEach(function(item){
        item.classList.remove("big");
    });
}

const btn14 = document.querySelector("#btn14");
btn14.onclick = function(){
    const divs = document.querySelectorAll(".test-div");
    //dom 객체 classList.contains("클래스명") : 매개변수로 전달한 클래스의 존재 여부를 리턴
    divs.forEach(function(item){
        /*
        const data = item.classList.contains("big");
        
        if(data === true){
            item.classList.remove("big");
        }else{
            item.classList.add("big");
        }*/
       //dom 객체.classList.toggle("클래스명") : 매개변수로 전달한 클래스를 가지고 있으면 remove /
       //   -> 가지고 있지 않으면 add
       item.classList.toggle("big");
    })
}

/*const div1 = document.querySelector("#test1");
const div2 = document.querySelector("#test2");
const div3 = document.querySelector("#test3");
div1.onclick = function(){
    div1.classList.add("big");
    div2.classList.remove("big");
    div3.classList.remove("big");
}
*/
const testDivs = document.querySelectorAll(".test-div");


/*for (let i = 0; i<testDivs.length; i++) {
testDivs[i].onclick = function(){
    testDivs.forEach(function(item){
        item.classList.remove("big");
    });

    testDivs[i].classList.add("big");
}
}
*/
//for each
testDivs.forEach(function(div){
    div.onclick = function(){
    testDivs.forEach(function(item){
        item.classList.remove("big");
    });

    //-> 함수 내에서 this 를 사용하면 함수를 동작시킨 dom 객체를 지정함.
        //-> 선언적 함수에서는 this 로 대상 dom 객체를 찾을 수 없음.
    this.classList.add("big");
}});

//this 사용법 숙지.