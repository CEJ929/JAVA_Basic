package cms;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookMain {
	static HashMap<String, String> hm = new HashMap<String, String>();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		PhoneBookDAO pbd = new PhoneBookDAO();
	
		String mainMsg = "1. 고객저장\n2. 고객검색\n3. 전체보기\n4. 삭제\n5. 끝내기";
		
		while(true) {
			int choice = 0;
			
			System.out.println("☆★☆★☆★전화번호부☆★☆★☆★");
			System.out.println(mainMsg);
			
			choice = sc.nextInt();
			
			if (choice==5) {System.out.println("종료합니다."); break;}
			
			switch(choice) {
			
			
			case 1: 
				System.out.println("<----고객추가---->");
				pbd.insert();
				break;
				
			case 2:
				System.out.println("<----고객검색---->");
				pbd.search();
				break;
				
			case 3:pbd.show();
				break;
				
			case 4:
				System.out.println("<----고객삭제---->");
				pbd.delete();
				break;
				
				default :System.out.println("다시 입력하세요.\n"); 
				continue;
			
			
			
			}
			
		}
		
	}
	
	
}

