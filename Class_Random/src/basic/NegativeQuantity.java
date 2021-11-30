package basic;

import java.util.Random;

/*
 * 음의 정수 및 양의 정수 난수발생
 */
public class NegativeQuantity {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//1~9 사이 난수
		int n1 = r.nextInt(9)+1;
		
		//-1~ -9 사이 난수
		int n2 = -1-r.nextInt(9);

		//두자리 양의정수 (10~99)
		int n3 = r.nextInt(90)+10;
	
		
		System.out.println("1 ~ 9 사이 난수: "+n1);
		System.out.println("-1~ -9 사이 난수: "+n2);
		System.out.println("10 ~ 99 사이 난수: "+n3);
		
	}

}
