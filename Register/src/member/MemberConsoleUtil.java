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
			System.out.println("����� ȸ�� ������ �Է��ϼ���.");
			System.out.print("���̵� : ");
			id = s.nextInt();
			member.setId(id);
			System.out.print("�̸� : ");	
			name = s.next();
			member.setName(name);			
			System.out.print("�ּ� : ");		
			addr = s.next();
			member.setAddr(addr);
			System.out.print("���� : ");	
			nation = s.next();
			member.setNation(nation);
			System.out.print("�̸��� : ");
			email = s.next();
			member.setEmail(email);
			System.out.print("���� : ");
			age = s.nextInt();
			member.setAge(age);
			
			return member;		
		}
		//return new Member(id, name, addr, nation, email, age);
		
		public void printAddSuccessMessage(Member member) {
			System.out.println(member.getName()+" ȸ�� ���� �߰� ����");
		}
		
		public Member getUpdateMember(Scanner s, List<Member> list) {
			System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
			int id = s.nextInt();
			
			Member member = null;
			for(int i=0; i<list.size(); i++) {
				member = list.get(i);
				if(member.getId()==id) {
					System.out.println("������ �ּҸ� �Է��ϼ���.");
					String addr = s.next();
					System.out.println("������ �̸����� �Է��ϼ���.");
					String email = s.next();
					
					member.setAddr(addr);
					member.setEmail(email);
					
					return member;
				}
			}			
			return null;		
		}
		public void ModifySuccessMessage(Member member) {
			System.out.println(member.getName()+" ȸ�� ���� ���� ����");
		}
		public void ModifyFailMessage() {
			System.out.println("ȸ�� ���� ���� ����");
		}
		
		public Member removeMember(Scanner s, List<Member> list) {
			System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
			int id = s.nextInt();
			
			Member member = null;
			for(int i=0; i<list.size(); i++) {
				member = list.get(i);
				if(member.getId()==id) {
					System.out.println("���� �����Ͻðڽ��ϱ�? ��(1) �ƴϿ�(2)");
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
			System.out.println(member.getName()+" ȸ�� ���� ���� ����");
		}
		
		public void RemoveFailMessage() {
			System.out.println("ȸ�� ���� ���� ����");
		}
		
		
		public void printMemberList(List<Member> list){
			System.out.println("���̵�\t�̸�\t�ּ�\t����\t�̸���\t����\t");
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
