<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	String pwc = request.getParameter("passwordcheck");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<h3>회원 가입 완료</h3>
	
	<%
	   out.print("<ul><li>아이디 :"+id+"</li>");
	   out.print("<li>비밀번호 :"+pw+"</li>");
	   out.print("<li>비밀번호 :"+pwc+"</li>");
	   out.print("<li>성함 :"+name+"</li>");
	   out.print("<li>성별 :"+gender+"</li>");
	   out.print("<li>이메일 :"+email+"</li></ul>");
	%>
</body>
</html>