package member;

import lombok.Data;

@Data
// get/set, equals, default constructor, hashcode, tostring�� �ٰ����� �ִ� ������ü

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
