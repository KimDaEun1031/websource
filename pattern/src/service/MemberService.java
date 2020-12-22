package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {
	//dao와 연동 - c(insert)r(select)u(update)d(delete)
	//근데 왜 boolean?
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
}
