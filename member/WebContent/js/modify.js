/**
 * 
 */
 $(function(){
	$("#modifyform").validate({
		rules:{
			current_password:{
				required:true,
				validPwd:true
			},
			new_password:{
				required:true,
				validPwd:true
			},
			confirm_password:{
				required:true,
				valiPwd:true,
				equalTo:"#new_password"
			}
		},
		messages:{
			current_password:{
				required: "현재 비밀번호를 입력해주세요.",
			},
			new_password:{
				required: "새로운 비밀번호를 입력해주세요.",
			},			
			confirm_password:{
				required: "새로운 비밀번호를 입력해주세요.",
				equalTo:"이전 비밀번호와 다릅니다."
			}
		},
		errorPlacement:function(error,element){
			$(element).closest("form")
					  .find("small[id='"+element.attr('id')+"']")
			          .append(error);
		},
		success: function(label) {
			var name = label.attr('for');
			label.text(name+ ' is ok!');
		}
	});
})
$.validator.addMethod("validPwd",function(value){
	var regPwd = /(?=.*[A-Za-z])(?=.*\d)(?=.*!@#$%^&*)[A-Za-z\d!@#$%^&*]{8,15}$/;
	return regPwd.test(value);
},	"비밀번호를 확인해 주세요.");