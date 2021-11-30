package arrayExam;

import java.util.Scanner;

public class ArrSubjectScore {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//과목점수, 과목명 배열생성
		int arr[][] = new int[4][4];
		String[] sub= {"번호", "국어","영어","수학"};
		
		//과목별 점수 입력 받기
		//번호 넘어 갈 때 마다 줄바꿈
		for (int i= 0;  i< arr.length; i++) {
			System.out.println(i+1+" 번 학생 점수----");
			arr[i][0] = i+1;
			for (int j = 0; j < arr[0].length-1; j++) {
			System.out.print(sub[j+1]+": ");
				arr[i][j+1] = sc.nextInt();
			}
		}
		
		//출력 부분
	for (int i = 0; i < sub.length; i++) {
	System.out.print(" "+sub[i]+"\t"); 	}		

	System.out.println("");

	for (int i = 0; i < sub.length; i++) {
		for (int j = 0; j < sub.length; j++) {
			System.out.print(" "+arr[i][j]+"	  \t");
		}
		System.out.println("");
	}


	}


}
