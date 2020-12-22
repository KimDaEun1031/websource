<%@page import="persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//select.jsp에서 넘긴 값 가져오기
	int no = Integer.parseInt(request.getParameter("no"));
	
	UserDAO dao = new UserDAO();
	
	int result = dao.delete(no);
	
	if(result>0){
		response.sendRedirect("index.jsp");
	}else{
		response.sendRedirect("select.jsp");
	}
%>