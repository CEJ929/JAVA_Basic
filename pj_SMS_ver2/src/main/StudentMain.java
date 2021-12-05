package main;

import javax.swing.JOptionPane;

import contoller.Controller;
import contoller.HandlerMapping;

public class StudentMain {
	public static void main(String[] args) {
		
		
		int choice;
		String[] mainMsg = {"1. 학생 등록", "2. 학생 검색", 
				"3. 학생정보 수정","4. 학생정보 삭제", "5. 전체 정보 출력", "0. 종료"};
		
		while(true) {
			
			choice = JOptionPane.showOptionDialog(null, "<<학생관리 시스템 입니다. 메뉴를 선택하세요.>>", 
					"Student Management System", 0, JOptionPane.INFORMATION_MESSAGE, null, mainMsg, mainMsg.length);
			
		
			if(choice==-1|| choice==5) break;
			Controller controller = HandlerMapping.getInstance().createController(choice);
			
			if(controller != null) controller.excute(choice);
			
		}



	}
}
