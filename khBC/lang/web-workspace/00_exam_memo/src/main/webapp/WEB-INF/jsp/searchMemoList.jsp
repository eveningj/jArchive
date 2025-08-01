<%@page import="jw.exam.memo.model.vo.Memo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	ArrayList<Memo> memoList = (ArrayList<Memo>)request.getAttribute("searchMemoList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메모 목록</h1>
	<a href = "writeFrm">메모 작성하기</a>
	<br>
	<form action = "/searchMemo" method = "get">
		<div>
			<input type = "text" name = "memoWriter" id = "memoWriter" value = "작성자를 입력하세요">
			<input type = "submit" value = "조회">
		</div>
	</form>
	<table>
		<tr>
			<th>메모번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%for(Memo m : memoList) {%>
		<tr>
			<td><%=m.getMemoId() %></td>
			<td><%=m.getMemoTitle() %></td>
			<td><%=m.getMemoWriter() %></td>
			<td><%=m.getWriteDate() %></td>
			<%} %>
	</table>
	<a href = "/">메인 페이지로</a>
</body>
</html>