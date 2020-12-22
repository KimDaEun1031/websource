package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.DeleteAction;
import action.InsertAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath(); //현재 돌아가는 프로젝트 명
		String cmd = requestURI.substring(contextPath.length()); //
		
		//ActionFactory factory = new ActionFactory(); - 빨간 줄 뜸 왜? 막아버림
		ActionFactory factory = ActionFactory.getInstance(); // - 
		Action action = null; // 중복코드 밀어내기
		
		
		//중복이었던 코드는 밖으로 밀어내기
		ActionForward af = null;
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			//true => sendRedirect 방식
			response.sendRedirect(af.getPath()); //경로를 path가 가지고 있고 그건 af 에서 왔으니까
		}else { //false => forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);			
		}
		
//		response.setContentType("text/html;charset=utf-8");
		
//		PrintWriter out = response.getWriter();
//		out.print("requestURI"+requestURI+"<br>");
//		out.print("contextPath"+contextPath+"<br>");
//		out.print("cmd"+cmd+"<br>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
