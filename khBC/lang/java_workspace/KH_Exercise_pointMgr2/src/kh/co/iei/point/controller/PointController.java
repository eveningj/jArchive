package kh.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.model.vo.Gold;
import kr.co.iei.point.model.vo.SearchResult;
import kr.co.iei.point.model.vo.Silver;
import kr.co.iei.point.model.vo.Vip;

public class PointController {
	Scanner sc;
	// 2차원 배열 활용해서 만들면 안되는건지?
	// members 배열의 silver, gold, vip (members 타입)
	Silver[] sMembers;
	int sIndex;
	Gold[] gMembers;
	int gIndex;
	Vip[] vMembers;
	int vIndex;

	public PointController() {
		super();
		sc = new Scanner(System.in);
		sMembers = new Silver[10];
		gMembers = new Gold[10];
		vMembers = new Vip[10];
		sIndex = 0;
		gIndex = 0;
		vIndex = 0;

		Silver s1 = new Silver("silver", "회원1", 1000);
		Silver s2 = new Silver("silver", "회원2", 2000);
		Gold g1 = new Gold("gold", "회원3", 1000);
		Gold g2 = new Gold("gold", "회원4", 2000);
		Vip v1 = new Vip("vip", "회원5", 1000);
		Vip v2 = new Vip("vip", "회원6", 2000);
		sMembers[sIndex++] = s1;
		sMembers[sIndex++] = s2;
		gMembers[gIndex++] = g1;
		gMembers[gIndex++] = g2;
		vMembers[vIndex++] = v1;
		vMembers[vIndex++] = v2;
	}

