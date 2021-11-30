package myChampion;

import javax.swing.JOptionPane;

public class ChampionGo {

	public static void main(String[] args) {

		ChampionField cf = new ChampionField();

		String insertMsg = "영웅의 정보를 입력하세요. \n(이름/공격력/방어력)";
		String delMsg = "삭제하실 영웅의 이름을 입력하세요.";
		String upMsg = "수정하실 영웅의 이름을 입력하세요.";

		String []searchMsg = {"이름", "공격력","방어력","뒤로가기"};
		String[]upMenu = {"공격력", "방어력","뒤로가기"};
		String[]menu = {"영웅 추가","영웅 삭제","영웅 정보 수정", "영웅 검색","전체 조회"};



		String []championIn = new String[3];
		int choice = 0;
		String delName="";



		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "Champion Information Center",
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, menu, null);
			if(choice==-1) break;

			switch(choice) {

			case 0: //추가하기
				championIn=	JOptionPane.showInputDialog(insertMsg).split("/");
				cf.insert(championIn);
				break;

			case 1: //삭제하기
				if(cf.cnt==0) {
					JOptionPane.showMessageDialog(null, "자료가 없습니다. \n 먼저 자료를 입력하세요");	}
				else {
					delName =JOptionPane.showInputDialog(delMsg);
					JOptionPane.showMessageDialog(null, cf.delete(delName)); }
				break;


			case 2://수정
				if(cf.cnt==0) {
					JOptionPane.showMessageDialog(null, "자료가 없습니다. \n 먼저 자료를 입력하세요");   
					break;}
				else { delName = JOptionPane.showInputDialog(upMsg);}

				if(cf.update1(delName)) {
					choice = JOptionPane.showOptionDialog(null, "수정하실 항목을 선택하세요.", 
							"Champion Information Center", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.PLAIN_MESSAGE, null, upMenu, null);
				} else {
					JOptionPane.showMessageDialog(null, "찾으시는 영웅이 없습니다.");  break;}

				if(choice>=2) {JOptionPane.showMessageDialog(null,"돌아갑니다.");  break;}
				else {
					JOptionPane.showMessageDialog(null, cf.update(choice)); }

				break;


			case 3: //검색
				if(cf.cnt==0) {
					JOptionPane.showMessageDialog(null, "자료가 없습니다. \n 먼저 자료를 입력하세요");	}
				else {
					choice = JOptionPane.showOptionDialog(null, "검색하실 메뉴를 선택하세요", 
							"Champion Information Center", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, searchMsg, null);

					if (choice==3) 			break;
					JOptionPane.showMessageDialog(null, cf.search(choice));
				}
				break;


			case 4: //전체조회
				JOptionPane.showMessageDialog(null, cf.show());
				break;

			}

		}
	}


}
