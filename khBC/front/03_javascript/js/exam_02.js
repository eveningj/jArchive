const title = document.querySelector("#title");
const date = document.querySelector("#date");
const writer = document.querySelector("#writer");
const titleBox = document.querySelector("#titleBox");
const dateBox = document.querySelector("#dateBox");
const writerBox = document.querySelector("#writerBox");

title.onclick = function () {
    const tChecked = title.checked;
if(tChecked){    
    titleBox.style.display = "block";
    dateBox.style.display = "none";
    writerBox.style.display = "none";
}
}

date.onclick = function () {
    const dChecked = date.checked;
if(dChecked){    
    titleBox.style.display = "none";
    dateBox.style.display = "block";
    writerBox.style.display = "none";
}
}

writer.onclick = function () {
    const wChecked = writer.checked;
if(wChecked){    
    titleBox.style.display = "none";
    dateBox.style.display = "none";
    writerBox.style.display = "block";
}
}

/* const radio = documnet.querySelectorAll("[name=search");
const searchBox = document.querySelectorAll(".searchBox")
*/