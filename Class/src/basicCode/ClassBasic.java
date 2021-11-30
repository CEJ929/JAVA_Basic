package basicCode;

public class ClassBasic {
	
	public static void main(String[] args) {
		System.out.println(Car2.wheel); // static 변수는 그냥 사용 가능
		//System.out.println(Car.speed);   오류 발생!! 인스턴스(생성자)를 생성하지 않았음
			
		
		Car2 myCar1 = new Car2();
		System.out.println(myCar1.speed);
		
		Car2 myCar2 = new Car2();
		
		System.out.println("<변경 전>");
	System.out.println("myCar1 Speed: "+myCar1.speed);
	System.out.println("myCar2 Speed: "+myCar2.speed);
	System.out.println("myCar1 Wheel: "+myCar1.wheel);
	System.out.println("myCar2 Wheel: "+myCar2.wheel);

	myCar2.speed = 100;
	myCar2.wheel = 5;

	System.out.println("<변경 후>");
	System.out.println("myCar1 Speed: "+myCar1.speed);
	System.out.println("myCar2 Speed: "+myCar2.speed);
	System.out.println("myCar1 Wheel: "+myCar1.wheel);
	System.out.println("myCar2 Wheel: "+myCar2.wheel);
		
		}

	}

//===========================외부에 Car2 클래스 ===============================
class Car2{
	static int wheel = 4; //값을 공유하는 변수
	int speed; //인스턴스 변수 별로 각각 고유의 값을 가질 수 있음
	
	
	
	
}

