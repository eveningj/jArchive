package kr.co.iei.point.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.model.dto.PointDao;
import kr.co.iei.point.model.mo.Gold;
import kr.co.iei.point.model.mo.Grade;
import kr.co.iei.point.model.mo.Silver;
import kr.co.iei.point.model.mo.Vip;

public class PointController {
	Scanner sc;
	PointDao dao;

	public PointController() {
		super();
		sc = new Scanner(System.in);
		dao = new PointDao();
	}

	public void main() {
		while (true) {
			System.out.println("\n------------- 회원 관리 프로그램v6 ------------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선 택 >> ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;

			}
		}
	}

	public void insertMember() {
		System.out.println("\n------------- 회원 정보 등록 ------------\n");
		System.out.print("등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();

		switch (grade) {
		case "silver":
			Grade s = new Silver(grade, name, point);
			dao.insertMember(s);
			break;
		case "gold":
			Grade g = new Gold(grade, name, point);
			dao.insertMember(g);
			break;
		case "vip":
			Grade v = new Vip(grade, name, point);
			dao.insertMember(v);
			break;
		default:
			System.out.println("다시 입력하세요.");
			return;
		}
		System.out.println("회원 정보 등록 완료!!");
	}

	public void printAllMember() {
		System.out.println("\n------------- 전체 회원 조회 ------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		// 보낼 데이터 : Grade
		// 리턴 데이터 : member
		ArrayList<Grade> print = dao.printMembers();
		for (Grade p : print) {
			System.out.println(p.getGrade() + "\t" + p.getName() + "\t" + p.getPoint() + "\t" + p.getBonus());
		}
	}

	public void printOneMember() {
		System.out.println("\n------------- 회원 1명 조회 ---------------\n");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		// 보낼 데이터 : name
		// 리턴 데이터 : Grade

		Grade g = dao.printOneMember(name);
		if(g == null) {
			System.out.println("회원 정보를 찾을수 없습니다.");
		}else {
			System.out.println("회원 등급 : " + g.getGrade());
			System.out.println("회원 이름 : " + g.getName());
			System.out.println("회원 포인트 : " + g.getPoint());
			System.out.println("회원 보너스 : " + g.getBonus());
		}
	}

	public void updateMember() {
		System.out.println("\n------------- 회원 정보 수정 ------------\n");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		// 보낼 데이터 : name
		// 리턴 데이터 : Grade
		int searchIndex = dao.searchMember(name);

		if (searchIndex == -1) {
			System.out.println("수정할 정보가 없습니다.");
		} else {
			System.out.print("수정할 회원 등급 입력 : ");
			String grade = sc.next();
			System.out.print("수정할 회원 포인트 입력 : ");
			int point = sc.nextInt();

			dao.updateMember(grade, name, point, searchIndex);
			System.out.println("수정 완료!!");
		}
	}

	public void deleteMember() {
		System.out.println("\n------------ 회원 정보 삭제 ------------\n");
		System.out.print("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		// 보낼 데이터 : String(name)
		// 리턴 데이터 : 삭제됬는지 아닌지 int(정수형)
		int searchIndex = dao.searchMember(name);
		if (searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			dao.delete(searchIndex);
			System.out.println("삭제 완료!!");
		}
	}

}
