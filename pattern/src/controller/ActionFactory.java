package controller;

import action.Action;
import action.DeleteAction;
import action.InsertAction;

public class ActionFactory {
	
	//�Ʒ��� 3�� �޼ҵ带 �̱��� �����̶�� �� - ��ü�� �ϳ��� ���� ����
	
	private static ActionFactory factory;
	
	
	//�Ʒ� �޼ҵ带 �������� ���� �� ������ �� �ڵ����� public�� �Ǳ⿡ private���� �̸� �����ϱ�
	private ActionFactory() {} //�ܺο����� ��ü ������ ���ϰ� �Ѵٴ� ���� �ǹ�
	                           //�װ� ������? FrontForward���� ������ �ϴ� ������
	
	//���Ƴ��� �� �Ʒ��� �޼ҵ带 ���� �� FrontForward���� ȣ�� �� ����
	public static ActionFactory getInstance() { //static�� �� ���;��� 
		if(factory==null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null; // �ߺ��ڵ� �о��
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");			
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAction("index.jsp");			
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/select.do")) {
			
		}
		return action; //�� �޼ҵ�� �׼� ������ ����
	}
}
