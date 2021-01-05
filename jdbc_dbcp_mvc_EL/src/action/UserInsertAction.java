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
		
		//add.jsp에서 사용자 입력값 가져오기
		String username = request.getParameter("username");
		String birthYEAR = request.getParameter("birthYEAR");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//service에게 일시키기
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthYEAR, addr, mobile);
		
		if(!insertFlag) { //실패시
			path = "add.jsp";
		}
		
		//작업 결과에 따라 페이지 이동 방식 결정 - sendRedirect(true)
		return new ActionForward(path, true); //성공시 insert,jsp
	}

}
