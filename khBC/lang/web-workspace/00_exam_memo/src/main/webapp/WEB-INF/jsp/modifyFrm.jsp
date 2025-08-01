<%@page import="jw.exam.memo.model.vo.Memo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Memo m = (Memo)request.getAttribute("modifyMemo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
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
						<input type="hidden" name="memoId" id="memoId" value = "<%= m.getMemoId()%>" >
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoTitle">제목</label>
					</th>
					<td>
						<input type="text" name="memoTitle" id="memoTitle" value = "<%= m.getMemoTitle()%>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoWriter">작성자</label>
					</th>
					<td>
						<input type="text" name="memoWriter" id="memoWriter" value = "<%= m.getMemoWriter()%>" disabled>
					</td>
				</tr>
				<tr>
					<th>
						<label for="writeDate">작성일</label>
					</th>
					<td>
						<input type="text" name="writeDate" id="writeDate" value = "<%= m.getWriteDate()%>" disabled>
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoContent">내용</label>
					</th>
					<td>
						<input type="text" name="memoContent" id="memoContent" value = "<%= m.getMemoContent()%>">
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">
						<input type="submit" value="수정하기">	
					</th>
				</tr>
			</table>
		</div>
	</form>
	<a href = "/">메인으로</a>
</body>
</html>