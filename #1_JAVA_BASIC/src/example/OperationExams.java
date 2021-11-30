package example;

public class OperationExams {
	
public static void main(String[] args) {
		
		
		System.out.println("★★ 1~100까지 짝수만 출력, 0도 짝수랍니다.......★★");
		for(int a=0; a<101; a+=2) {	System.out.println(a);}
		
		System.out.println("★★ 1~100까지 홀수만 출력★★");
		for(int g=1; g<100; g+=2) {	System.out.println(g);	}
		
		System.out.println("★★ 1~100까지 홀수만 출력<선생님 버전>★★");
		for(int g=0; g<100; g++) {
			if(g%2==1) {
				System.out.println(g);   }
		}
		
		
		System.out.println("★★1~100까지의 수 중 3과 5의 공배수 구하기★★");
		for(int t=0; t<100; t+=15) {	System.out.println(t);	}
		
		System.out.println("★★1~100까지의 수 중 3과 5의 공배수 구하기<선생님 버전>★★");
		for(int t=1; t<100; t++) {
			if(t%3==0  && t%5==0) {
				System.out.println(t);
			}
		}

		
		System.out.println("★★A~E까지 출력★★");
		for (int eng=65; eng<70; eng++) {	System.out.println((char)eng);	}

		System.out.println("★★A~E까지 출력<선생님 버전>★★");
		for(int eng=0; eng<5; eng++) {
//			System.out.println((char)(65+eng));
			System.out.printf("%c\n", 65+eng);
		}

		System.out.println("★★A~E까지 출력<선생님 버전2>★★");
		for(char eng = 'A'; eng<='E'; eng++) {
			System.out.println(eng);
		}
		
		
		System.out.println("★★다음의 출력결과는 30★★");
		int n3 = 10;
		int result = n3++ +10 + ++n3-2; // 정답: 30
		System.out.println(result);

	}


}
