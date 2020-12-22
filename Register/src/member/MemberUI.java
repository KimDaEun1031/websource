package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberUI {
	
	public static void MemberUI() {
		System.out.println("===== ȸ������ ���α׷� =====");
		System.out.println("1.ȸ�����");
		System.out.println("2.ȸ����Ϻ���");
		System.out.println("3.ȸ����������");
		System.out.println("4.ȸ����������");
		System.out.println("5.���α׷� ����");
		System.out.print("�޴���ȣ : ");	
	}
	
	public static void main (String [] args) {
			Scanner s = new Scanner(System.in);
			ArrayList<Member> list = new ArrayList<Member>();
			MemberConsoleUtil mc = new MemberConsoleUtil();
			Member member = new Member();
			int number;	
				
			while(true) {
				MemberUI();
				number = s.nextInt();
				if(number==1) {
					member = mc.getNewmember(s);
					list.add(member);
					mc.printAddSuccessMessage(member);
				}
				else if (number==2) {
					mc.printMemberList(list);
				}
				else if(number==3) {
					member = mc.getUpdateMember(s, list);
					if(member==null) {
						mc.ModifySuccessMessage(member);
					}
					else {
						mc.ModifyFailMessage();
					}
				}else if(number==4) {
					member = mc.removeMember(s, list);
					if(member==null) {
						mc.RemoveSuccessMessage();
					}
					else {
						mc.RemoveFailMessage();
					}
				}else if(number==5) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}			
	}
}
