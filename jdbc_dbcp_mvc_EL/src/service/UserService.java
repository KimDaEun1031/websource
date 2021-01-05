package service;

import java.util.List;

import domain.UserVO;

public interface UserService {
	//crud���񽺸� �� �� �ֵ��� �޼ҵ� ����
	public boolean insertUser(String username, String birthYEAR, String addr, String mobile);
	public boolean updateUser(int no, String addr, String mobile);
	public boolean deleteUser(int no);
	
	public UserVO getUser(int no);
	public List<UserVO> getUserlList();
	
}
