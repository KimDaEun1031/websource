<%@page import="domain.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="container">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">생년월일</th>
      <th scope="col">주소</th>
      <th scope="col">전화번호</th>
    </tr>
  </thead>
<tbody>
<%
	UserDAO dao = new UserDAO();
	List<UserVO> list =dao.select();
	/*
	if(list.isEmpty()){
		
	}
	*/
	for(UserVO vo:list){
%>
   <tr>
      <td><%=vo.getNo() %></td>
      <td><a href="select.jsp?no=<%=vo.getNo() %>&username=<%=vo.getUsername() %>"><%=vo.getUsername() %></a></td>     
      <td><%=vo.getBirthYEAR() %></td>
      <td><%=vo.getAddr() %></td>
      <td><%=vo.getMobile() %></td>
   </tr>
<%
	}

%>

  </tbody>
</table>
</div>
</body>
</html>