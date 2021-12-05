package service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import vo.StudentVO;

public class StudentService {

	//싱글톤 구현부
	private static StudentService instance = new StudentService();

	private StudentService() {};

	public static StudentService getInstance() {
		if (instance == null) instance = new StudentService();
		return instance; 
	}



	//studentVO 타입으로 객체arrayList 선언
	//list.size==0 으로 등록된 정보가 없음을... 밖에 Controller 부분에서 
	// 확인할 수 있게 하려고 private static 선언 후 getter 로만 접근 가능하게 함.
	private static ArrayList<StudentVO> list = new ArrayList<>();


	public ArrayList<StudentVO> getList() {
		return list;
	}




	//=========================기능부==============================================

	//--------------------------------학생등록 영역
	// 매개변수 vo 객체의 적합성을 (평점범위, 중복) 검사한 후 list.add
	// 검사에서 걸리면 false 리턴, 걸리지 않으면 마지막에 add후 true 리턴
	public boolean registStd(StudentVO vo) {

		if(duplicateCheck(vo.getStdNo())) {
			JOptionPane.showMessageDialog(null, "!!! 학번이 중복됩니다. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(!gradeCheck(vo)) {
			JOptionPane.showMessageDialog(null, "!!! 평점은 4.5~0 사이입니다. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		list.add(vo);
		return true;
	}


	//	-------------------------------------수정영역
	//정보 수정 영역
	// 수정성공	리턴 1
	// 수정실패	리턴 2
	// 수정 중 예외발생(평점에 문자입력, 취소버튼, 전체 수정시 양식miss)	리턴 3
	//리턴 1,2의 경우 메인 뷰단으로 이동되고
	// 리턴 3의 경우 수정항목 선택 단으로 이동된다.
	//뒤로가기, 메인으로 이동(수정성공, 수정실패) 경우의 수가 3가지이기 때문에 리턴타입 boolean --> int 로 바꿈.


	//int 수정학목	수정할 학생정보
	public int updateStd(int upKey, StudentVO vo) {


		int idx=0;

		//수정할 학생 정보가 list의 어느 인덱스에 있는지 인덱스 정보 가져옴
		//list에 있다는 것 자체는 UpdateController 에서 확인했음.
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getStdNo().equals(vo.getStdNo())) { 
				idx = i;
				break;
			} 
		}


		//수정할 항목별로..
		switch(upKey) {

		//이름
		case 1:

			vo.setName(JOptionPane.showInputDialog("▷수정할 이름◁"));
			if(vo.getName()==null) return 3; //취소버튼 누른 경우

			list.set(idx, vo);
			return 1;

			//학과	
		case 2:
			vo.setDepartment(JOptionPane.showInputDialog("▷수정할 학과◁"));
			if(vo.getDepartment()==null) return 3; // //취소버튼 누른 경우

			list.set(idx, vo);
			return 1;


			//평점	
		case 3:

			//double타입이기 때문에 문자가 입력됐을 경우 예외발생 
			//예외1: 평점 입력양식 오류(문자)	리턴 3
			// 예외2: 취소버튼				리턴 3

			try {
				vo.setGrade(Double.parseDouble(JOptionPane.showInputDialog("▷수정할 평점◁")));
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "!!! 평점은 4.5~0 사이입니다. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
				return 3;
			} catch(NullPointerException e3) {
				return 3;
			}


			//평점이 double 형에 맞으나 값의 범위가 잘못된 경우
			if(gradeCheck(vo)) {
				list.set(idx, vo);
				return 1;
			} else {
				JOptionPane.showMessageDialog(null, "!!! 평점은 4.5~0 사이입니다. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
				return 2;
			}


			//전체	
		case 4:
			String[]tmpStd = new String[3];

			//취소버튼	리턴 3
			try {
				tmpStd = JOptionPane.showInputDialog("이름/전공과목/평점\n(/)로 구분하여 입력하세요.").split("/");
			} catch (Exception e1) {
				return 3;
			}


			//값을 양식에 맞지 않게 입력한 경우	리턴 3
			try {
				vo.setName(tmpStd[0]);
				vo.setDepartment(tmpStd[1]);
				vo.setGrade(Double.parseDouble(tmpStd[2]));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "!!! 값을 바르게 입력하세요. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
				return 3;
			}


			//평점이 double 형에 맞으나 값의 범위가 잘못된 경우
			if(gradeCheck(vo)) {
				list.set(idx, vo);
				return 1;
			} else {
				JOptionPane.showMessageDialog(null, "!!! 평점은 4.5~0 사이입니다. !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		// 위 모든 경우에서 수정 후 리턴 1 이 안되면 수정실패로 처리.
		return 2;

	}



	//---------------------검색 / 삭제 / 전체조회---------------------------------


	//검색
	public StudentVO searchStd(String key) {

		StudentVO vo = null;

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getStdNo().equals(key)) { 
				vo = list.get(i);
				return vo;
			} 
		}
		return vo;
	}


	//삭제 (제일 쉽다 휴)
	public boolean deleteStd(StudentVO vo) {
		String [] deleteBtn = {"네(YES)", "아니오(NO)"};
		int choice=0;

		choice = JOptionPane.showConfirmDialog(null, deleteBtn);
		
		System.exit(choice);
		
		if(choice==0) { 
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(vo)) {
					list.remove(i);
					return true;
				}
			}
		}

		return false;
	}


	//전체조회
	//ArrayList에 순서번호가 저장되어있지 않고
	//Controller의 역할을 명확히 하기 위해
	// Service에서 바로 출력하지 않고 String타입에 누적하여 전달.
	// Controller에서 String 출력.
	public String allShowStd() {

		String result = "";

		for (int i = 0; i < list.size(); i++) {
			result += "-----<"+(i+1)+">-----\n"+list.get(i)+"\n";
		}

		return result;
	}





	//===============메뉴를 도와주는 보조 메서드==================================

	//학번 중복 검사
	//수정, 삭제 부분에서 계속 쓸거라 따로 메서드 만들었음.

	//학번 중복검사의 목적 (중복값이 있으면 true, 없으면 false 반환)
	// 1) 등록: 리턴값 true 일 때 등록 불가
	// 2) 수정, 삭제: 리턴값 true 일 때 수정, 삭제 가능
	// 두 경우 true 에서 처리 방식이 반대이므로 헷갈릴까봐 적어둠.
	public boolean duplicateCheck(String key) {

		for (int i = 0; i < list.size(); i++) {

			if(list.get(i).getStdNo().equals(key)) return true;

		}
		return false;
	}



	//학점 범위 체크
	// 등록과 수정에서 동시에 사용하니까 메서드로 만들었음.
	public boolean gradeCheck(StudentVO vo) {
		if(vo.getGrade()>4.5 || vo.getGrade()<0) return false;
		return true;
	}



}
