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
		System.out.println("------- <학생 정보 관리 프로그램> -------");
		System.out.println("\t1. 학생정보 입력");
		System.out.println("\t2. 학생정보 전체조회");
		System.out.println("\t3. 학생정보 개별조회");
		System.out.println("\t4. 프로그램 종료");
		System.out.print("선택 : ");
	}
	
	public StudentInfo NewStudent(Scanner s) {
		StudentInfo student = new StudentInfo();
		System.out.println("------- 새로운 학생 정보 입력 -------");
		System.out.print("학 번 : ");
		int studentId = s.nextInt();
		student.setStudentId(studentId);
		System.out.print("이 름 : ");
		String name = s.next();
		student.setName(name);
		System.out.print("학 년 : ");
		int grade = s.nextInt();
		student.setGrade(grade);
		System.out.print("주 소(예시 : 경기) : ");
		String addr = s.next();
		student.setAddr(addr);
		System.out.print("생 일(예시 : 05/10) : ");
		String birth = s.next();
		student.setBirth(birth);
		
		return student;
	}
	
	public void StudentInfoAddSuccessMessage(StudentInfo student) {
		System.out.println(student.getName()+" 학생 정보가 입력되었습니다.");
	}
	
	public void AllStudent(List<StudentInfo> studentlist) {
		System.out.println("-------------- 학생 정보 보기 --------------");
		System.out.println("학 번 | | 이 름 | | 학 년  | | 주 소 | | 생 일");
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
		System.out.println("검색하고자 하는 학생의 학번을 입력하세요. : ");
		int studentId = s.nextInt();
		
		StudentInfo student = null;
		for(int i=0; i<studentlist.size(); i++) {
			student = studentlist.get(i);
			if(student.getStudentId()==studentId) {
				System.out.println("-------------- 학생 정보 보기 --------------");
				System.out.println("학 번 | | 이 름 | | 학 년  | | 주 소 | | 생 일");
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

