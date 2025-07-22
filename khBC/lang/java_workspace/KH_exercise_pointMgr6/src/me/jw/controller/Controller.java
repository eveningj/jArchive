package me.jw.controller;

import java.util.ArrayList;
import java.util.Scanner;

import me.jw.model.dao.PointDAO;
import me.jw.model.vo.Grade;

public class Controller {
	Scanner sc;
	PointDAO dao;

	public Controller() {
		super();
		sc = new Scanner(System.in);
		dao = new PointDAO();
	}

	public void main() {
		while (true) {
			System.out.println("\n===== 쇼핑몰 포인트 v6 =====\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 정보 출력");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print(" 선 택 > > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertMember();
				break;
			case 2:
				printAllMembers();
				break;
			case 3:
				printMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			}
		}
	}

	public void insertMember() {
		System.out.println("\n===== 회원 정보 등록 =====\n");
		System.out.print("등록할 회원의 등급 : ");
		String grade = sc.next();
		System.out.print("등록할 회원의 이름 : ");
		String name = sc.next();
		System.out.print("등록할 회원의 포인트 : ");
		int point = sc.nextInt();
		if (dao.insertMember(grade, name, point)) {
			System.out.println("회원 등록을 완료하였습니다.");
		} else {
			System.out.println("회원 등록에 실패하였습니다, 올바른 입력을 해주세요. 등급 [silver/gold/vip]");
		}
	}

	public void printAllMembers() {
		ArrayList<Grade> members = dao.selectAllMembers();
		if (members.isEmpty()) {
			System.out.println("등록되어 있는 회원이 없습니다.");
		} else {
			System.out.println("\n===== 전체 회원 출력 =====\n");
			System.out.println("등급\t이름\t포인트\t보너스");
			for (Grade g : members) {
				System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
			}
		}
	}

	public void printMember() {
		System.out.println("조회할 회원의 이름을 입력하세요 : ");
		String name = sc.next();

		Grade g = dao.searchMember(name);
		if (g == null) {
			System.out.println("그런 이름의 회원은 없습니다. 메뉴로 돌아갑니다.");
		} else {
			System.out.println("등급 : " + g.getGrade());
			System.out.println("이름 : " + g.getName());
			System.out.println("포인트 : " + g.getPoint());
			System.out.println("보너스 : " + g.getBonus());
		}
	}

	public void deleteMember() {
		System.out.println("\n===== 회원 정보 삭제 =====\n");
		System.out.print("삭제할 회원의 이름을 입력하세요 : ");
		String name = sc.next();

		Grade g = dao.searchMember(name);
		if (dao.searchMember(name) == null) {
			System.out.println("그런 이름의 회원은 없습니다.");
		} else {
			if (dao.deleteMember(g)) {
				System.out.println("삭제 하였습니다");
			} else {
				System.out.println("삭제에 실패하였습니다.");
			}
		}
	}

	public void updateMember() {
		System.out.println("\n====== 회원 정보 수정 =====\n");
		System.out.println("수정하고싶은 회원의 이름을 입력하세요 : ");
		String name = sc.next();

		Grade g = dao.searchMember(name);
		if (g==null) {
			System.out.println("그런 이름의 회원은 없습니다. ");
		}else {
			dao.deleteMember(g);
		
		System.out.println("어떤 등급으로 수정하시겠습니까? : ");
		String nGrade = sc.next();
		System.out.println("어떤 이름으로 수정하시겠습니까? : ");
		String nName = sc.next();
		System.out.println("수정할 포인트 : ");
		int nPoint = sc.nextInt();

		if (dao.insertMember(nGrade, nName, nPoint)) {
			System.out.println("수정이 완료되었습니다");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
		}

	}

}
