package basicCode;

//자바의 꽃, 클래스!!
// 클래스의 핵심, 객체화!!
public class ObjectModel { 
	
public static void main(String[] args) {
		
		VariableTest vt = new VariableTest(); //객체화
		
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		
		vt.f2();
		vt = new VariableTest(); //new 를 만나는 순간 초기화
		vt.f(); //여기에서 출력값은 1
		
		//VariableTest 에서 int data를 static으로 선언하게되면 출력값은 21로 바뀜.
		//static 변수는 new 를 만나는 때가 아닌, 프로그램 종료시 초기화 되니까!
	}


}

class VariableTest {
	
	int data = 0;
	
	void f() {
		
		data++;
		System.out.println(data);
	}
	
	void f2() {
		
		data = 20;
	}
	
}
