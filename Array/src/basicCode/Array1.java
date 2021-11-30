package basicCode;

import java.util.Arrays;
/*
 *  4칸짜리 배열을 선언하면 그 4칸은 heap 메모리 영역에 만들어지고
	그 배열의 시작주소만 배열 저장공간에 담겨져있다.
	배열명.length = 4이다.

	index (방번호)는 늘 0번부터 시작
 	-> 왜? 변수명이 시작주소를 가지고있기 때문에
	포인터연산을 했을 때, +0 입니다.
	그것을 대괄호로 치환했을 때, 0부터 index가 시작할 수 밖에 없다.


	[] (대괄호) : 참조하다. 그 주소에 들어가서 값을 들고나온다.
	new : 기타연산자. new가 나오면 heap 영역이다.
 * 
 */

public class Array1 {
	
	public static void main(String[] args) {


		int[]arData = new int[4]; 	//선언 및 length 지정
		int arData2[] = {1,7,3,4,5}; // 선언과 동시에 초기화


		//주소값 출력, 이 배열이 가지고 있는건 0번 인덱스의 주소값이다!!
		System.out.println(arData); 
		

		//배열 안에 인덱스로 접근함에 따라 인덱스 값인 0 출력
		System.out.println(arData[0]); 
		

		//util.Arrays.toString을 이용해 배열 전체 값 출력 가능
		//Arrays 클래스에서 toString을 오버라이딩 했기 때문에 가능한 것.'
		System.out.println(Arrays.toString(arData));


		// 배열의 값을 순서대로 출력할 때 for문 응용
		for (int i = 0; i < arData2.length; i++) {
			if(arData2[i]==3) {
				System.out.println(i+1+"번째 방에 3이 있습니다.\n");
			}
		}
		
		//향상된 for문을 통해 코딩 한줄로 출력 가능!
		for(int i:arData2) {int cnt = 1; System.out.println(cnt+"번째 값: "+i);}

	}


}
