package contoller;

import javax.swing.JOptionPane;

import service.StudentService;
import vo.StudentVO;

public class DeleateStdController implements Controller {

	@Override
	public void excute(int choice) {
		
		String key;
		key = JOptionPane.showInputDialog("▷ 삭제 할 학생 학번 입력 ◁");
		
		//취소버튼을 누른 경우
		if(key==null) return;

		//list에 네가 찾는 그 학번이 있니? (어디 있는지는 모르지만 일단 있니?)
		boolean duplicate = StudentService.getInstance().duplicateCheck(key);
		
		
		// 응 있어
		if(duplicate) {
			// 그렇다면 그 객체를 찾아서 vo에 저장하겠어
			StudentVO vo = StudentService.getInstance().searchStd(key);
			
			
			if(StudentService.getInstance().deleteStd(vo)) {
				JOptionPane.showMessageDialog(null, "★삭제완료★", "Complete", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "!!! 삭제실패 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "!!! 학생정보 없음 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}

}
