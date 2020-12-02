<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 영역 속성에 값 담기 => setAttribute (session.setAttribute / reqeust.setAttribute)
	// 영역 속성에 있는 값 가져오기 => getAttribute (session.getAttribute / reqeust.getAttribute)
	// 영역 속성에 있는 값 제거하기 => removeAttribute (session.removeAttribute / reqeust.removeAttribute)
	// 모두제거 => invalidate (session.invalidate)
	
	//세션 확인
	
	String name;
	Enumeration<String> e = session.getAttributeNames();
	
	while(e.hasMoreElements()) {
		name=e.nextElement();
		if(name!=null) {
			out.print("<h1>저장 세션 확인 : "+name+"</h1>");
		}
	}
	/*
	if(session.getAttribute("name")!=null) {
		name = (String)session.getAttribute("name");
	} else {
		name = "세션 값 없음";
	} 
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTest</title>
</head>
<body>
	<%-- <h1>세션 값 : <%=name %></h1> --%>
	<h1>세션 테스트</h1>
	<button type="button" onclick="set()">세션 값 저장</button>
	<button type="button" onclick="location.href = 'sessionRemove.jsp'">세션 값 삭제</button>
	<button type="button" onclick="location.href = 'sessionInvalidate.jsp'">세션 값 초기화</button>
	<script>
		function set() {
			location.href = 'sessionSet.jsp'
		}
	</script>
</body>
</html>