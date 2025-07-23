document.querySelectorAll(".heart").forEach(function (heart) {
	heart.addEventListener("click", function () {
		if (this.innerText === "favorite_border") {
			this.innerText = "favorite";
		} else {
			this.innerText = "favorite_border";
		}
	});
});

document.querySelectorAll(".img-wrap img").forEach(function (img) {
	img.style.cursor = "pointer";
	img.addEventListener("click", function () {
		location.href = "#";
	});
});