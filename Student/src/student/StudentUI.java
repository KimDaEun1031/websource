package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentUI {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StudentUtil studentutil = new StudentUtil();
		StudentInfo student = new StudentInfo();
		ArrayList<StudentInfo> studentlist = new ArrayList<StudentInfo>();
		
		
		while(true) {
			studentutil.StudnetUI();
			int number = s.nextInt();
			if(number==1) {
				student = studentutil.NewStudent(s);
				studentlist.add(student);
				studentutil.StudentInfoAddSuccessMessage(student);
			} else if(number==2) {
				studentutil.AllStudent(studentlist);
			} else if (number==3) {
				studentutil.IndividualStudent(s, studentlist);
			} else if (number==4) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}

}
