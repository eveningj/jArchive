const tabs = document.querySelectorAll(".tab>div");
const contents = document.querySelectorAll(".tab-content>div");

tabs.forEach(function(item,i){
    item.addEventListener("click",function(){
        for (let i = 0; i<tabs.length; i++){
            tabs[i].classList.remove("active-tab")
            contents[i].classList.remove("active-content");
        }
        item.classList.add("active-tab");
        contents[i].classList.add("active-content");
    });  
});

tabs[0].classList.add("active-tab");
contents[0].classList.add("active-content");