package basicCode;

import java.util.Scanner;

public class Array2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int []students = new int[5]; 
		String[]arSub = {"국어", "영어", "수학","사회","도덕"};
		int sum = 0;
		
		for (int i = 0; i < arSub.length; i++) {
			System.out.println(arSub[i]+"점수를 입력하세요.");
			students[i] = sc.nextInt();
			sum+=students[i];
		}
		
		

		//실수값이 나오기 위해 형변환
		System.out.println("평균 점수: "+sum/(float)students.length);
	}


}
