<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변글 쓰기 화면</title>
</head>
<body>
<h1>답변글 쓰기 화면</h1>
<form action="reply.do" method="get">
<input type="hidden" name="num" value="${replyui.num}">
<input type="hidden" name="repRoot" value="${replyui.repRoot}">
<input type="hidden" name="repStep" value="${replyui.repStep}">
<input type="hidden" name="repIndent" value="${replyui.repIndent}">
	원글번호 : ${replyui.num}&nbsp;&nbsp;&nbsp;&nbsp;
	조회수 : ${replyui.readcnt}<br>
	
	제목 : <input type="text" name="title" value="${replyui.title}"><br>
	작성자 : <input type="text" name="author"><br>
	내용 <textarea rows="10" name="content">${replyui.content}</textarea><br>
	<input type="submit" value="답변달기">
</form>
<a href="list.do">목록 보기</a>
</body>
</html>