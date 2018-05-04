<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
</style>
</head>
<body>
<h3>${title }</h3>
<hr>
<!-- valid를 쓰기위해 form:태그 이용하고 name을 path로 변경,commandName을 지정 -->
<!-- errors 이용하여 에러발생, cssClass는 생략가능 - style적용하기 위한것 -->
<!-- commandName="boardCommand" 값을 저장해놨다가 뿌려주는 용도 -->
<form:form action="board_insert" method="post" commandName="boardCommand">
	작성자 : <form:input type="text" path="writer"/>
		<form:errors path="writer" cssClass="error"/>
	<br>	
	제목 : <form:input type="text" path="title"/>
		<form:errors path="title" cssClass="error"/>
	<br>		
	내용 <br>
	<form:textarea rows="6" cols="70" path="contents"/>
	<br>
	<input type="submit" value="등록">
</form:form>

</body>
</html>








