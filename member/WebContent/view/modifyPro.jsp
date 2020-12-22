<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String current_pw = request.getParameter("current_password");
	String new_pw = request.getParameter("new_password");
	String confirm_pw = request.getParameter("confirm_password");
	//db작업
	//1. 현재 비밀번호가 일치하는지 확인 => isLogin(userid,password)
	MemberDAO dao = new MemberDAO();
	
	MemberVO vo = (MemberVO)session.getAttribute("login");
	MemberVO info =dao.isLogin(vo.getUserid(), current_pw);
	
	//2. 일치한다면 변경/세션해제/로그인 페이지로 돌려보내기 => 새로운 매소드
	if(info!=null){
		int result = dao.isModify(new_pw, vo.getUserid());
		if(result > 0) {
			session.invalidate();
			response.sendRedirect("loginForm.jsp");
		}
	} else { //3. 일치하지 않는다면 비밀번호 변경 페이지로 돌려보내기
		response.sendRedirect("modifyForm.jsp");
	}
	

%>