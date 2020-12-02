package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			String gender = request.getParameter("gender");
			String job = request.getParameter("job");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head><title>개인 정보</title></head>");
			out.print("<body><h3>개인 정보</h3>");
			out.printf("이름 : %s<br>아이디 : %s<br>비밀번호 : %s<br>성별 : %s<br>직업 : %s",name,id,pw,gender,job);
			out.print("</body></html>");
			
	
	
	}
	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
