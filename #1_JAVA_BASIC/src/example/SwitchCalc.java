package example;

import java.util.Scanner;

public class SwitchCalc {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String menuMsg = "1. 계산하기 / 2. 나가기";
		String oper = "";
		String result = "";

		int num1=0, num2=0, choice=0;


		while(true) {
			System.out.println(menuMsg);
			choice = sc.nextInt();

			if (choice==2) {System.out.println("종료합니다.");break;}

			if (choice != 1) {System.out.println("다시 입력하세요");	continue;}
			// 다음 반복으로 넘어가는 continue!!



			num1 = Integer.parseInt(sc.next());
			oper = sc.next();
			num2 = Integer.parseInt(sc.next());

			switch(oper) {
			case "+" : 
				result = ""+(num1+num2); break;
			case "-" : 
				result = ""+(num1-num2); break;
			case "*" : 
				result = ""+(num1*num2); break;
			case "/" : 
				if(num2 !=0)  {
					result = ""+(num1/num2); break;
				} else { result = "0으로 나눌 수 없습니다.";} break;

			default: result = "사칙연산 외에 연산자는 사용할 수 없습니다.";
			}

			System.out.println(result);
			System.out.println("");

		}

	}


}
