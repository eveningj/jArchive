package kr.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.model.vo.Silver;

public class PointController {
	Silver[] silver;
	Scanner sc;
	int index;

	public PointController() {
		silver = new Silver[10];
		sc = new Scanner(System.in);
		index = 0;
		
	
		
	}
	
	public void main() {
		while (true) {
			System.out.println("\n---------- 포인트 관리 프로그램 v1 ----------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > > >  ");
			
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				insertSilver();
				break;
			case 2:
				printAllSilver();
				break;
			case 3:
				printOneSilver();
				break;
			case 4:
				updateSilver();
				break;
			case 5: 
				deleteSilver();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
				
				
			}//switch, select.
		}//while, true.
	}//main().
	
	public void insertSilver() {
		System.out.println("\n-------------- 회원 정보 등록 --------------\n");
		System.out.print("등록할 회원 등급 입력 : ");
		String grade = sc.next();
		System.out.print("등록할 회원 이름  입력 : ");
		String name = sc.next();
		System.out.print("등록할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		double bonusPoint = point*0.02; 
		//객체 초기화
		silver[index] = new Silver(grade, name, point,bonusPoint);
		index++;
		System.out.println("회원 정보 등록 완료 !");
	}//insertSilver().
	
	public void printAllSilver() {
		System.out.println("\n-------------- 전체 회원 정보 조회 --------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("-------------------------------- --------------");
		for (int i = 0; i<index ; i ++) {
			Silver s = silver[i];
			String grade = s.getGrade();
			String name = s.getName();
			int point = s.getPoint();
			double bonusPoint = s.getBonusPoint();
			System.out.println(grade+"\t"+name+"\t"+point+'\t'+bonusPoint);
		}//for.
		
	}//printAllSilver().
	
	public int searchSilver(String name) {
		int searchIndex = -1;
		for (int i=0; i<index; i++) {
			Silver s = silver[i];
			String searchName = s.getName();
			if (searchName.equals(name)) {
				searchIndex = i;
				break;
			}//if.
		}//for.
		return searchIndex;
	}//searchSilver
	
	public void printOneSilver() {
		System.out.println("\n-------------- 회원 정보 조회 (1명) --------------\n");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchSilver(name);
		if (searchIndex == -1) {
			System.out.println("회원 정보를 조회할 수 없습니다.");
		}else {
			Silver s = silver[searchIndex];
			System.out.println("회원 등급 : "+s.getGrade());
			System.out.println("회원 이름 : "+s.getName());
			System.out.println("회원 포인트 : "+s.getPoint());
			System.out.println("회원 보너스 : "+s.getBonusPoint());
		}
	} //printOneSilver() 

	public void updateSilver() {
		System.out.println("\n-------------- 회원 정보 수정 --------------\n");
		System.out.print("수정하고 싶은 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchSilver(name);
		if (searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			System.out.print("수정할 회원 등급 입력 : ");
			String grade = sc.next();
			System.out.print("수정할 할 포인트 입력 : ");
			int point = sc.nextInt();
			
			if (grade.equals("silver")) {
			Silver s = silver[searchIndex];
			s.setGrade(grade);
			s.setPoint(point);
			}
			if (grade.equals("gold")) {
				Silver s = silver[searchIndex];
				s.setGrade(grade);
				s.setPoint(point);
				}
			if (grade.equals("vip")) {
				Silver s = silver[searchIndex];
				s.setGrade(grade);
				s.setPoint(point);
				}
			System.out.println("회원 정보 수정 완료!");
		}//else.
		
	}//updateSilver().
	
	public void deleteSilver() {
		System.out.println("\n-------------- 회원 정보 삭제 (1명) --------------\n");
		System.out.print("삭제할 회원 정보 입력 : ");
		String name = sc.next();
		int searchIndex = searchSilver(name);
		if (searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			for(int i = searchIndex; i <index-1; i++) {
				silver[i] = silver[i+1];
			}
			
			silver[--index] = null;
			System.out.println("삭제 완료!");
			//silver[index] = null
			
		}//else.
	}//delteSilver().
}//class .


