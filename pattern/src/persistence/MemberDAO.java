package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static persistence.JDBCUtil.*;

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//생성자
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insert(String name) {
		int result =0;
		
		try {
			pstmt=con.prepareStatement("insert into member values()");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			//이런식이 가능한 이유 - dao의 모든 메소드에 static을 넣었기에
			//원래는 jdbcutill.close(con) 이런식이여야하는데 위에서 임포트를 넣어줌
		}
		return result;
	}
	
	public int delete(String name) {
		System.out.println("memberDAO delete : "+name);
		return 1;
	}
}
