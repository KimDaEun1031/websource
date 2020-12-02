<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int age1 = 10;
	%>
	<%@include file="footer.jsp" %>
	<!-- 가져온 jsp 파일 안에 자바코드를 쓸 때 중복 변수 값이 들어가 있다면 컴파일 되지 않음
		그러니 그것만 주의할 것 -->
</body>
</html>