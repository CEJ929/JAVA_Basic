package exam;

public class SportsMain {
	
	public static void main(String[] args) {
		Member mem1 = new Member();
		Member mem2 = new Member();
		Member mem3 = new Member();
		Member mem4 = new Member();
		
		mem1.name = "김철수";
		mem1.age = 32;
		mem1.gender = "남자";
		
		mem2.name = "김민호";
		mem2.age = 28;
		mem2.gender = "남자";
		
		mem3.name = "이영희";
		mem3.age = 24;
		mem3.gender = "여자";
		
		mem4.name = "고석천";
		mem4.age = 32;
		mem4.gender = "남자";
		
		mem1.centerName = "BYE"; //static 변수를 main에서 한 번만 바꿔줘도 모두에 적용됨. 
								//이 부분 주석처리하면 centerName = HELLO 로 출력됨
		
		System.out.println("------member 1--------");
		mem1.info();
		System.out.println("------member 2--------");
		mem2.info();
		System.out.println("------member 3--------");
		mem3.info();
		System.out.println("------member 4--------");
		mem4.info();
	}
	
}



class Member{
 	static String centerName ="HELLO" ;
	String name;
	int age;
	String gender;
	
	
	void info() {
		System.out.println("CenterName = "+centerName);
		System.out.println("Name = "+name);
		System.out.println("Age = "+age);
		System.out.println("Gender =" + gender);
	}
	
}