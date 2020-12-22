package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {
	//dao�� ���� - c(insert)r(select)u(update)d(delete)
	//�ٵ� �� boolean?
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
}
