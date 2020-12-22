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
		String contextPath = request.getContextPath(); //���� ���ư��� ������Ʈ ��
		String cmd = requestURI.substring(contextPath.length()); //
		
		//ActionFactory factory = new ActionFactory(); - ���� �� �� ��? ���ƹ���
		ActionFactory factory = ActionFactory.getInstance(); // - 
		Action action = null; // �ߺ��ڵ� �о��
		
		
		//�ߺ��̾��� �ڵ�� ������ �о��
		ActionForward af = null;
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			//true => sendRedirect ���
			response.sendRedirect(af.getPath()); //��θ� path�� ������ �ְ� �װ� af ���� �����ϱ�
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
