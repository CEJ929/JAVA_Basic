package basicCode;

public class Extends1 {
	/*
	 *  상속 inheritance
	 *  
	 *  A: 부모클래스, 상위클래스, 슈퍼클래스, 기반클래스
		B: 자식클래스, 하위클래스, 서브클래스, 파생클래스
		
		
	**부모클래스로부터 상속받은 멤버 변수의 접근 권한이 private일 때
 	1) 부모 클래스의 생성자를 호출해서 초기화 시킬 수 있다.
 	2) 부모 클래스에 setter 메서드를 통해서 초기화 시킬 수 있다.
 	3) 변수에 저장된 값은 getter 메서드를 통해서 가져온다.
 	
 	
 	**부모클래스로부터 상속받은 멤버 변수의 접근 권한이 protected일 때
 	1) 자식클래스에서 접근이 가능하기 때문에 this를 사용해서 초기화 한다.
 	2) 자식클래스에서 접근이 가능하므로 getter를 사용하지 않고
    	변수명으로 값에 직접 접근하면 된다.
		
		
	 */
	
public static void main(String[] args) {
		
		B instance = new B(); //super()가 자동으로 있다.
		instance.check(); //부모클래스 생성자도 호출된다.
	}


}
class A{
	int data = 0;
	
	public A() {
		// TODO Auto-generated constructor stub
	System.out.println("부모클래스 생성자");
	}
	
	void show() {
		System.out.println("A클래스");
		
	}
	
}


class B extends A{
	
	@Override //show+Ctrl+spacebar 자동으로 오버라이드 show() 생성
	void show() { //show 재정의
		// TODO Auto-generated method stub
		System.out.println("B클래스");
	}
	void check() {
		show();
		
	}


}
