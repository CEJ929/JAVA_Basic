package cms;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookDAO {
	PhoneBookMain pbm = new PhoneBookMain();
	static Scanner sc = new Scanner(System.in);

	String name= "";


	public void insert() {
		String phoneNum="";

		System.out.print("저장할 고객의 이름: ");
		name = sc.next();
		sc.nextLine();

		if(pbm.hm.containsKey(name)) {
			System.out.println("이미 존재하므로 저장할 수 없습니다.");
			return;
		} else {
			System.out.print("저장할 고객 전화번호: ");
			phoneNum = sc.nextLine();
			pbm.hm.put(name, phoneNum);
			System.out.println("★저장완료!★\n");

		}
	}


	public void search() {
		if(pbm.hm.size()==0) {
			System.out.println("자료가 없습니다. 자료를 입력하세요.\n");
		}else {
			System.out.print("검색하실 이름 : ");
			name = sc.next();

			if(pbm.hm.containsKey(name)) {
				System.out.println(name+"의 번호: "+pbm.hm.get(name));
				System.out.println("");
			} else {
				System.out.println("존재하지 않는 이름 입니다.\n");
			}
		}

	}

	public void show() {
		if(pbm.hm.size()==0) {
			System.out.println("자료가 없습니다. 자료를 입력하세요.\n");
		} else {
			Set keySet = pbm.hm.keySet();
			Iterator iter = keySet.iterator();

			System.out.println("-----전체 고객 조회-----");

			while(iter.hasNext()) {
				String curName = (String)iter.next(); //명시적 형변환
				
				System.out.println("이름: "+curName+"/ "
						+ "Phone: "+pbm.hm.get(curName));

			}
			System.out.println("");
		}
	}


	public void delete() {

		if(pbm.hm.size()==0) {
			System.out.println("자료가 없습니다. 자료를 입력하세요.\n");
		} else {
			System.out.print("삭제할 고객의 이름: ");
			name = sc.next();

			if(pbm.hm.containsKey(name)) {
				pbm.hm.remove(name);
				System.out.println("★삭제 완료★\n");
			} else {System.out.println("존재하지 않는 이름 입니다.");
			}

		}

	}








}

