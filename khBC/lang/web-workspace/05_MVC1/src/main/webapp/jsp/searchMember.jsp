<%@page import="kr.co.iei.model.service.MemberService"%>
<%@page import="kr.co.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		//1. Encode
		request.setCharacterEncoding("utf-8");
		//2. 값 추출
		String memberId = request.getParameter("memberId");
		//3. 비즈니스 로직
		MemberService memberService = new MemberService();
		Member m = memberService.searchMemberId(memberId);
		//4. 결과 처리
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디로 회원조회</h1>
	<hr>
		
		<% if (m == null) {%>
			<h3>회원정보 조회 실패! (그런 회원 없음)</h3>
		<%}else {  %>
			<span>회원번호 : <%= m.getMemberNo() %> </span><br>
			<span>회원아이디 : <%=  m.getMemberId() %> </span><br>
			<span>회원비밀번호: <%= m.getMemberPw() %>  </span><br>
			<span>회원이름: <%= m.getMemberName() %>  </span><br>
			<span>회원전화번호: <%= m.getMemberPhone() %>  </span><br>
			<span>회원주소: <%= m.getMemberAddr()%>  </span><br>
			
			<%switch (m.getMemberLevel()) {
				case 1 :  %> <span>회원등급 : 관리자</span><br>
				<% break;
				case 2 : %> <span>회원등급 : 정회원</span><br>
				<%break;
				case 3 :  %> <span>회원등급 : 준회원</span><br>
				<%break;
				} %>
			<span>회원가입일: <%= m.getEnrollDate() %></span><br>
					
			<% }%>
		<a href='/'>메인페이지로 이동</a>
</body>
</html>