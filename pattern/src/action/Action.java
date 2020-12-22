package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//고정시키기 - 클래스, 추상클래스도 가능하지만 이번엔 인터페이스로
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
