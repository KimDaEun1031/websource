package service;

import java.sql.Connection;
import java.util.List;

import domain.UserVO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserServiceImpl implements UserService {
	
	Connection con;
	UserDAO dao;
	
	public UserServiceImpl() {
		con = getConnection();
		dao = new UserDAO(con);
	}

	@Override
	public boolean insertUser(String username, String birthYEAR, String addr, String mobile) {
		//UserDAO ��ü ���� - DB �۾� ��Ű��
		int result = dao.insert(username, birthYEAR, addr, mobile);
		
		//db�۾� ����� action���� ������ - commit,rollback
		boolean insertFlag = false;
		if(result>0) {
			insertFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateUser(int no, String addr, String mobile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVO getUser(int no) {
		UserVO vo = dao.getUser(no);
		close(con);
		return vo;
	}

	@Override
	public List<UserVO> getUserlList() {
		List<UserVO> list = dao.select();
		close(con);
		return list;
	}

}
