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
				//생성 후 전송
				pstmt = con.prepareStatement(sql);
				//? 에 해당하는 값을 set 하기
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(birthYEAR));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);				
				//구문 실행 후 결과 받기
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
	//전체 조회
	public List<UserVO> select() {
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {
			if (con != null) {
			      String sql = "select * from userTBL order by no desc";
			      //5.Statment 생성 후 전송 : DB연결을 통해 sql문을 수행해 주는 클래스
			      pstmt = con.prepareStatement(sql);
			      //6.sql 구문 실행 하고 결과 받기
			      //select : executeQuery() => ResultSet,
			      //insert, update, delete : executeUpdate() => int
			      rs = pstmt.executeQuery();
			 while (rs.next()) {
				 //바구니 만들기 UserVO
				 UserVO vo = new UserVO();
				 
		         vo.setNo(rs.getInt(1));//no(number타입 : int)
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
				//생성 후 전송
				pstmt = con.prepareStatement(sql);
				//? 에 해당하는 값을 set 하기
				pstmt.setString(1, addr);
				pstmt.setString(2, mobile);
				pstmt.setInt(3, no);
				//구문 실행 후 결과 받기
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
			//no에 해당하는 user 삭제
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
