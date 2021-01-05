package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserListAction implements Action {
	
	private String path;
	
	public UserListAction(String path) {
		this.path = path; //list.do
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request.getParameter - > X
		//서비스한테 일시키기
		UserService service = new UserServiceImpl();
		List<UserVO> list = service.getUserlList();
	
		//이동방식 결정한 후 ActionForward 객체 생성		
		request.setAttribute("list", list);
		return new ActionForward(path, false);
	}

}
