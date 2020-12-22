<%@page import="persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	UserDAO dao = new UserDAO();
	
	int result = dao.update(addr, mobile, no);
	
	//결과에 따라 페이지 이동
	if(result>0) {
		response.sendRedirect("index.jsp"); //성공시
	}
%>