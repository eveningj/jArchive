package kr.co.iei.point.controller.java;

import java.util.Scanner;

import kr.co.iei.point.model.vo.Gold;
import kr.co.iei.point.model.vo.Grade;
import kr.co.iei.point.model.vo.Silver;
import kr.co.iei.point.model.vo.Vip;
import kr.co.iei.point.model.vo.Vvip;

public class PointController {
	// 사용할 등급은 Silver,Gold,Vip 객체
	// Silver, Gold, Vip 는 모두 Grade 클래스를 상속해서 만든 클래스
	// 다형성을 이용하면 Silver 객체, Gold 객체, Vip 객체를 모두 Grade 타입으로 저장이 가능
	// Grade 배열을 생성하면 Silver,Gold,Vip 모두를 저장할 수 있는 배열이 됨
	Grade[] members;
	Scanner sc;
	int index;

	public PointController() {
		super();
		members = new Grade[30];
		sc = new Scanner(System.in);
		index = 0;

		Silver s1 = new Silver("Silver", "회원1", 1000);
		Grade grade = (Grade) s1;
		members[index++] = grade;
		Grade grade2 = new Silver("silver", "회원2", 2000);
		members[index++] = grade2;
		members[index++] = new Gold("gold", "회원3", 1000);
		members[index++] = new Gold("gold", "회원4", 2000);
		members[index++] = new Vip("vip", "회원5", 1000);
		members[index++] = new Vip("vip", "회원6", 2000);
		members[index++] = new Vvip("vvip", "회원7", 1000);
		members[index++] = new Vvip("vvip", "회원8", 2000);
	}

	public void main() {
		while (true) {
			System.out.println("\n----------회원 관리 프로그램v3------------\n");
			System.out.println("1. 회원 정보 등록 ");
			System.out.println("2. 전체 회원 출력");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertMember();
				break;
			case 2:
				printIneMembers();
				break;
			case 3:
				printOneMembers();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	public void insertMember() {
		System.out.println("\n------회원 정보 등록---------\n");
		System.out.print("등록 할 회원 등급[silver/gold/vip/vvip] : ");
		String grade = sc.next();
		System.out.print("등록 할 회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch (grade) {
		case "silver":
			Silver silver = new Silver(grade, name, point);
			Grade gra = (Grade) silver; // 업캐스팅(자료형을 상위 자료형 형태로 저장 -> 다형성)
			members[index] = gra;
			index++;
			break;
		case "gold":
			Gold gold = new Gold(grade, name, point);
			Grade gra1 = gold; // 업캐스팅은 강제형변환을 하지 않아도 상속조건만 맞으면 자동으로 변환)
			members[index] = gra1;
			index++;
			break;
		case "vip":
			members[index] = new Vip(grade, name, point);
			index++;
			break;
		case "vvip":
			members[index] = new Vvip(grade, name, point);
			index++;
			break;
		}
		System.out.println("회원 정보 등록 완료!");
	}

	public void printIneMembers() {
		System.out.println("\n------전체 회원 출력------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		for (int i = 0; i < index; i++) {
			// members는 grade[]배열 -> members에서 하나를 꺼내면 Grade타입
			// Grade는 객체생성을 못하고 내부에서 Silver or Gold ot Vip 객체가 들어있는 상황
			// 꺼낸 데이터를 다운캐스팅해야하는 경우 -> Grade에는 존재하지 않고 자식에게만 존재하는 메소드를 사용해야하는경우
			Grade g = members[i];
			System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
		}
	}

	public void printOneMembers() {
		System.out.println("\n-------회원 1명 출력--------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if (searchIndex == -1) {
			System.out.println("조회한 회원이 없습니다.");
		} else {
			Grade g = members[searchIndex];
			System.out.println("회원 등급 : " + g.getGrade());
			System.out.println("회원 이름 : " + g.getName());
			System.out.println("회원 포인트 : " + g.getPoint());
			System.out.println("회원 보너스 : " + g.getBonus());
		}

	}

	public void updateMember() {
		System.out.println("\n--------회원 정보 수정---------\n");
		System.out.print("수정 할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("수정 할 회원 이름이 없습니다.");
		}else {
			System.out.print("수정 할 회원 등급[silver/gold/vip/vvip] : ");
			String grade = sc.next();
			System.out.print("수정 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			
			switch(grade) {
			case "silver":
				members[searchIndex] = new Silver(grade, name, point);
				break;
			case "gold":
				members[searchIndex] = new Gold(grade, name, point);
				break;
			case "vip":
				members[searchIndex] = new Vip(grade, name, point);
				break;
			}
			System.out.println("정보 수정 완료");
		}
		
	}

	public void deleteMember() {
		System.out.println("\n--------회원 정보 삭제---------\n");
		System.out.print("삭제 할 회원 이름 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if (searchIndex == -1) {
			System.out.println("삭제 할 회원 이름이 업습니다.");
		} else {
			for (int i = searchIndex; i < index -1 ; i++) {
				members[i] = members[i + 1];
			}
			members[--index] = null;
			System.out.println("회원 삭제 완료");
		}
	}

	public int searchMember(String name) {
		for (int i = 0; i < index; i++) {
			Grade g = members[i];
			if (g.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
