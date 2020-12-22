<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	//add.jsp에서 사용자 입력값 가져오기
 	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String birthYEAR = request.getParameter("birthYEAR");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	//jdbc => 이것을 간단하게 하기 위한 framework를 나중에 더 많이 쓰지만
	//어차피 framework 안도 jdbc로 구성되어있기 때문에 기본은 확실하게!
	
	//UserDAO 객체 생성 - DB 작업 시키기
	UserDAO userdao = new UserDAO();
	int result = userdao.insert(username, birthYEAR, addr, mobile);
	
	//결과에 따라 페이지 이동
	if(result>0) {
		response.sendRedirect("index.jsp"); //성공시
	}else{
		response.sendRedirect("add.jsp"); //실패시
	}
%>