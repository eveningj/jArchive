<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ID로 회원조회</h1>
	<hr>
	<form action="/jsp/searchMember.jsp" method = "get">
		<div>
			<label for = "memberId">조회 할 회원 아이디</label>
			<input type = "text" name = "memberId" id = "memberId">
			<input type = "submit" value = "조회">
		</div>
	</form>
	<a href='/'>메인페이지로 이동</a>
</body>
</body>
</html>