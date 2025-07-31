<%@page import="kr.co.iei.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		MemberService memberService = new MemberService();
		int result = memberService.deletehMember(memberId);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE</title>
</head>
<body>
		<h1>회원 삭제</h1><hr>
		<% if(result>0) {  %>
			<h3>회원삭제 완료!</h3>
			<hr>
		<% }else {  %>
			<h3>회원삭제 실패..</h3>
			<hr>
		<% } %>
		<a href='/'>메인페이지로 이동</a>
</body>
</html>