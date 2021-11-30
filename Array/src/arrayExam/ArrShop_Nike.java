package arrayExam;

/*
 *2차원 배열 
 * 
 : 2차원 (행, 열) (가로, 세로)
 : 3차원 (면, 행, 열)
 : 4차원 (의, 면, 행, 열)
 * 
 */

import javax.swing.JOptionPane;

public class ArrShop_Nike {
	
	//나이키
		// 강남점, 홍대점, 명동점
		//성인, 키즈
		//강남점k, 홍대점k, 명동점k
		// 강남점a, 홍대점a, 명동점a

		public static void main(String[] args) {

			int[][]arrIncome = new int[2][3]; // 매출액 입력 배열

			String[][]arrName = {//2행 3열 2차원 배열 생성

					{"강남점A", "홍대점A", "명동점A"},
					{"강남점K", "홍대점K", "명동점K"}

			};



			String[]arAName = {"성인", "키즈"};
			String[]arBName = {"강남점", "홍대점", "명동점"};

			int []arASum = new int[2]; //강홍명A매출총합,     강홍명K매출총함
			int []arBSum = new int[3]; // 강AK,    홍AK,    명AK
			int sum = 0; // 총합

			
			int rLength = arrIncome.length;  //2 매출액 배열의 행 길이
			int cLength = arrIncome[0].length; // 3 매출액 배열의 열

			
			double[] arAAvg = new double[2];  //성인매출 평균 ,    키즈매출평균
			double[] arBAvg = new double[3]; // 강남의 평균,   홍대의 평균,    명동의 평균
			double avg = 0.0; //총 평균

			
			String inputMsg = "매출액을 입력하세요.";
			String result = "--------------------------\n";


			//매장별 성인, 키즈 매출액 입력 및 합 구하는 곳 (이중for문)
			for (int i = 0; i < rLength; i++) {
				for (int j = 0; j < cLength ; j++) {
					arrIncome[i][j] = Integer.parseInt(JOptionPane.showInputDialog(arrName[i][j]+" "+inputMsg));
					arASum[i] += arrIncome[i][j];
					arBSum[j] +=arrIncome[i][j];
					sum+=arrIncome[i][j];
				}
			}

			
			//평균 (for문을 따로 2개씀)
			for (int i = 0; i < rLength; i++) { //연령 매출 평균 값 2개
				arAAvg[i] = Double.parseDouble(String.format("%.2f", (double) (arASum[i]/cLength)));
			}
			for (int i = 0; i < cLength; i++) { //매장별 매출 평균 값 3개
				arBAvg[i] = Double.parseDouble(String.format("%.2f", (double) (arBSum[i]/rLength)));
			}
			avg = Double.parseDouble(String.format("%.2f", (double)sum / (rLength*cLength) ));



			//최종 출력문 만들기 result 에 값 누적
			for (int i = 0; i < rLength; i++) {
				for (int j = 0; j < cLength; j++) {
					result += arrName[i][j] + " 매출액 :" + arrIncome[i][j]+"만원\n";
				}


				//연령별 매출액
				result +=  arAName[i]+" 총 매출액 : " +arASum[i] + "만원\n";
				result += arAName[i]+" 평균 매출액 : "+ arAAvg[i]+"만원\n";
				result += "--------------------------\n";
			}


			//매장별 매출액
			for (int i = 0; i < arBSum.length; i++) {
				result += arBName[i]+" 총 매출액"+arBSum[i]+"만원\n";
				result += arBName[i]+" 평균 매출액 : "+arBAvg[i]+"만원\n";
			}
			result += "--------------------------\n";

			result += " 총 매출액: "+sum+"만원\n";
			result += " 평균 매출액"+avg+"만원\n";
			result += "--------------------------\n";
			JOptionPane.showMessageDialog(null, result);
		}



}
