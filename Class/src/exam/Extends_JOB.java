package exam;

import java.util.Random;

public class Extends_JOB {
	
	public static void main(String[] args) {
		Teacher 한동석 = new Teacher("한동석",30,"남자",0,"강사");
		GagMan john = new GagMan("John",28,"남자",0);
		
		String[]arShow= {"드라마", "개그프로그램","지역 행사","영화"};
		String[]arSub = {"JAVA", "C언어","Python","C#"};
		
		Random r= new Random();
		
		int index = 0;
		
		
		for (int i = 0; i < 30; i++) {
			index = r.nextInt(4); //0~3 랜덤한 수
			john.showStart(arShow[index]);
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				}
			}
		
	}
	

}


//===========부모 클래스===============================
class Person{
	
	String name;
	int age;
	int money;
	String gender;
	
	public Person(){ }
	
	public Person(String name, int age, String gender, int money) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.money = money;
	}
	}

//==============자식클래스 1 선생님=====================
class Teacher extends Person{
	String subject;
	String position;
	int cnt=0;
	private int income = 10_000_000;
	
	public Teacher(String name, int age, String gender, int money,String position) {
		super(name, age, gender, money);
		this.position = position;
	}
	
	
	void teach(String subject) {
		cnt++;
		if(cnt % 10==0) income*=1.1;
	
		this.subject = subject;
		money+=income;
	System.out.println(name+" "+this.position+"이(가) "+this.subject+"을(를) 강의중");
	System.out.println("통장 잔고: "+money+"원");
	}
	
	
}


//=================자식클래스 2 개그맨===============================

class GagMan extends Person{
	String show;
	private int income = 100_000;
	
	public GagMan(String name, int age, String gender, int money) {
		super(name, age, gender,money);
	}
	
	void showStart(String show) {
		this.show = show;
		money+=income;
		System.out.println(name+" 이(가)"+show+" 에 출연했다.");
		System.out.println("통장잔고: "+money+" 원");
		}
		}
