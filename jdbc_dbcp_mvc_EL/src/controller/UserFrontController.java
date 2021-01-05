package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

@WebServlet("*.do")
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ�ó��
		request.setCharacterEncoding("utf-8");
		
		//��û �з��ϱ�
		//http://localhost:8082/jdbc_dbcp_mvc/insert.do
		String requestURI = request.getRequestURI(); // /jdbc_dbcp_mvc/list.do
		String contextPath = request.getContextPath(); // /jdbc_dbcp_mvc
		String cmd = requestURI.substring(contextPath.length()); // /list.do
		
		//��û�� �´� action �����ϱ� => UserActionFactory
		UserActionFactory factory = UserActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		//������ action �� ��Ű��
		ActionForward af = null;
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//�̵���Ŀ� ���� ������ �̵��ϱ�
		if(af.isRedirect()) {//sendRedirect
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
