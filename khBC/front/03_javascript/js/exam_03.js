const divs = document.querySelectorAll(".divs")
const divArray = new Array();
divs.forEach(function(div){
    div.onclick = function(){
        let id = this.id;
        divArray.push(id);
        this.remove();
        
        if(divArray.length < 5) {
            console.log(divArray);
        }else if (divArray.length == 5) {
            for(let i =0; i<divArray.length;i++) {
                const newDiv = document.createElement("div");
                newDiv.classList.add("divs");
                newDiv.id = divArray[i];
                const divWrap = document.querySelector("#divWrap");
                divWrap.appendChild(newDiv);
            }
            /*while(divArray.length > 0){
                    let newA = divArray.shift();
                    let newID = document.querySelector("#"+newA);
                    const divWrap = document.getElementById("divWrap");
                    const divEl = document.createElement("div");
                    divWrap.appendChild(divEl);
                    divEl.id = newA;
                    divEl.classList.add("divs");
                }
            console.log("실행됨");*/
        }
    }
});

