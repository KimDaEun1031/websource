<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	
	//세션 영역에 값 담기 => 로그인이라면 아이디와 비밀번호, 이름을 담음
	/*
	session.setAttribute("userid", userid);
	session.setAttribute("userpwd", userpwd);
	*/
	LoginDTO login = new LoginDTO(userid,userpwd);
	session.setAttribute("login", login);
	
	response.sendRedirect("../index.jsp");
	
%>