package randomExam;

import java.util.Random;
import java.util.Scanner;

public class UpDownGame_Random {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int random ;
		int ans;
		int cnt=0;
		
		random = r.nextInt(100)+1; // 1~100까지 나오도록 +1이 없으면 0~99
		ans = -1;
		
		while (ans != random) {
			System.out.print("정수입력 (1~100) : ");
			ans = sc.nextInt();
			cnt++;
			if (ans>random) { 
				System.out.println("DOWN!");
			}else {	
				System.out.println("UP!");
				}	
		}
		System.out.println("정답입니다!  "+cnt+"회 반복!!");	
	}

	
	
}
