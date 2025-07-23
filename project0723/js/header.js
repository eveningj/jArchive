const logo = document.getElementById("logo");
logo.addEventListener("click", function () {
    window.location.href = "main.html";
});

const searchInput = document.querySelector(".search-box input");
const searchBtn = document.querySelector(".search-box span.material-icons-outlined");
const query = searchInput.value;

searchBtn.addEventListener("click", function () {
    window.location.href = "?query=" + encodeURIComponent(query);
    query = "";
});

searchInput.addEventListener("keydown", function (e) {
    if (e.keyCode === 13) {
    window.location.href = "?query=" + encodeURIComponent(query);
    query = "";
}
});


const memberIcons = document.querySelectorAll(".member-box .material-icons-outlined");
const  memberLinks = document.querySelectorAll(".member-box a");
const pages = ["a.html", "b.html", "c.html"];

for (let i = 0; i < pages.length; i++) {
  memberIcons[i].addEventListener("click", function () {
    window.location.href = pages[i];
  });
  memberLinks[i].addEventListener("click", function (e) {
    window.location.href = pages[i];
  });
}