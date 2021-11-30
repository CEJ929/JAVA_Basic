package basic;

import java.util.Random;
import java.util.Scanner;

public class RandomPlusMinus {
	/*
	 * 정수 하나 입력받고
	 * +5 ~ -5 범위의 난수를 발생
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.print("정수 하나 입력: ");
		int x = sc.nextInt();
		
		int raX = x-5+r.nextInt(11);
		
		System.out.println("입력값의 ±5 범위의 난수를 발생했습니다.");
		System.out.println("난수: "+raX);
		
		
	}

}
