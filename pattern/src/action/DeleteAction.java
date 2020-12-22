package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class DeleteAction implements Action{
	
	private String path;
	public DeleteAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("delete action : "+name);
		
		MemberService service = new MemberServiceImpl();
		service.deleteMember(name);
		
		//어디로 갈것인지?(~~.jsp or ~~.do 페이지로 보낼 수 있음)
		//어떤 방식으로 갈것인지?(forward or sendRedirect)
		//리턴 하고 싶음 - actionForward 만들기
		
		return new ActionForward(path,true);
		//위의 리턴 방식이 어렵다면 actionforward 객체 생성 후 변수를 리턴
	}
}
