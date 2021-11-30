package example;

import java.util.Scanner;

//cafe
/*1) 주문하기
* 주문가능한 메뉴 출력
* 메뉴입력
* 메뉴의 가격을 총금액에 누적
* 주문메뉴를 전체 메뉴리스트에 더한다
* 주문한 개수를 한 개 증가한다.
* 
* 2) 취소하기
* 주문한 메뉴 리스트를 출력한다.
* 그 중에서 취소할 메뉴 입력 받는다.
* 입력받은 메뉴를 제거
* 입력받은 메뉴의 금액을 총 금액에서 차감
* 주문 개수를 감소한다.
* 
* 3) 결제하기
* 결제해야 할 총 금액 출력
* 사용자에게 지불할 금액을 입력 받는다.
* 지불 금액과 총 금액 비교 "잔액부족" 취소, 그게 아니면 잔돈과 함께 계산
* 총 금액은 0원으로 주문리스트는 비워준다.
* 전체 개수를 0개로 초기화
* 
* 4) 끝내기
* 내가 원할 때 끝낼 수 있는 기능
*/


public class Cafe_ControlStatement_total {
	public static void main(String[] args) {
		
		int cnt = 0;
		int choice;
		int sum = 0;
		String canMenu = "";
		
		int []menuPrice = {2500, 4000, 4500, 2000}; 
		String[]menu = {"아메리카노", "카페라떼", "바닐라라떼", "에스프레소"};
		String[]order = new String[5];
		
		String menuMsg = "메뉴를 선택하세요.\n1.주문하기 / 2. 취소하기 / 3. 결제하기" 
				+ "/ 4.취소하고 나가기";
		String orderMsg = "주문하실 메뉴를 선택하세요.\n1)아메리카노(2500원)/"
				+ " 2) 카페라떼(4000원) / 3) 바닐라라떼(4500원) \n 4)에스프레소(2000원 /5)뒤로가기 ";
		String cancelMsg = "취소하실 메뉴 번호를 선택하세요.(뒤로가기:6번)";
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(menuMsg);
			choice = sc.nextInt();
			if(choice<1 || choice>4) {
				System.out.println("다시 입력하세요."); continue; }
			else if(choice ==4) {
				System.out.println("종료합니다.");
				break;
			}
			
			switch(choice) {
			case 1 :
				System.out.println(orderMsg);
			
				for (int i = 0; i < order.length; i++) {
				System.out.print("메뉴 번호 : ");
				choice = sc.nextInt();
				
				if(choice==5) break;
				else if (choice>5 || choice<1) {
					System.out.println("잘못입력하였습니다.");
					i--;
				}
				else {
					sum+=menuPrice[choice-1];
					order[i] = menu[choice-1];
					cnt++;
									}
				}	
				break;
				
				//취소하기 영역
			case 2 : 
				System.out.println(cancelMsg);
				for (int i = 0; i < cnt; i++) {
					System.out.println((i+1)+". "+order[i]);
				} System.out.println("총 금액: "+sum);
				
				for (int i = 0; i < cnt; i++) {
					System.out.print("취소번호: ");
					choice = sc.nextInt();
					
					if(choice==6) break;
					else if(choice<0 || choice>6 || choice>cnt) {
						System.out.println("다시 입력하세요.");
						i--;
						continue;
					} else {
						canMenu = order[choice-1];
						System.out.println(canMenu+"을(를) 취소합니다.\n");
						
						for (int j = 0; j < menu.length; j++) {
							if(canMenu.equals(menu[j])) { sum-=menuPrice[j];	}
						}
						
						if(choice == cnt) {order[choice-1] = "";}
						else {
							for (int j = choice-1; j < cnt; j++) {
								if(j==cnt-1) {order[j] = ""; }
								else {order[j] = order[j+1];}
							}
						}
						cnt--;
						}
					System.out.println("<현재 주문 메뉴>	(뒤로가기 6번)");
					for (int j = 0; j < cnt; j++) {
						System.out.println((j+1)+". "+order[j]);
					}
					System.out.println("총 금액: "+sum+"\n");
						}
					
				break;
				//결제하기
			case 3 :
				System.out.println("결제하실 금액: "+sum+" 원");
				System.out.print("지불하신 금액: ");
				choice = sc.nextInt();
				
				if(choice==sum) {System.out.println("결제가 완료되었습니다. 빠잉~\n");}
				else if(choice>sum) {System.out.println("거스름돈"+(choice-sum)+" 원 입니다. 빠잉~\n");}
				else {System.out.println("결제 금액이"+(sum-choice)+"원 부족합니다.\n "
						+ "다시 결제 해주세요.\n"); 	continue;}
				
				break;
				}
		}
		
			
	}

	
	

}
