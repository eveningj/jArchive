<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디로 회원조회</h1>
	<hr>
	<form action="/selectMemberId" method="get">
		<div>
			<label for="memberId">조회 할 아이디 : </label>
			<input type="text" name="memberId" id="memberId">
			<input type="submit" value="조회">
		</div>
	</form>
</body>
</html>