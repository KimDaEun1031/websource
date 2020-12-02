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
 * Servlet implementation class DinnerServlet
 */
@WebServlet("/DinnerServlet")
public class DinnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		
		String [] dinner = request.getParameterValues("dinner");
//		System.out.println(Arrays.toString(dinner));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>오늘의 저녁</title></head>");
		out.print("<body><h3>당신이 고른 오늘의 저녁은</h3>");
		out.print("<h2>"+Arrays.toString(dinner)+"</h2>");
		out.print("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
