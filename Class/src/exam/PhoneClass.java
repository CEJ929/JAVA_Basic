package exam;

public class PhoneClass {

	public static void main(String[] args) {

		Iphone myI = new Iphone("Iphone 6+", "WHITE", 120);
		Iphone momPhone = new Iphone();

		myI.info();
		momPhone.info(); //비어있는(null) 값들이 출력됨
	}

}



class Iphone{
	
	String model;
	String color;
	int capacity;

	Iphone(){}; //기본생성자
	
	//매개변수 생성자
	public Iphone(String model, String color, int capacity) {
		this.model = model;
		this.color = color;
		this.capacity = capacity;
	}
	
	void info(){
		System.out.println(model);
		System.out.println(color);
		System.out.println(capacity);
	}



}
