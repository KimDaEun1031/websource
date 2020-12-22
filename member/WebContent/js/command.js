/**
 * 버튼 클릭 이벤트
 */
$(function(){
	//로그아웃 버튼 클릭 시 logoutPro.jsp로 이동
	$("#logout").click(function(){
		location.href='logoutPro.jsp';
	});
	//비밀번호 수정 버튼 클릭시 modifyForm.jsp로 이동
	$("#modify").click(function(){
		location.href='modifyForm.jsp';
	});
	$("#leave").click(function(){
		location.href='leaveForm.jsp';
	});
})