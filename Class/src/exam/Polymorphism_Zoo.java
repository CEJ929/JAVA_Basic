package exam;

/*
 * 다형성이란 하나의 메소드가 서로 다른 클래스에서
	다양하게 실행되는 것을 말한다.
	다형성을 구현하기 위해서는
	다형성을 구현할 메서드를 포함할 클래스에게 부모클래스가
	상속해줘야 한다.
	
	부모클래스와 자식클래스에 같은 이름의 메서드가 있어야 하고,
	자식클래스에서는 재정의(overriding) 해야 한다.
	따라서 다형성의 종류에는 Overloading, Overriding이 있다.
 * 
 */

public class Polymorphism_Zoo {

	public static void main(String[] args) {
		
		Animal lion1 = new Lion();
		Animal rabbit1 = new Rabbit();
		Animal mon1 = new Monkey();

		Zookeeper james = new Zookeeper();

		james.feed(lion1);
		james.feed(rabbit1);
		james.feed(mon1);


	}


}

class Animal{
	void breath() {System.out.println("숨쉬기");}
}

class Lion extends Animal{
	public String toString() {return "사자";}
}

class Rabbit extends Animal{
	public String toString() {return "토끼";}
}

class Monkey extends Animal{
	public String toString() {return "원숭이";}
}

class Tiger extends Animal{
	public String toString() {return "호랑이";}
}

class Dog extends Animal{
	public String toString() {return "강아지";}
}



class Zookeeper{
	void feed(Animal animal) {
		System.out.println(animal+" 에게 먹이주기");
	}
}

