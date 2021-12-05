package contoller;

import javax.swing.JOptionPane;

import service.StudentService;
import vo.StudentVO;

public class UpdateStdController implements Controller {

	@Override
	public void excute(int choice) {

		String updateMsg = "1. 이름\n2. 학과\n3. 평점\n4. 전체 수정\n0. 메인으로 돌아가기\n\n";
		int upKey;
		int check=0;
		String key;

		key = JOptionPane.showInputDialog("▷ 수정 할 학생 학번 입력 ◁");
		//취소버튼을 누른 경우
		if(key==null) return;


		// 입력한 학번(key)을 가진 학생이 있는지 체크
		boolean duplicate = StudentService.getInstance().duplicateCheck(key);


		// 학번을 가진 vo가 객체가 있다면
		if(duplicate) {

			// if 문으로 들어와서 그 학번을 가진 StudentVO 객체를 찾아 vo에 저장
			StudentVO vo = StudentService.getInstance().searchStd(key);

			//항목선택 화면에서 해당 학생의 현재 정보를 보여주기 위해 문자열로 저장함.
			String updateStd = ""+vo;


			while(true) {
				//업데이트 할 학생 정보 종류를 선택.

				do {

					// 취소버튼 및 문자입력 시
					try {
						upKey = Integer.parseInt(JOptionPane.showInputDialog("--학생 현재 정보--\n"+updateStd+"\n\n--수정항목선택--\n"+updateMsg));
					} catch (Exception e) {
						return;
					}


					//0일 때 메인메뉴로 돌아감
					if(upKey==0) {
						return;
					}
					//보기에 없는 이상한 번호 선택하면 무한루프
				} while(upKey<0 || upKey>4);



				//소스코드가 얼마나 길든, .이 몇개가 찍혀있던 리턴값인 그 값으로 볼 수 있어야 함.
				check = StudentService.getInstance().updateStd(upKey, vo);

				if(check==1) {
					JOptionPane.showMessageDialog(null, "★수정완료★", "Complete", JOptionPane.INFORMATION_MESSAGE);
					break;
				} else if(check==2) {
					JOptionPane.showMessageDialog(null, "!!! 등록실패 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
				} else {
					continue;
				}

			}


			//같은 학번을 가진 vo 객체가 없을시	
		}else {
			JOptionPane.showMessageDialog(null, "!!! 학생정보 없음 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}




	}

}
