package member;

import lombok.Data;

@Data
// get/set, equals, default constructor, hashcode, tostring을 다가지고 있는 상위개체

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
