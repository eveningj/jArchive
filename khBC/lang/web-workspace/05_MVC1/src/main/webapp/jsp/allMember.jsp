<%@page import="kr.co.iei.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.iei.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		//Scriptlet : Java Code
		//1. Encode
		request.setCharacterEncoding("utf-8");
		//2. 값 추출
		//3. 비즈니스 로직
		MemberService memberService = new MemberService();
		ArrayList<Member> list = memberService.selectAllMember();
		//4. 결과 처리
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체회원 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원비밀번호</th>
			<th>회원이름</th>
			<th>회원전화번호</th>
			<th>회원주소</th>
			<th>회원등급</th>
			<th>회원가입일</th>
			<th>삭제</th>
	<%
		for(int i = 0; i<list.size();i++){
			Member m = list.get(i);			
	%>
	<tr>
		<td><%=m.getMemberNo() %></td>
		<td><a href = "/jsp/updateFrm.jsp?memberId=<%=m.getMemberId() %>">
			<%=m.getMemberId() %>
		</a></td>
		<td><%=m.getMemberPw() %></td>
		<td><%=m.getMemberName() %></td>
		<td><%=m.getMemberPhone() %></td>
		<td><%=m.getMemberAddr() %></td>
		<td>
			<%if(m.getMemberLevel() == 1) { %>
				관리자
			<%}else if(m.getMemberLevel() == 2) { %>
				정회원
			<%}else if(m.getMemberLevel() == 3) { %>
				준회원
			<%} %>
		</td>
		<td><%=m.getEnrollDate() %></td>
		<td> 
			<a href='/jsp/deleteMember.jsp?memberId=<%= m.getMemberId() %>'
     		onclick="return confirm('정말 삭제하시겠습니까?');">삭제
  			</a>
  		</td>
	</tr>
	<%} %>
	</table>
	<a href = "/">메인페이지로 이동</a>
</body>
</html>