	public void main() {
		while (true) {
			System.out.println("\n----------------- 회원 관리 프로그램v2 -----------------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 정보 출력");
			System.out.println("3. 회원 1명 정보 출력");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선 택 > >   ");
			int select = sc.nextInt();
			switch (select) {
			case 1 -> {
				insertMember();
			}
			case 2 -> {
				printAllMember();
			}
			case 3 -> {
				printOneMember();
			}
			case 4 -> {
				updateMember();
			}
			case 5 -> {
				deleteMember();
			}
			case 0 -> {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			default -> {
				System.out.println("잘못 입력하셨습니다.");
			}
			}// switch
		} // while().
	}// main().

	public void printAllMember() {
		System.out.println("\n----------------- 전체 회원 출력 -----------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------------------------");
		// 회원은 등급별로 각각 다른 배열에 저장되어있음
		// 모든 배열을 다 출력
		// 실버등급 회원 출력 -> sMembers 에 있는 회원 출력
		for (int i = 0; i < sIndex; i++) {
			Silver s = sMembers[i];
			String grade = s.getGrade();
			String name = s.getName();
			int point = s.getPoint();
			double bonus = s.getBonus();
			System.out.println(grade + "\t" + name + "\t" + point + "\t" + bonus);
		}

		for (int i = 0; i < gIndex; i++) {
			Gold g = gMembers[i];
			String grade = g.getGrade();
			String name = g.getName();
			int point = g.getPoint();
			double bonus = g.getBonus();
			System.out.println(grade + "\t" + name + "\t" + point + "\t" + bonus);
		}

		for (int i = 0; i < vIndex; i++) {
			Vip v = vMembers[i];
			System.out.println(v.getGrade() + "\t" + v.getName() + "\t" + v.getPoint() + "\t" + v.getBonus());
		}
	}// printAllMember().

	public void insertMember() {
		System.out.println("\n----------------- 회원 정보 등록 -----------------\n");
		// 등급, 이름, 포인트를 입력받아서 회원 추가
		// 입력받은 등급이 silver면 Silver 객체 생성해서 sMembers 에 저장
		// 입력받은 등급이 gold면 Gold객체 생성해서 gMembers 에 저장
		// 입력받은 등급이 vip면 Vip객체 생성해서 vMembers 에 저장
		// 등급을 잘못 입력하는 경우는 없다고 가정

		System.out.print("등록할 회원 등급 입력 [silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("등록할 회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록할 회원 포인트 입력 : ");
		int point = sc.nextInt();

		switch (grade) {
		case "silver" -> {
			Silver s = new Silver(grade, name, point);
			sMembers[sIndex] = s;
			sIndex++;
		}
		case "gold" -> {
			Gold g = new Gold(grade, name, point);
			gMembers[gIndex] = g;
			gIndex++;

		}
		case "vip" -> {
			Vip v = new Vip(grade, name, point);
			vMembers[vIndex] = v;
			vIndex++;
		}
		default -> {
			System.out.println("잘못된 입력입니다.");
		}

		}// switch

		/*
		 * if (grade.equals("silver")) { sMembers[sIndex] = new Silver(grade, name,
		 * point); sIndex++; } else if (grade.equals("gold")) { gMembers[gIndex] = new
		 * Gold(grade, name, point); gIndex++; } else if (grade.equals("vip")) {
		 * vMembers[vIndex] = new Vip(grade, name, point); vIndex++; }else { //
		 * System.out.println("잘못된 입력입니다. [silver/gold/vip] 중 하나의 입력을 해주세요."); }
		 */

	}// insertMember().

	public void printOneMember() {
		System.out.println("\n----------------- 회원 1명 출력 -----------------\n");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember(name);
		if (result == null) {
			System.out.println("회원 정보를 조회할 수 없습니다.");
		} else {
			String type = result.getType();
			int i = result.getIndex();
			if (type.equals("silver")) {
				Silver s = sMembers[i];
				System.out.println("회원 등급 : "+s.getGrade());
				System.out.println("회원 이름 : "+s.getName());
				System.out.println("회원 포인트: "+s.getPoint());
				System.out.println("회원 보너스: "+s.getBonus());
			} else if (type.equals("gold")) {
				Gold g = gMembers[i];
				System.out.println("회원 등급 : "+g.getGrade());
				System.out.println("회원 이름 : "+g.getName());
				System.out.println("회원 포인트: "+g.getPoint());
				System.out.println("회원 보너스: "+g.getBonus());
			} else if (type.equals("vip")) {
				Vip v = vMembers[i];
				System.out.println("회원 등급 : "+v.getGrade());
				System.out.println("회원 이름 : "+v.getName());
				System.out.println("회원 포인트: "+v.getPoint());
				System.out.println("회원 보너스: "+v.getBonus());

			}
		}

		/*
		 * int searchIndex = searchMember(name); if(searchIndex == -1) {
		 * System.out.println("회원 정보를 조회할 수 없습니다."); }else { //1.INDEX TUNING 일 때 //
		 * Fields => index range 설정. //받은 숫자가 0~9 사이면 sMembers //받은 숫자가 10~19 사이면
		 * gMembers //받은 숫자가 20~29 사이면 vMembers /*if(0<=searchIndex && searchIndex<=9) {
		 * Silver s = sMembers[searchIndex]; System.out.println("등급 : " + s.getGrade());
		 * } else if(searchIndex/10 ==1) //--> 정수 연산 활용. { Gold g =
		 * gMembers[searchIndex-10]; System.out.println("등급 : " + g.getGrade()); } else
		 * if(searchIndex/10 ==2) //--> 정수 연산 활용. { Vip v = vMembers[searchIndex-20];
		 * System.out.println("등급 : " + v.getGrade()); } }//else
		 */
	}// printOneMember();

	public SearchResult searchMember(String name) {
		for (int i = 0; i < sIndex; i++) {
			Silver s = sMembers[i];
			if (s.getName().equals(name)) {
				SearchResult result = new SearchResult("silver", i);
				return result;
			} // if();
		} // for();
		for (int i = 0; i < gIndex; i++) {
			Gold g = gMembers[i];
			if (g.getName().equals(name)) {
				SearchResult result = new SearchResult("gold", i);
				return result;
			} // if();
		} // for();
		for (int i = 0; i < vIndex; i++) {
			Vip v = vMembers[i];
			if (v.getName().equals(name)) {
				SearchResult result = new SearchResult("vip", i);
				return result;
			} // if();
		} // for();
		return null;

	}// searchMember();

	public int searchMemberIndex(String name) {
		// '어떤 배열' 몇번째인지 명시가 안됨.
		// 정보 하나를 리턴하기 때문.

		// SEARCH LOGIC
		// 1. INDEX RANGE

		for (int i = 0; i < sIndex; i++) {
			Silver s = sMembers[i];
			if (s.getName().equals(name)) {
				return i;
			} // if();
		} // for();
		for (int i = 0; i < gIndex; i++) {
			Gold g = gMembers[i];
			if (g.getName().equals(name)) {
				return i + 10;
			} // if();
		} // for();
		for (int i = 0; i < vIndex; i++) {
			Vip v = vMembers[i];
			if (v.getName().equals(name)) {
				return i + 20;
			} // if();
		} // for();
		return -1;
	}// searchMemberIndex();
	
	public void updateMember() {
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember(name);
		
		
		
		
		if (result==null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			System.out.print("수정할 회원의 등급 입력 : ");
			String grade = sc.next();
			System.out.println("수정할 회원의 포인트 입력 : ");
			int point = sc.nextInt();
			
			String type = result.getType();
			int searchIndex = result.getIndex();
			
		if (type.equals("silver")) {
			for(int i=searchIndex; i<gIndex-1;i++) {
				gMembers[i] = gMembers[i+1];
			}
			gMembers[--gIndex] = null;
		}else if (type.equals("gold") ) {
			for(int i=searchIndex; i<gIndex-1;i++) {
				gMembers[i] = gMembers[i+1];
			}
			gMembers[--gIndex] = null;
		} else if (type.equals("vip")) {
			for(int i=searchIndex; i<gIndex-1;i++) {
				gMembers[i] = gMembers[i+1];
			}
			gMembers[--gIndex] = null;
			}else {		
				System.out.println("회원 등급 설정은 [silver/gold/vip] 로 입력하세요. ");
			}
		switch (grade) {
		case "silver" :
			Silver s = new Silver(grade,name,point);
			sMembers[sIndex++] = s;
			break;
		case "gold" :
			Gold g = new Gold(grade, name, point);
			gMembers[gIndex++] = g;
			break;
		case "vip" :
			Vip v = new Vip(grade, name, point);
			vMembers[vIndex++] = v;
			break;
		}
			}System.out.println("수정완료 !");
		
		
	}//updateMember();
	
	public void deleteMember() {
		System.out.println("\n---------------- 회원 정보 삭제 ----------------");
		System.out.println("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember(name);
		if(result == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			String type = result.getType();
			int searchIndex = result.getIndex();
			
			switch(type) {
			case "silver" :
				for(int i=searchIndex;i<sIndex-1;i++) {
					sMembers[i] = sMembers[i+1];
				}
				sMembers[--sIndex] = null;
				break;
			case "gold" :
				for(int i=searchIndex;i<gIndex-1;i++) {
					gMembers[i] = gMembers[i+1];
				}
				gMembers[--gIndex] = null;
				break;
			case "vip" :
				for(int i=searchIndex;i<vIndex-1;i++) {
					vMembers[i] = vMembers[i+1];
				}
				vMembers[--vIndex] = null;
				break;
			}//switch
			System.out.println("회원 삭제 완료");
		}
	}//deleteMember();
}// class
