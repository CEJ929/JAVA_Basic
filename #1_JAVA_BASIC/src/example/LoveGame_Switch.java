package example;

import java.util.Scanner;

public class LoveGame_Switch {
	
	public static void main(String[] args) {
		String q ="Q. 밥 먹으러 갈래?^^ \n"
				+ "1. 아니\n"
				+ "2. 그래\n"
				+ "3. 이미 먹었어\n"
				+ "4. 어떤거 먹으러 갈까?\n";
		
		
		String q2="Q.자 라면을 먹기위해 집으로 왔다!  이제...\n"
				+ "1. 몇 개 끓일거야?\n"
				+ "2. 우리 오늘부터 1일?\n"
				+ "3. 빨리먹고 가자 과제 해야 해\n"
				+ "4. 먼저 씻고올까?\n";
		
		int ch = 0;
		
		System.out.println(q);
		
				Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		
		
		switch(ch){
			case 1: System.out.println("하하 그래..\n GameOver");
				break;
			case 2: System.out.println("넌 너무 쉬워 잘가~ \n GameOver");
				break;
			case 3: System.out.println("아..그래....배터지겠네 \n GameOver");
				break;
			default: System.out.println("뭔소리야?\n GameOver");
				break;
			
			case 4: System.out.println("우리 집에 라면먹으러 갈래?~ ^^\n");
			
			System.out.println(q2);
			
			
			
			ch=sc.nextInt(); //처음에 선언한 ch값을 그대로 사용
			
			switch(ch) { //switch문 안에 다른 switch문을 만들어서 다음 상황까지 연출가능
			case 1: System.out.println("너 다먹어라!! \n GameOver");
				break;
			case 2: System.out.println("어머 정말?^^~ \n YouWin~");
				break;
			case 3: System.out.println("어 그래ㅡㅡ\n GameOver");
				break;
			case 4: System.out.println(".....112... 여보세요 경찰이죠?\nGameOver");
				break;
			default: System.out.println("그냥 나가\n GameOver");   
			break;
			}
			
		}

		
	}


}
