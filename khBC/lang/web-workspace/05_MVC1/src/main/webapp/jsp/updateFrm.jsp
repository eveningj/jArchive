<%@page import="kr.co.iei.model.service.MemberService"%>
<%@page import="kr.co.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1. 인코딩
    	request.setCharacterEncoding("utf-8");
    	//2. 값 추출
    	String memberId = request.getParameter("memberId");
    	//3. 비즈니스 로직
    	MemberService memberService = new MemberService();
    	Member m = memberService.searchMemberId(memberId);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정이라우</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<hr>
	<form action = "/jsp/update.jsp" method = "post">
		<div>
			<label for = "memberNo">회원번호 : <%=m.getMemberNo() %></label>
			<input type = "hidden" name = "memberNo" id = "memberNo" value ="<%=m.getMemberNo() %>">
		</div>
		<div>
			<label for = "memberId">아이디</label>
			<input type = "text" name = "memberId" id = "memberId" value ="<%=m.getMemberId() %>" disabled>
		</div>
		<div>
			<label for = "memberPw">비밀번호</label>
			<input type = "password" name = "memberPw" id = "memberPw" value ="<%=m.getMemberPw() %>">
		</div>
		<div>
			<label for = "memberPhone">전화번호</label>
			<input type = "text" name = "memberPhone" id = "memberPhone" value ="<%=m.getMemberPhone() %>">
		</div>
		<div>
			<label for = "memberAddr">주소</label>
			<input type = "text" name = "memberAddr" id = "memberAddr" value ="<%=m.getMemberAddr() %>">
		</div>
	<div>
		<input type = "submit" value = "수정하기">
	</div>	
	</form>
	<a href = "/">메인으로</a>
</body>
</html>