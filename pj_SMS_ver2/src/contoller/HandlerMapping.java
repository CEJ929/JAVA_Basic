package contoller;

import javax.swing.JOptionPane;

import service.StudentService;

public class HandlerMapping {

	//==========싱글톤영역================================
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping () {}

	public static HandlerMapping getInstance() {
		if(instance==null) instance = new HandlerMapping();
		return instance;
	}


	
	public  Controller createController(int choice) {
		
		Controller controller = null;

		if(choice!=0 && StudentService.getInstance().getList().size()==0) {
			JOptionPane.showMessageDialog(null, "!!! 학생등록부터 하세요. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {

			switch(choice) {

			// 추가
			case 0:
				controller = new RegisterStdController();
				break;
				// 검색
			case 1:
				controller = new SearchStdController();
				break;
				// 수정
			case 2:
				controller = new UpdateStdController();
				break;
				// 삭제
			case 3:
				controller = new DeleateStdController();
				break;
				// 전체출력
			case 4:
				controller = new AllShowStdController();
				break;

			}

		}

		return controller;
	}


}
