package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserSelectAction implements Action {
	
	private String path;
	
	public UserSelectAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no")); 
		
		UserService service = new UserServiceImpl();
		UserVO vo =  service.getUser(no);
		
		request.setAttribute("vo", vo);
		
		return new ActionForward(path,false);
	}

}
