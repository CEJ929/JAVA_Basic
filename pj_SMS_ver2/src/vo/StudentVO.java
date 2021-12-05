package vo;

public class StudentVO {
	
	private String stdNo;
	private String name;
	private String department;
	private double grade;
	
	

	//생성자
	public StudentVO() {}
	public StudentVO(String stdNo, String name, String department, double grade) {
		this.stdNo = stdNo;
		this.name = name;
		this.department = department;
		this.grade = grade;
	}

	//show 메서드 대신 toString 재정의
	@Override
	public String toString() {
		return "학번 :"+stdNo+"\n이름: "+name+"\n학과: "+department+"\n평점: "+grade;	
		}
	
	
	//학번 세터없애고 게터만 살려둠으로 보안성 up (직접접근차단)
	public String getStdNo() {
		return stdNo;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	

	
	



}
