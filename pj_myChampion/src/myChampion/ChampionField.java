package myChampion;

import javax.swing.JOptionPane;

public class ChampionField {
	
	//champion의 정보
		String[][]championInfo = new String [100][3];
	 
		int cnt;
		int ACnt=0;
		int AChoice = 0;
		String searchf;
		String result="";
		boolean nameInspec = true;
		
		
		
		void insert(String [] championIn) { //case 0 추가
			championInfo[cnt] = championIn;
			JOptionPane.showMessageDialog(null, "추가완료");
			cnt++; }
		
		String delete(String delName){ //case 1 삭제
			ACnt=0;
		
			for (int i = 0; i < cnt; i++) {
				if(championInfo[i][0].equals(delName)) {
					for (int j = i; j < cnt; j++) {
						championInfo[j]=championInfo[j+1];
					}
					ACnt++;
					cnt --;
				}
			}
			if(ACnt==0) {result = "찾으시는 자료가 없습니다.";}
				else{result =  "총 "+ACnt+" 건. 삭제 성공";}
			return result;
		}
		
		boolean update1(String delName){ //영웅 이름을 찾아서 목록에 있는 영웅인지 보는곳
			int upCnt = 0;
			nameInspec = true;
			for (int i = 0; i < cnt; i++) {
				if(championInfo[i][0].equals(delName)) {
					AChoice = i;
					upCnt++;} 
				}
			if (upCnt==0) nameInspec=false;
			return nameInspec;
					}
		
		String update(int choice){ //공/방 수정 영역
			String upV="";
			result="";
			String oldChampion="";
			
			if(choice==0) {
				upV = String.valueOf(JOptionPane.showInputDialog("공격력을 얼마로 수정합니까?"));
					if(championInfo[AChoice][1].equals(upV)) {
					result = "같은 값으로 변경할 수 없습니다.";
						} else {
							oldChampion = championInfo[AChoice][1];
							championInfo[AChoice][1]=upV;
							result = "★정보 수정 완료★\n기존 공격력: "
									+ oldChampion+"\n변경된 공격력: "+championInfo[AChoice][1];  }
				}
			
			else if(choice==1) {
				upV = String.valueOf(JOptionPane.showInputDialog("방어력을 얼마로 수정합니까?"));
				if(championInfo[AChoice][1].equals(upV)) {
						result = "같은 값으로 변경할 수 없습니다.";
					} else {
				oldChampion = championInfo[AChoice][2];
				championInfo[AChoice][2]=upV;
				result = "★정보 수정 완료★\n기존 방어력: "
				+ oldChampion+"\n변경된 방어력: "+championInfo[AChoice][2];    }
			} 
			return result;
		}
		
		
		
		//case3 항목별 검색
		String search(int choice){
			String sResult ="";
			ACnt=0;
			
			switch(choice) {
			
			case 0: 
				searchf = JOptionPane.showInputDialog("검색하실 이름을 입력하세요.");
				sResult = "NAME/ POWER / DEFENSE\n";
				 for (int i = 0; i < cnt; i++) {
						if(championInfo[i][0].equals(searchf)) {
							ACnt++;
							sResult+="★ ";
					for (int j = 0; j < championInfo[0].length; j++) {
					 sResult+=championInfo[i][j]+"  ";
						if (j == championInfo[0].length-1) {sResult+="\n"; }
						}
					}
				 }
				 if(cnt==0) {sResult="자료가 없습니다. \n 먼저 자료를 입력하세요";}
				 if(cnt>1 && ACnt==0) {sResult = "총 "+cnt+" 건의 자료중 찾으시는 결과는 없습니다.";}
				break;
				
				
			case 1:
				searchf = String.valueOf((JOptionPane.showInputDialog("검색하실 공격력을 입력하세요.")));
				sResult = "NAME/ POWER / DEFENSE\n";
				 for (int i = 0; i < cnt; i++) {
						if(championInfo[i][1].equals(searchf)) {
							ACnt++;
							sResult+="★ ";
					for (int j = 0; j < championInfo[0].length; j++) {
					 sResult+=championInfo[i][j]+"  ";
						if (j == championInfo[0].length-1) {sResult+="\n"; }
						}
					}
				 }
			
				if(cnt>1 && ACnt==0) {sResult = "총 "+cnt+" 건의 자료중 찾으시는 결과는 없습니다.";} 
				break;
				
			case 2:
				searchf = String.valueOf((JOptionPane.showInputDialog("검색하실 방어력을 입력하세요.")));
				sResult = "NAME/ POWER / DEFENSE\n";
				 for (int i = 0; i < cnt; i++) {
						if(championInfo[i][2].equals(searchf)) {
							ACnt++;
							sResult+="★ ";
					for (int j = 0; j < championInfo[0].length; j++) {
					 sResult+=championInfo[i][j]+"  ";
						if (j == championInfo[0].length-1) {sResult+="\n"; }
						}
					}
				 }
				 if(cnt==0) {sResult="자료가 없습니다. \n 먼저 자료를 입력하세요";}  
				if(cnt>1 && ACnt==0) {sResult = "총 "+cnt+" 건의 자료중 찾으시는 결과는 없습니다.";} 
				break;
				}
			return sResult;
		}
		
		
		String show(){ //case 4 전체조회
			 result = "NAME/ POWER / DEFENSE\n";
			for (int i = 0; i < cnt; i++) {
				result+=(i+1)+". ";
				for (int j = 0; j < championInfo[0].length; j++) {
					if(j==championInfo[0].length-1) {result+=championInfo[i][j]+"\n";}
					else {result+=championInfo[i][j]+" / ";}
				}
			}
			if (cnt==0) {result = "자료가 없습니다. \n 먼저 자료를 입력하세요";}
			return result;
			}


}
