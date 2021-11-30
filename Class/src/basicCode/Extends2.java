package basicCode;

public class Extends2 {
	
	public static void main(String[] args) {

		//		SuperCar superCar = new SuperCar();
		SuperCar ferrari = new SuperCar("ferrari", "Red", 45000, "sport");
		Car myCar = new Car("SONATA", "Black", 3800);
		//ctrl+t 하면 상속계보를 볼 수 있음
		
		System.out.println(myCar);
		//여기에서 주소 값이 나오는 이유!!
		// to String은 자식클래스에서 재정의 했기 때문에
		// 부모클래스인 car에서는 문자열 출력 지원이 안되고 주소값으로 출력됨.
		//부모클래스에서 재정의 하면 myCar의 정보가 잘 나오게 된다.

		System.out.println(ferrari);
		ferrari.engineStart();
		ferrari.engineStop();

	}


}

	class Car{

	final int wheel = 4;

	public String brand;
	protected String color;
	private int price;

	public Car(){
		System.out.println("부모클래스의 기본 생성자"); }


	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	
	void engineStart() {
		System.out.println("열쇠로 시동 켬");
	}
	void engineStop() {
		System.out.println("열쇠로 시동 끔");
	}



	public int getPrice() { 	return price; }

	public void setPrice(int price) {	this.price = price; }

	@Override
	public String toString() {
		return "브랜드: "+brand+"\n"+"색상:  "+color+"\n가격:  "+getPrice()+"만원";
	}


}


//===================Car의 자식클래스===============================================

class SuperCar extends Car {
	String mode;

	public SuperCar() {
		System.out.println("자식클래스의 기본 생성자");
	}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price); //super를 이용해서 부모클래스의 변수들을 초기화
		//setPrice(price);  <<-- set 으로 price로 초기화 할 수도 있다.
		this.mode = mode;
	}

	@Override
	void engineStart() {
		System.out.println("음성으로 시동 켬");	}
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");	}


}
