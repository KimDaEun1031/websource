<%@page import="book.bookVO"%>
<%@page import="java.util.List"%>
<%@page import="book.bookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//도서 목록 보기 메뉴를 클릭하면 보여줄 내용 처리
	bookDAO dao = new bookDAO();
	List<bookVO> list = dao.getList();
	request.setAttribute("list", list);
	pageContext.forward("../select.jsp");
	
%>