package student;

public class StudentInfo {
	private int studentId;
	private String name;
	private int grade;
	private String addr;
	private String birth;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public StudentInfo(int studentId, String name, int grade, String addr, String birth) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.grade = grade;
		this.addr = addr;
		this.birth = birth;
	}
	
	public StudentInfo() {
		
	}
	
	@Override
	public String toString() {
		return "student [studentId=" + studentId + ", name=" + name + ", grade=" + grade + ", addr=" + addr + ", birth="
				+ birth + "]";
	}
}
