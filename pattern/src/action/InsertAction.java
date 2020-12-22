package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class InsertAction implements Action {
	//�����ڴ� 1. ���� - ��ü ���� �� �� ������ ȣ�� => new �� �� ������ ȣ��
	//������ �����ε�
	//public insertAction(){} => default ������
	//public insertAction(String name){}
	//public insertAction(String name, int bno){}
	// Ŭ���� �ȿ� �����ڰ� �ϳ��� ���ٸ� �����Ϸ��� default �����ڸ� �ڵ����� ��������
	private String path;
	public InsertAction(String path) {
		this.path = path; //���� �̵��� ���ΰ�
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//~pro.jsp���� �ߴ� �۾�
		//request.getparameter();
		String name = request.getParameter("name");
		System.out.println("insert action : " +name);
				
		MemberService service = new MemberServiceImpl();
		service.insertMember(name);
		//session            / request
		//sendRedirect(true) / forward(false)
		//¦�� ������ = ������ ���� / ������ ������
		
		return new ActionForward(path,true);
				
	}
}
