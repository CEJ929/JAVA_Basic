package contoller;

import javax.swing.JOptionPane;

import service.StudentService;

public class AllShowStdController implements Controller {

	@Override
	public void excute(int choice) {
		String result = StudentService.getInstance().allShowStd();
		JOptionPane.showMessageDialog(null, result, "COMPLETE", JOptionPane.DEFAULT_OPTION);
	}

}
