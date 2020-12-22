<%@page import="book.bookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int code = Integer.parseInt(request.getParameter("code"));

	bookDAO dao = new bookDAO();
	int result = dao.delete(code);
	
	if(result==0){ //실패시
		response.sendRedirect("../index.jsp?tab=delete");
	} else { //성공시
		response.sendRedirect("selectPro.jsp");
	}

	
%>