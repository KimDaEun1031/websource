package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {
	
	private String path;
	
	public UserInsertAction(String path) {
		this.path = path; //insert.jsp
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request.getParameter()
		
		//add.jsp���� ����� �Է°� ��������
		String username = request.getParameter("username");
		String birthYEAR = request.getParameter("birthYEAR");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//service���� �Ͻ�Ű��
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthYEAR, addr, mobile);
		
		if(!insertFlag) { //���н�
			path = "add.jsp";
		}
		
		//�۾� ����� ���� ������ �̵� ��� ���� - sendRedirect(true)
		return new ActionForward(path, true); //������ insert,jsp
	}

}
