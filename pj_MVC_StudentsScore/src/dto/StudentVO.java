package dto;

public class StudentVO {

	private String name;
	private int age;
	private int number;
	private static int seq;
	
	
	public StudentVO(){}

	public StudentVO(String name, int age) {
		this.name = name;
		this.age = age;
		this.number = ++seq;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	public int getNumber() {
		return number;
	}
	
	
	
	
	
	
	
	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		StudentVO.seq = seq;
	}

	
	public void show() {
		System.out.println("번호: "+this.number+" /이름: "+name+" /나이"+age+"세");
	}
	

	
	
	
	
}

