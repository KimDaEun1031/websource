package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberUI {
	
	public static void MemberUI() {
		System.out.println("===== 회원관리 프로그램 =====");
		System.out.println("1.회원등록");
		System.out.println("2.회원목록보기");
		System.out.println("3.회원정보수정");
		System.out.println("4.회원정보삭제");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴번호 : ");	
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
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}			
	}
}
