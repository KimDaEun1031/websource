package controller;

import action.Action;
import action.DeleteAction;
import action.InsertAction;

public class ActionFactory {
	
	//아래의 3개 메소드를 싱글톤 패턴이라고 함 - 객체는 하나만 만들어서 쓰기
	
	private static ActionFactory factory;
	
	
	//아래 메소드를 생성하지 않을 시 컴파일 시 자동으로 public이 되기에 private으로 미리 생성하기
	private ActionFactory() {} //외부에서는 객체 생성을 못하게 한다는 것을 의미
	                           //그게 무슨뜻? FrontForward에서 생성을 하니 막아짐
	
	//막아놓은 후 아래의 메소드를 생성 후 FrontForward에서 호출 시 가능
	public static ActionFactory getInstance() { //static은 꼭 들어와야함 
		if(factory==null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null; // 중복코드 밀어내기
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");			
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAction("index.jsp");			
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/select.do")) {
			
		}
		return action; //이 메소드는 액션 리턴이 목적
	}
}
