<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 작성-jw</title>
</head>
<body>
	<h1>메모 작성</h1>
	<hr>
	<form action="/insertMemo" method="post">
		<div>
			<table>
				<tr>
					<th>
						<label for="memoTitle">제목</label>
					</th>
					<td>
						<input type="text" name="memoTitle" id="memoTitle">
					</td>
					
				</tr>
				<tr>
					<th>
						<label for="memoWriter">작성자</label>
					</th>
					<td>
						<input type="text" name="memoWriter" id="memoWriter">
					</td>
				</tr>
				<tr>
					<th>
						<label for="memoContent">내용</label>
					</th>
					<td>
						<input type="text" name="memoContent" id="memoContent">
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">
						<input type="submit" value="작성하기">	
					</th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>