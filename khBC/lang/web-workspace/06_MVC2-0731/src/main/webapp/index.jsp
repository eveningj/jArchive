<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MVC2</h1>
	<hr>
	<%--
		전체회원 조회
		1. DB 작업 -> O
		2. QUERY -> SELECT * FROM MEMBER_TBL ORDER BY 1
		3.-2. 사용자에게 입력받을 데이터가 없음 -> Controller 호출(MVC2 구조에서는 Servlet)
	 --%>
	<h3><a href = "/allMember">1. 전체 회원 조회 </a></h3>
	<%--
		회원가입
		1. DB 작업 -> O
		2. QUERY  -> QUERY : INSERTO INTO MEMBERTBL VALUES(MEMBER_SEQ.NEXTVAL,?,?,?,?,?,3,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
		3-1. 사용자에게 입력받을 데이터 -> 아이디, 비밀번호, 전화번호, 주소
	 --%>
	 <h3><a href = "/jsp/joinFrm.jsp">2. 회원가입</a></h3>
</body>
</html>