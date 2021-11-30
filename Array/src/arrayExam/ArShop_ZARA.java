package arrayExam;

import java.util.Scanner;

public class ArShop_ZARA {
	
	//ZARA (강남점, 코엑스점, 명동점) 
	//총 매출액, 평균 매출액 구하기 
	//단위는 100만원 단위로 입력 받는다.
	//단, 평균 매출액은 만원단위까지 출력한다.
	//평균 매출액보다 높은 매장에 인센티브 지급

	
public static void main(String[] args) {
		
		int []zara = new int[3];
		String z_name[] = {"강남점", "코엑스점", "명동점"}; 

		String best = "없음";
		int count = 0;
		int sum = 0;
		double avg = 0.0;

		Scanner sc = new Scanner(System.in);

		
		//매출입력과 누적합계 구하는 곳
		for (int i = 0; i < zara.length; i++) {
			System.out.println("ZARA"+z_name[i]+"의 매출 을 입력하시오.(단위: 백만원) ");
			zara[i] = sc.nextInt();
			sum +=zara[i];
		}
		System.out.println("매출 합계 = "+sum+"백만원");

		
		// 평균값을 소수점 둘째자리까지 구하는 곳
		avg = Double.parseDouble(String.format("%.2f",  (double)sum/zara.length));
		System.out.println("평균 매출 = "+avg+"만원");

		
		// 평균값보다 높은 값의 매장명을 구하는 곳
		for (int k = 0; k < zara.length; k++) {
			if (zara[k]>avg) {
				count ++;
				if(count==1) best = "";

				best += z_name[k]+"\n";
			}
		}
		System.out.println("★인센티브 매장★\n"+best);
	}


}
