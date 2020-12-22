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
		
		//���� ��������?(~~.jsp or ~~.do �������� ���� �� ����)
		//� ������� ��������?(forward or sendRedirect)
		//���� �ϰ� ���� - actionForward �����
		
		return new ActionForward(path,true);
		//���� ���� ����� ��ƴٸ� actionforward ��ü ���� �� ������ ����
	}
}
