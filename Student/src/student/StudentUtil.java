package student;

import java.util.List;
import java.util.Scanner;

public class StudentUtil {
	private int studentId;
	private String name;
	private int grade;
	private String addr;
	private String birth;
	
	StudentInfo student = new StudentInfo(studentId, name, grade, addr, birth);
	
	public void StudnetUI() {
		System.out.println("------- <�л� ���� ���� ���α׷�> -------");
		System.out.println("\t1. �л����� �Է�");
		System.out.println("\t2. �л����� ��ü��ȸ");
		System.out.println("\t3. �л����� ������ȸ");
		System.out.println("\t4. ���α׷� ����");
		System.out.print("���� : ");
	}
	
	public StudentInfo NewStudent(Scanner s) {
		StudentInfo student = new StudentInfo();
		System.out.println("------- ���ο� �л� ���� �Է� -------");
		System.out.print("�� �� : ");
		int studentId = s.nextInt();
		student.setStudentId(studentId);
		System.out.print("�� �� : ");
		String name = s.next();
		student.setName(name);
		System.out.print("�� �� : ");
		int grade = s.nextInt();
		student.setGrade(grade);
		System.out.print("�� ��(���� : ���) : ");
		String addr = s.next();
		student.setAddr(addr);
		System.out.print("�� ��(���� : 05/10) : ");
		String birth = s.next();
		student.setBirth(birth);
		
		return student;
	}
	
	public void StudentInfoAddSuccessMessage(StudentInfo student) {
		System.out.println(student.getName()+" �л� ������ �ԷµǾ����ϴ�.");
	}
	
	public void AllStudent(List<StudentInfo> studentlist) {
		System.out.println("-------------- �л� ���� ���� --------------");
		System.out.println("�� �� | | �� �� | | �� ��  | | �� �� | | �� ��");
		System.out.println("-----------------------------------------");
		for(StudentInfo student:studentlist) {
			System.out.print("  "+student.getStudentId());
			System.out.print("\t "+student.getName());
			System.out.print("\t    "+student.getGrade());
			System.out.print("\t    "+student.getAddr());
			System.out.print("\t    "+student.getBirth());
			System.out.println();
		}
	}
	
	public void IndividualStudent(Scanner s, List<StudentInfo> studentlist) {
		System.out.println("�˻��ϰ��� �ϴ� �л��� �й��� �Է��ϼ���. : ");
		int studentId = s.nextInt();
		
		StudentInfo student = null;
		for(int i=0; i<studentlist.size(); i++) {
			student = studentlist.get(i);
			if(student.getStudentId()==studentId) {
				System.out.println("-------------- �л� ���� ���� --------------");
				System.out.println("�� �� | | �� �� | | �� ��  | | �� �� | | �� ��");
				System.out.println("-----------------------------------------");
				System.out.print("  "+student.getStudentId());
				System.out.print("\t "+student.getName());
				System.out.print("\t    "+student.getGrade());
				System.out.print("\t    "+student.getAddr());
				System.out.print("\t    "+student.getBirth());
				System.out.println();
				}
			}
		}
}

