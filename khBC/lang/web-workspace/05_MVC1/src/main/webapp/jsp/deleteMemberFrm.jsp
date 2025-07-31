<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function confirmDelete() {
		const memberId = document.getElementById("memberId").value.trim();
		if (memberId === "") {
			alert("삭제할 회원 아이디를 입력하세요.");
			return false;
		}
		return confirm("정말로 회원을 삭제하시겠습니까?");
	}
</script>
</head>
<body>
	<h1>회원삭제</h1>
	<hr>
	<form action="/jsp/deleteMember.jsp" method = "get" onsubmit="return confirmDelete()">
		<div>
			<label for = "memberId">삭제할 회원 아이디</label>
			<input type = "text" name = "memberId" id = "memberId">
			<input type = "submit" value = "삭제">
		</div>
	</form>
	<a href='/'>메인페이지로 이동</a>
</body>
</html>