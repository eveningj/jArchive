<%@page import="kr.co.iei.model.service.MemberService"%>
<%@page import="kr.co.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2. 값 추출
    	int memberNo = Integer.parseInt(request.getParameter("memberNo"));
    	String memberId = request.getParameter("memberId");
    	String memberPw = request.getParameter("memberPw");
    	String memberPhone = request.getParameter("memberPhone");
    	String memberAddr = request.getParameter("memberAddr");
    	//3. 비즈니스 로직
    	Member m = new Member();
    	m.setMemberAddr(memberAddr);
    	m.setMemberId(memberId);
    	m.setMemberNo(memberNo);
    	m.setMemberPhone(memberPhone);
    	m.setMemberPw(memberPw);
    	MemberService memberService = new MemberService();
    	int result = memberService.updateMember(m);
    	
    	//4. 결과 처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 결과</h1>
	<hr>
	<%if(result > 0) { %>
	<h3> 회원정보 수정 성공 !</h3>
	<%} else { %>
	<h3> 회원 정보 수정 실패</h3>
	<%} %>
	<a href = "/">메인페이지로 이동</a>
</body>
</html>