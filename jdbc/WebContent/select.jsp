<%@page import="domain.UserVO"%>
<%@page import="persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//index.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	String username = request.getParameter("username");
	
	UserDAO dao = new UserDAO();
	UserVO vo = dao.getUser(no);
%>
<%@include file="header.jsp" %>
<div class="container">
<form action="" method="post">
<div class="form-group">
    <label for="no">번호</label>
    <input type="text" class="form-control" name="no" id="no" readonly value="<%=vo.getNo()%>">
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" name="username" id="username" readonly value="<%=vo.getUsername()%>">
  </div>
  <div class="form-group">
   	<button type="submit" class="btn btn-primary">수정</button>
	<button type="reset" class="btn btn-danger">삭제</button>
  </div>
</form>
</div>
<%


%>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	$(function(){
		let form = $("form");
		//수정버튼을 클릭하면 update.jsp로 이동
		$(".btn-primary").click(function(){
			$(form).attr("action","update.jsp");
			$(form).submit();
		})
		//삭제버튼을 클릭하면 deletePro.jsp로 이동
		$(".btn-danger").click(function(){
			$(form).attr("action","deletePro.jsp");
			$(form).submit();
		})
	})
	
</script>
</html>