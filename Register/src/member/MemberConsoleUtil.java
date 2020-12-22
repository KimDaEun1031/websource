package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {
	private int id;
	private String name;
	private String addr;
	private String nation;
	private String email;
	private int age;

	Member member = new Member(id, name, addr, nation, email, age);
	
		public Member getNewmember(Scanner s) {
			Member member = new Member();
			System.out.println("등록할 회원 정보를 입력하세요.");
			System.out.print("아이디 : ");
			id = s.nextInt();
			member.setId(id);
			System.out.print("이름 : ");	
			name = s.next();
			member.setName(name);			
			System.out.print("주소 : ");		
			addr = s.next();
			member.setAddr(addr);
			System.out.print("국가 : ");	
			nation = s.next();
			member.setNation(nation);
			System.out.print("이메일 : ");
			email = s.next();
			member.setEmail(email);
			System.out.print("나이 : ");
			age = s.nextInt();
			member.setAge(age);
			
			return member;		
		}
		//return new Member(id, name, addr, nation, email, age);
		
		public void printAddSuccessMessage(Member member) {
			System.out.println(member.getName()+" 회원 정보 추가 성공");
		}
		
		public Member getUpdateMember(Scanner s, List<Member> list) {
			System.out.print("수정할 회원의 아이디를 입력하세요 : ");
			int id = s.nextInt();
			
			Member member = null;
			for(int i=0; i<list.size(); i++) {
				member = list.get(i);
				if(member.getId()==id) {
					System.out.println("수정할 주소를 입력하세요.");
					String addr = s.next();
					System.out.println("수정할 이메일을 입력하세요.");
					String email = s.next();
					
					member.setAddr(addr);
					member.setEmail(email);
					
					return member;
				}
			}			
			return null;		
		}
		public void ModifySuccessMessage(Member member) {
			System.out.println(member.getName()+" 회원 정보 수정 성공");
		}
		public void ModifyFailMessage() {
			System.out.println("회원 정보 수정 실패");
		}
		
		public Member removeMember(Scanner s, List<Member> list) {
			System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
			int id = s.nextInt();
			
			Member member = null;
			for(int i=0; i<list.size(); i++) {
				member = list.get(i);
				if(member.getId()==id) {
					System.out.println("정말 삭제하시겠습니까? 예(1) 아니오(2)");
					int input = s.nextInt();
					if(input==1) {
						list.remove(i);
						return member;
					}
				}
			}
			return null;
		}
		
		public void RemoveSuccessMessage() {
			System.out.println(member.getName()+" 회원 정보 삭제 성공");
		}
		
		public void RemoveFailMessage() {
			System.out.println("회원 정보 삭제 실패");
		}
		
		
		public void printMemberList(List<Member> list){
			System.out.println("아이디\t이름\t주소\t국가\t이메일\t나이\t");
			for(Member member:list) {
				System.out.print(member.getId()+"\t");
				System.out.print(member.getName()+"\t");
				System.out.print(member.getAddr()+"\t");
				System.out.print(member.getNation()+"\t");
				System.out.print(member.getEmail()+"\t");
				System.out.print(member.getAge()+"\t");
			}
		}
}
