const addBtn = document.querySelector("#add-btn");
const input = document.querySelector(".input-box>input");

addBtn.addEventListener("click",function(){
    todoAdd();
});

input.addEventListener("keyup",function(e){
    if(e.keyCode === 13){
        todoAdd();
    }
});

function todoAdd(){
    const inputValue = input.value;
    if(inputValue === "") {
        return;
    }
    const ul = document.createElement("ul");
    ul.classList.add("todo");

    const likeLi = document.createElement("li");
    likeLi.classList.add("todo-like");

    const textLi = document.createElement("li");
    textLi.classList.add("todo-text");
    textLi.innerText = inputValue;

    const checkLi = document.createElement("li");
    checkLi.classList.add("todo-check");

    const likeSpan = document.createElement("span");
    likeSpan.classList.add("material-icons");
    likeSpan.innerText = "thumb_up_off_alt";

    likeSpan.addEventListener("click", function(){
        if(likeSpan.innerText === "thumb_up_off_alt"){
            likeSpan.innerText = "thumb_up";
        }else if(likeSpan.innerText === "thumb_up"){
            likeSpan.innerText = "thumb_up_off_alt";
        }
    });

    const doneSpan = document.createElement("span");
    doneSpan.classList.add("material-icons");
    doneSpan.classList.add("done-btn");
    doneSpan.innerText = "check"

    doneSpan.addEventListener("click",function(){
        doneSpan.remove();
        textLi.style.textDecoration = "line-through";
    });

    const deleteSpan = document.createElement("span");
    deleteSpan.classList.add("material-icons");
    deleteSpan.innerText = "delete";
    deleteSpan.addEventListener("click",function(){
        ul.remove();
    });

    likeLi.appendChild(likeSpan);
    checkLi.appendChild(doneSpan);
    checkLi.appendChild(deleteSpan);

    ul.appendChild(likeLi);
    ul.appendChild(textLi);
    ul.appendChild(checkLi);

    const listBox = document.querySelector(".list-box");
    listBox.appendChild(ul);

    input.value = "";
}

/*
const likeBtn = document.querySelector(".todo-like>.material-icons");
likeBtn.addEventListener("click", function(){
    if(likeBtn.innerText === "thumb_up"){
        likeBtn.innerText = "thumb_up_off_alt"
    }else if (likeBtn.innerText === "thumb_up_off_alt"){
        likeBtn.innerText = "thumb_up";
    }
});

const doneBtn = document.querySelector(".done-btn");
doneBtn.addEventListener("click",function(){
    const todoText = document.querySelector(".todo-text");
    todoText.style.textDecoration = "line-through";
    doneBtn.remove();
});

const delBtn = document.querySelector(".todo-check>span:last-child");
delBtn.addEventListener("click",function(){
    const todo = document.querySelector(".todo");
    todo.remove();
});
*/