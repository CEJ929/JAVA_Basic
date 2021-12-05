package contoller;

import javax.swing.JOptionPane;

import service.StudentService;
import vo.StudentVO;

public class SearchStdController implements Controller {

	@Override
	public void excute(int choice) {
		StudentVO vo = new StudentVO();
		
		String key;
		
			key = JOptionPane.showInputDialog("▷ 검색 학번 입력 ◁");
			
			//취소버튼을 누른 경우
			if(key==null) return;
	
		//학번으로 객체를 찾아와 vo에 저장
		vo= StudentService.getInstance().searchStd(key);
		
		if( vo == null) {
			JOptionPane.showMessageDialog(null, "!!! 검색결과 없음 !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null,"▶ 검색 결과 ◀\n"+vo); 
		}
	}

}
