<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MVC1 - ###</h1>
	<hr>
	<%-- JSP 주석 --%>
	<%--
		전체 회원 조회
		1. DB 작업 필요
		2. QUERY : SELECT * FROM MEMBER_TBL ORDER BY 1
		3.
			3-2 사용자에게 입력받을 값 없음 -> Controller 호출
			(MVC1 에서 Controller 는 JSP 가 담당)
	 --%>
	 <h3><a href = "/jsp/allMember.jsp">1. 전체 회원 조회</a></h3>
	 <%--
	 	회원가입
	 	1. DB 작업 O
	 	2. QUERY : INSERT INTO MEMBER_TBL VALUES (MEMBER_SEQ.NEXTVAL,?,?,?,?,?,3,
	 	TO_CHAR(SYSDATE, 'YYYY-MM-DD'));
	 	3-1. 사용자에게 입려받을 값 -> 아이디, 비밀번호, 이름, 전화번호, 주소
	 		-> 입력받을 양식 페이지로 이동 (MVC1 에서는 일반 화면 페이지도 JSP가 담당)
	 		
	  --%>
	  <h3><a href = "/jsp/joinFrm.jsp">2. 회원가입</a></h3>
	  <%--
	  	아이디로 회원조회 / 회원삭제 구현
	   --%>
	   <h3><a href = "/jsp/searchMemberFrm.jsp">3. 회원조회</a></h3>
	   <h3><a href = "/jsp/deleteMemberFrm.jsp">4. 회원삭제</a></h3>
</body>
</html>