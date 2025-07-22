
//클릭1 버튼을 누르면 동작하는 함수
function func1(){
    //<p>안녕</p>을 생성해서 add-zone div에 추가
    //요소노드 : <p></p>, 텍스트노드 : 안녕
    //1. 요소노드 생성 (내가 생성하고 싶은 태그를 만들어내는 과정)
    const p = document.createElement("p"); //p 태그 생성 -> <p></p>
    //태그를 자바스크립트에서 처리할 수 있는 객체형태로 생성 후 저장
    //2. 텍스트 노드 생성
    const text = document.createTextNode("안녕");    //안녕이라는 문자열을 텍스트노드 형태로 생성

    /*
    <p></p>
    안녕

    -> <p>안녕</p>
    node1.apeendChild(node2) : node1의 마지막 자식으로 node2를 추가
    */

    p.appendChild(text);    //p태그의 마지막 자식으로 안녕이라는 글씨를 추가 -> <p>안녕</p>

    //문서에서 이미 작성된 태그를 가져오는 방법(아이디)
    //문서에서 아이디가 add-zone 인 태그를 가지고 와서 변수에 저장
    const addzone = document.getElementById("add-zone");    //<div id = "add-zone"></div>
    /*
    <div id = "add-zone">
        <p>안녕</p>
    </div>
    */

    addzone.appendChild(p);
}

function func2(){
    //<img src = "img/dora.png">를 생성해서 add-zone div 에 추가
    //노드 : <img> 요소노드만 존재
    //1.img 태그 생성
    const img = document.createElement("img"); //<img>
    //2. img 태그의 src 속성값을 img/dora.png로 변경
    img.src = "img/dora.png"; //<img src = "img/dora.png">
    //3. id 가 add-zone 인 div를 문서에서 가져옴
    const addzone = document.getElementById("add-zone");
    //4. add-zone 에 자식으로 img태그를 추가함.
    addzone.appendChild(img);
}


//first.
function func3(){
    /*
        <ul>
            <li><a href = "#">메뉴1></a></li>
            <li><a href = "#">메뉴1></a></li>
            <li><a href = "#">메뉴1></a></li>
        </ul>

        태그를 생성해서 id가 test-zone인 div에 자식으로 추가
    */

        const ul = document.createElement("ul");
        const li1 = document.createElement("li");
        const li2 = document.createElement("li");
        const li3 = document.createElement("li");
        const a1 = document.createElement("a");
        const a2 = document.createElement("a");
        const a3 = document.createElement("a");
        const text1 = document.createTextNode("메뉴1");
        const text2 = document.createTextNode("메뉴2");
        const text3 = document.createTextNode("메뉴3");
        ul.appendChild(li1);
        ul.appendChild(li2);
        ul.appendChild(li3);
        li1.appendChild(a1);
        li2.appendChild(a2);
        li3.appendChild(a3);
        a1.href = "#";
        a2.href = "#";
        a3.href = "#";
        a1.appendChild(text1);
        a2.appendChild(text2);
        a3.appendChild(text3);

        const testzone = document.getElementById("test-zone");
        testzone.appendChild(ul);
}


//second
function nextFunc3() {
    /*객체 배열
    
    const menus = [
        {text : "메뉴1", url : "#"},
        {text : "메뉴2", url : "#"},
        {text : "메뉴3", url : "#"},
    ]

    */

 
    const menuTexts = ["메뉴1", "메뉴2", "메뉴3"];
    const ul = document.createElement("ul");

    menuTexts.forEach(function(menu){
        const li = document.createElement("li");
        const a = document.createElement("a");
        ul.appendChild(li);
        li.appendChild(a);
        a.href = "#";
        const text = document.createTextNode(menu);
        a.appendChild(text);
    });

    document.getElementById("test-zone").appendChild(ul);
}


function hidePw(){
    const pwInput = document.getElementById("pw");
    const hidebtn = document.getElementById("hide-btn");
    const showbtn = document.getElementById("show-btn");
    showbtn.style.display = "inline"; 
    hidebtn.style.display = "none";
    pwInput.type = "password";
}
function showPw(){
    const pwInput = document.getElementById("pw");
    const hidebtn = document.getElementById("hide-btn");
    const showbtn = document.getElementById("show-btn");
    //dom 객체.style.css속성 = "변경값";
    showbtn.style.display = "none"; //패스워드 보이는 버튼 숨기기
    hidebtn.style.display = "inline"    //패스워드 숨기는 버튼 보이기
    pwInput.type = "text";
}

function func4(){
    const h2 = document.getElementById("h2");
    //h2 태그의 글씨 색 / 배경 색 변경
    //dom 객체의 일반 속성 변경 -> 객체 이름, 속성 이름 = 변경할 값;
    //css 관련 속성 -> 객체이름.style.css속성이름 = 변경할값;
    h2.style.color = "red";
    //적용하려는 css 속성은 스네이크표기 -> 카멜표기
    h2.style.backgroundColor = "yellow";
}
function func5(){
    //const delDiv = document.getElementById("del-div3");
    const delDiv = document.querySelector("#del-div3");
    //dom객체.remove();
    //delDiv.remove();
    delDiv.style.display = "none";
}
function func6(){
    //이미 문서에 있는 요소를 선택하는 방법 -> css 선택자로 선택
    //1. document.querySelector("css선택자")
    //  -> 해당선택자에 해당하는 요소를 1개 가져옴 (동일한 선택자인 요소가 여러개인 경우 ->제일 먼저 작성된 것 1개만)
    //2. document.querySelectorAll("css선택자");
    //  -> 해당 선택자에 해당하는 요소를 모두 배열 형태로 가져옴. -> 길이가 1인 배열
    const divs = document.querySelectorAll(".del-div");
    divs.forEach(function(item){
        item.remove();
    });
}
function funcExam(){
    const deldiv5 = document.querySelector("#del-div5");
    deldiv5.remove();
}
function func7(){
    const btn = document.querySelector("#btn");
    //이벤트 속성을 설정할 때는 반드시 함수형태를 대입함.
    btn.onclick = function(){
        const deldiv5 = document.querySelector("#del-div5");
        deldiv5.remove();
    }
}

function func8(){
    const btn = document.querySelector("#btn");
    btn.onclick = null;
}

