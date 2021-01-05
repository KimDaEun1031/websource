<%@page import="domain.UserVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO vo = (UserVO)request.getAttribute("vo");
%>
<%@include file="header.jsp" %>
<div class="container">
<form action="updatePro.jsp" method="post">
<div class="form-group">
    <label for="no">번호</label>
    <input type="text" class="form-control" name="no" id="no" value="<%=vo.getNo() %>" readonly>
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" name="username" id="username" value="<%=vo.getUsername() %>" readonly>
  </div>
  <div class="form-group">
    <label for="birthYEAR">생년월일</label>
    <input type="text" class="form-control" name="birthYEAR" id="birthYEAR" value="<%=vo.getBirthYEAR() %>" readonly>
  </div>
  <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" name="addr" id="addr" placeholder="변경 주소를 입력하세요." required>
  </div>
  <div class="form-group">
    <label for="mobile">전화번호</label>
    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="변경 휴대폰 번호를 입력하세요." required>
  </div>
  <div class="form-group">
   	<button type="submit" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-secondary">취소</button>
  </div>
</form>
</div>
</body>
</html>