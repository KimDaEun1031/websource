<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>response1.jsp</h1>
 <% 
 	//페이지 전환
 	response.sendRedirect("send.jsp");
 
 %>
 <!-- <h3>response 객체</h3> 사실상 얘는 안 쓰임 -->
</body>
</html>