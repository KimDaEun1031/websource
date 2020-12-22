package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class InsertAction implements Action {
	//생성자는 1. 목적 - 객체 생성 할 때 무조건 호출 => new 할 때 무조건 호출
	//생성자 오버로딩
	//public insertAction(){} => default 생성자
	//public insertAction(String name){}
	//public insertAction(String name, int bno){}
	// 클래스 안에 생성자가 하나도 없다면 컴파일러가 default 생성자를 자동으로 생성해줌
	private String path;
	public InsertAction(String path) {
		this.path = path; //어디로 이동할 것인가
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//~pro.jsp에서 했던 작업
		//request.getparameter();
		String name = request.getParameter("name");
		System.out.println("insert action : " +name);
				
		MemberService service = new MemberServiceImpl();
		service.insertMember(name);
		//session            / request
		//sendRedirect(true) / forward(false)
		//짝이 정해짐 = 세션은 샌드 / 리퀘는 포워드
		
		return new ActionForward(path,true);
				
	}
}
