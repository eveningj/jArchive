<%@page import="jw.exam.memo.model.vo.Memo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Memo m = (Memo)request.getAttribute("getMemo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<style>
	div{
		margin-bottom : 10px;
	}
	table{
		border-spacing: 0;
		border-top : 2px solid #000;
	}
	table th{
		text-align: center;
		background-color : #eee;
	}
	table th, table td{
		padding : 5px 40px;
		border-bottom : 1px solid #ccc;
	}
</style>
</head>
<body>
	<h1>메모 수정</h1>
	<hr>
	<form action="/modifyMemo" method="post">
		<div>
			<table>
				<tr>
					<th>
						<label for="memoId">메모번호</label>
					</th>
					<td>
						<span><%= m.getMemoId() %></span>
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoTitle">제목</label>
					</th>
					<td>
						<span><%= m.getMemoTitle()%></span>
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoWriter">작성자</label>
					</th>
					<td>
						<span><%= m.getMemoWriter()%></span>
					</td>
				</tr>
				<tr>
					<th>
						<label for="writeDate">작성일</label>
					</th>
					<td>
						<span><%= m.getWriteDate()%></span>
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoContent">내용</label>
					</th>
					<td>
						<span><%= m.getMemoContent()%></span>
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">
						<a href = "modifyFrm?memoId=<%=m.getMemoId()%>">수정</a>
						<a href = "deleteMemo?memoId=<%=m.getMemoId()%>">삭제</a>	
					</th>
				</tr>
			</table>
		</div>
	</form>
	<a href = "/memoList">목록으로</a>
</body>
</html>