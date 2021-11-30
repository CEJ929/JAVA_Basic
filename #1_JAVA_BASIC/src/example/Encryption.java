package example;

//PW 암호화 코드

import java.util.Scanner;

public class Encryption {
	
	public static void main(String[] args) {
		
		//int data = 'A';
		//char data2 = 65;
		//System.out.println(data); 
		//System.out.println(data2);
		
		//아스키코드값 출력, 자동형변환 , int에 문자를 넣었고 char에 정수를 넣음

				
				
				String pw = ""; 
				System.out.println("pw : ");
				pw = new Scanner(System.in).next();
				
				System.out.println("암호화된 PW : ");
				for (int i = 0; i < pw.length(); i++) {
					System.out.print((char)(pw.charAt(i)-10));}


	}


}
