package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import dto.StudentVO;



public class ScoreDAO {
	//과목 개수
	public final int  SUBJECTSIZE = 3;

	public Scanner sc = new Scanner(System.in);

	// arraylist 국영수 점수. 근데 과목이 저거뿐이야? 늘어날 수도 있잖아! = 동적배열 
	private ArrayList<Integer>arScore = null;

	//그게 누구의 점수야? 타입을 그 학생 객체로 받아버린다.
	private ArrayList<StudentVO> arStudent = null;

	//학생정보와 점수등을 담을 저장소 역할
	private LinkedHashMap<StudentVO, ArrayList<Integer>> smsMap
	= new LinkedHashMap<StudentVO, ArrayList<Integer>>();


	public void index() {



		while(true) {
			int choice = 0;
			//메인 뷰 단
			System.out.println("학생 관리 시스템");
			System.out.println("1. 등록");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 수정");
			System.out.println("5. 종료");

			choice = sc.nextInt();
			sc.nextLine(); // 엔터상쇄



			if(choice==5) {System.out.println("종료합니다."); break;}


			switch(choice) {

			case 1: join();
			break;

			case 2: search();
			break;

			case 3: delete();
			break;

			case 4: update();
			break;


			default: 
				System.out.println("잘못 입력 하셨습니다."); continue;

			}
			break;
		}

	}



	public void join() {
		String isQuit = "";

		while(true){

			System.out.println("======[학생 정보 입력(종료는 q)]======");

			System.out.println("이름: "); 
			String name = sc.nextLine();

			System.out.print("나이: "); 
			int age = sc.nextInt();
			sc.nextLine(); //enter를 상쇄시킨다.

			StudentVO std = new StudentVO(name, age);
			arStudent = new ArrayList<StudentVO>();
			arScore = new ArrayList<Integer>();

			arStudent.add(std);

			System.out.println("====[국어 영어 수학의 점수를 입력하세요.]===="
					+ "\n100 90 20");

			for (int i = 0; i < SUBJECTSIZE; i++) {
				arScore.add(Integer.parseInt(sc.next()));
			}

			smsMap.put(std, arScore);
			System.out.println("입력완료\n--------------------");

			System.out.print("종료?");
			sc.nextLine(); //점수 입력 후 enter 상쇄
			isQuit = sc.nextLine();
			if(isQuit.equals("q")) break;

		}
		//or isQuit.intern()!="q"


		index();
	}




	public void list(LinkedHashMap<StudentVO, ArrayList<Integer>>db) {
		//선생님은 이상하게 나오는데.. 나는 왜 잘 나오는 걸까? 
		Set<Entry<StudentVO, ArrayList<Integer>>> set = db.entrySet();

		Iterator<Map.Entry<StudentVO, ArrayList<Integer>>>iter 
		= set.iterator();

		int size = smsMap.size();
		if(size==0) {
			System.out.println("등록된 학생이 없습니다.\n");
		} else {

			System.out.println("========[학생 목록]========");


			while(iter.hasNext()) {
				Entry<StudentVO, ArrayList<Integer>> temp = iter.next();
				temp.getKey().show();
				System.out.println("\t국어 \t영어 \t수학");
				System.out.print("");
				for(int score: temp.getValue()) {
					System.out.print("\t"+score+"점");
				}
				System.out.println("\n");
			}

		} 
	}




	public void search() {

		if(smsMap.size()==0) {
			System.out.println("등록된 학생이 없습니다.\n");
			index();
		}else {


			int scCnt = 0;
			Set<StudentVO> scoreSet = smsMap.keySet();

			Iterator<StudentVO> iter = scoreSet.iterator();

			String name = null;



			while(true) {

				System.out.println("검색할 학생의 이름을 입력하세요. (종료q)");
				System.out.print("검색 이름: ");
				name = sc.nextLine();

				if(name.equals("q")) index();


				for(int i=0; i<smsMap.size();i++) {
				StudentVO std = iter.next();

				if(name.equals(std.getName())) {
					scCnt++;

					System.out.println("==========[검색 결과]==========");

					std.show();
					System.out.println("\t국어 \t영어 \t수학");
					System.out.print("");

					for(int score: smsMap.get(std)) {
						System.out.print("\t"+score+"점");
					}
					System.out.println("\n");
				} 
				else if(scCnt==0) {
					System.out.println("검색 결과가 없습니다.\n");
					continue;
				}
				}

			}
		}

	}



	public void update() {

		if(smsMap.size()==0) {
			System.out.println("등록된 학생이 없습니다.\n");
			index();
			} else {
				
				list(smsMap);
				
				int num = 0, uChoice = 0;
				boolean ck = false;

				System.out.print("수정 할 학생의 번호: ");
				num = sc.nextInt();

				System.out.println("1. 정보 수정	2. 점수 수정	3.뒤로가기=0번");
				uChoice = sc.nextInt();

				if(uChoice==0) index();
				sc.nextLine();

				Iterator<StudentVO>iter = smsMap.keySet().iterator();

				while(iter.hasNext()) {

					StudentVO std = iter.next();
					if(num==std.getNumber()) {
						ck = true;

						switch(uChoice) {

						case 1:
							System.out.println("이름과 나이를 순서대로 입력하세요.");
							std.setName(sc.next());
							std.setAge(Integer.parseInt(sc.next()));
							sc.nextLine(); //enter상쇄
							System.out.println("수정완료");

							break;

						case 2: 
							System.out.println("국어 영어 수학 점수를 순서대로 입력하세요.");

							for (int i = 0; i < SUBJECTSIZE; i++) {
								smsMap.get(std).set(i, sc.nextInt());
							}
							sc.nextLine();
							System.out.println("수정완료");

							break;

						default: System.out.println("수정 실패"); ck = false;

						}

					}


				}
				if(!ck) {
					System.out.println("해당 번호의 학생이 없습니다.");
				}

				list(smsMap);
			}

	}



	public void delete () {

		if(smsMap.size()==0) {
			System.out.println("등록된 학생이 없습니다.\n");
			index();
		} else {
			int dChoice=0;
			StudentVO delStd = null;
			//		Set<StudentVO> numSet = smsMap.keySet();
			//		Iterator<StudentVO> iter = numSet.iterator();
			Iterator<StudentVO> iter2 = smsMap.keySet().iterator(); 
			//두 문장을 하나로 .. !!!! 굳이 set을 안쓰고도..!


			while(iter2.hasNext()) {
				System.out.println("삭제하실 학생의 번호를 입력하세요.(뒤로가기 = 0)");
				dChoice = sc.nextInt();


				if (dChoice ==0) index();
				else if(dChoice> StudentVO.getSeq()) {
					System.out.println("다시 입력하세요.(뒤로가기 = 0)");
					continue;
				}

				StudentVO std = iter2.next();

				if(dChoice == std.getNumber()) {
					System.out.println(dChoice+"번 학생을 삭제합니다.");
					//	iter.remove();
					delStd = std;

				}

			}
			smsMap.remove(delStd);

		}
	}

}

