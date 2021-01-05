package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.UserVO;

import static persistence.JDBCUtil.*;

public class UserDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO(Connection con) {
		this.con = con;
	}
	
	//CRUD
	//INSERT
	public int insert(String username, String birthYEAR, String addr, String mobile) {
		
		int result=0;
		
		try {
			if(con!=null){
				String sql = "insert into userTBL ";
				sql += "values(userTBL_seq.nextval,?,?,?,?)";
				//���� �� ����
				pstmt = con.prepareStatement(sql);
				//? �� �ش��ϴ� ���� set �ϱ�
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(birthYEAR));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);				
				//���� ���� �� ��� �ޱ�
				result = pstmt.executeUpdate();
				}
					
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				close(pstmt);
			}
			return result;
		}
	
	//Read
	//��ü ��ȸ
	public List<UserVO> select() {
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {
			if (con != null) {
			      String sql = "select * from userTBL order by no desc";
			      //5.Statment ���� �� ���� : DB������ ���� sql���� ������ �ִ� Ŭ����
			      pstmt = con.prepareStatement(sql);
			      //6.sql ���� ���� �ϰ� ��� �ޱ�
			      //select : executeQuery() => ResultSet,
			      //insert, update, delete : executeUpdate() => int
			      rs = pstmt.executeQuery();
			 while (rs.next()) {
				 //�ٱ��� ����� UserVO
				 UserVO vo = new UserVO();
				 
		         vo.setNo(rs.getInt(1));//no(numberŸ�� : int)
		         vo.setUsername(rs.getString(2)); //username(nchar)
		         vo.setBirthYEAR(rs.getInt(3)); //birthYear(number)
		         vo.setAddr(rs.getString(4)); //addr(nchar)
		         vo.setMobile(rs.getString(5)); //mobile(nvachar2)
		         list.add(vo);
		         
		     }//while
		   }//if
			} catch (Exception e) {
			   e.printStackTrace();
			} finally{
				close(rs);
				close(pstmt);	
			}
		return list;
	}
	
	public UserVO getUser(int no) {
		UserVO vo = null;
		try{
			if(con!=null){
				String sql ="select * from userTBL where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,no);
				
				rs = pstmt.executeQuery();
				if(rs.next()){
					 vo = new UserVO();
					 vo.setNo(rs.getInt("no"));
					 vo.setUsername(rs.getString("username"));
					 vo.setAddr(rs.getString("addr"));
					 vo.setBirthYEAR(rs.getInt("birthYEAR"));
					 vo.setMobile(rs.getString("mobile"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return vo;
		
	}
	
	public int update(String addr, String mobile, int no) {
		int result=0;
			
		try{
			if(con!=null){
				String sql = "update userTBL set addr=?, mobile=? where no=?";
				//���� �� ����
				pstmt = con.prepareStatement(sql);
				//? �� �ش��ϴ� ���� set �ϱ�
				pstmt.setString(1, addr);
				pstmt.setString(2, mobile);
				pstmt.setInt(3, no);
				//���� ���� �� ��� �ޱ�
				result = pstmt.executeUpdate();
				
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
	
	public int delete(int no) {
	
		int result =0;
		
		try{
			//no�� �ش��ϴ� user ����
			if(con!=null){
				String sql ="delete from userTBL where no=?";
				pstmt = con.prepareStatement(sql);	
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
		
}
