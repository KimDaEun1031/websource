<%@page import="book.bookVO"%>
<%@page import="java.util.List"%>
<%@page import="book.bookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");

	bookDAO dao = new bookDAO();
	List<bookVO> list = dao.bookSearch(criteria, keyword);
	request.setAttribute("list", list);
	pageContext.forward("../searchAll.jsp"); //forward, include=>상대주소

%>