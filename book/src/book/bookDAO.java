package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class bookDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//db
	
	public Connection getConnection(){
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "javaDB";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}//con
	
	public int insert(int code, String title, String writer, int price) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(con!=null) {
				String sql = "insert into bookTBL(code,title,writer,price) values(?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, code);
				pstmt.setString(2, title);
				pstmt.setString(3, writer);
				pstmt.setInt(4, price);
				result = pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}//insert
	
	
	public List<bookVO> getList() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<bookVO> list = new ArrayList<>();
		try {
			String sql = "select * from bookTBL order by code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookVO vo = new bookVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//getlist
	
	
	public void search() {
		
	}
	
	public int delete(int code) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(con!=null){
				String sql = "delete from booktbl where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				result = pstmt.executeUpdate();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
		
	}//delete
	
	public int update(int price, int code) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(con!=null){
				String sql = "update booktbl set price=? where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, price);
				pstmt.setInt(2, code);
				result = pstmt.executeUpdate();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	} //update
	
	public List<bookVO> bookSearch(String criteria, String keyword) {
	      //코드가 2001 번인 책 검색
	      //select * from bookTBL where code=?;
	      //criteria = 코드 or writer
	      //작가가 홍길동 검색하기
	      //select * from bookTBL where writer='?';
//	      String sql = "select * from bookTBL where " + criteria + "= ?";
	      
	      Connection con = getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "";
	      List<bookVO> list = new ArrayList<bookVO>();
	      try {
	         if(criteria.equals("code")) {
	         sql = "select * from bookTBL where code=?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, Integer.parseInt(keyword));
	         } else {
	         sql = "select * from bookTBL where writer=?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, keyword);
	         }
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            bookVO vo = new bookVO();
	            vo.setCode(rs.getInt(1));
	            vo.setTitle(rs.getString("title"));
	            vo.setWriter(rs.getString("writer"));
	            vo.setPrice(rs.getInt("price"));
	            list.add(vo);
	            
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            rs.close();
	            pstmt.close();
	            con.close();
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      return list;
	   }
	
}
