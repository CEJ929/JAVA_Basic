package example;
//정수를 한글로 바꾸는 메서드

public class ChangeHangel {
	
public static void main(String[] args) {
		
		ChangeHangel ch = new ChangeHangel();
		
		ch.changeHan(5498);
	}
	
	

	
	void changeHan(int data){ 
		
		String hangle = "공일이삼사오육칠팔구"; //출력할 문자의 배열
		String result = "";

		//정수를 ""붙여서 문자열로 자동형변환 하여 temp 에 저장 (ex. 1234 -> "1234")
		String temp = ""+data;
		

		for (int i = 0; i < temp.length(); i++) {//여기서 temp.length() = 4
			result += hangle.charAt(data%10);
			// String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해주는 녀석

			//1024/10의 나머지 4를 char타입으로 바꾸고 
			// hangle의 4번(다섯번째) index의 값을 result에 string으로 저장
			
			data /= 10; //102 -> 10 ->1->0

		}
		for (int i = temp.length()-1;i>-1;i--) {
			System.out.print(result.charAt(i)+", ");
		}
	}


}
