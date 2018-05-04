<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script   src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
$(function(){		
	$.getJSON("list_json", function(data){
		//var data = responseData.list;
		alert(data);
		$.each(data, function(index, board){
			$('#result').append('<tr><td>' + board.seq + '</td>'
					+'<td>' + board.seq + '</td>'
					+'<td>' + board.title + '</td>'
					+'<td>' + board.writer + '</td>'
					+'<td>' + board.hitcount+ '</td>'
					+ '<td>' + board.regdate + '</td></tr>');
		});
	});
});

</script>

</head>
<body>
	<h3>글목록보기</h3>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>

</body>
</html>