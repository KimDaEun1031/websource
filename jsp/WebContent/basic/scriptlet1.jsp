<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//스트립틀릿 : 자바코드 사용, 메소드 안에 선언하는 방식과 동일하게 사용
	int totla = 0;
	
	for(int i=1;i<=100;i++) {
		totla += i;
	}
	/*out.print(totla);*/
%>
<%=totla%>