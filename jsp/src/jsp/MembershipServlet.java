package jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MembershipServlet
 */
@WebServlet("/MembershipServlet")
public class MembershipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String pwc = request.getParameter("passwordcheck");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>회원가입 페이지</title></head>");
		out.print("<body><h3>회원 가입 완료</h3>");
		out.printf("아이디 : %s<br>비밀번호 : %s<br>비밀번호 확인 : %s<br>이름 : %s<br>성별 : %s<br>이메일 : %s",id,pw,pwc,name,gender,email);
		out.print("</body></html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
