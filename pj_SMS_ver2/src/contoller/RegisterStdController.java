package contoller;

import javax.swing.JOptionPane;

import service.StudentService;
import vo.StudentVO;

public class RegisterStdController implements Controller {

	@Override
	public void excute(int choice) {
		
		StudentVO vo=null;
		String [] tmpStd = new String[4];
		
		String registerMsg = "학번/이름/전공과목/평점\n(/)로 구분하여 입력하세요.";
		
		//값을 제대로 입력하거나, 취소버튼을 누른 경우가 아니라면 학생등록 화면으로 돌아오기
		//위해 무한루프 사용
		while(true) {
			
			//예외처리: 취소버튼을 누른 경우 _ 메인화면으로
		
			
				try {
					tmpStd = JOptionPane.showInputDialog(registerMsg).split("/");
				} catch (NullPointerException e1) {
					return;
				}
		
			
	
		
				
		//예외처리: 값을 양식에 맞게 입력하지 않은 경우 _ 학생등록으로
		try {
			vo = new StudentVO(tmpStd[0], tmpStd[1], tmpStd[2], Double.parseDouble(tmpStd[3]));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "!!! 값을 바르게 입력하세요. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			continue;
		}
		
		
		//위 예외에 해당하는 경우가 없을 때 메서드 정상 종료.
		if(StudentService.getInstance().registStd(vo)) {
			JOptionPane.showMessageDialog(null, "★등록완료★", "Complete", JOptionPane.INFORMATION_MESSAGE);
			break;
		} else {
			JOptionPane.showMessageDialog(null, "!!! 등록실패 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
		}
		
	}

}
