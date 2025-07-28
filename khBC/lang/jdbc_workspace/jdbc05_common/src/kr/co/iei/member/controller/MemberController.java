package kr.co.iei.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.member.model.service.MemberService;
import kr.co.iei.member.model.vo.Member;

public class MemberController {
	Scanner sc;
	MemberService service;

	public MemberController() {
		super();
		sc = new Scanner(System.in);
		service = new MemberService();
	}

	public void main() {
		while (true) {
			System.out.println("\n----------- 회원 관리 프로그램 v5 ----------");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 아이디로 회원 조회");
			System.out.println("3. 이름으로 회원 조회");
			System.out.println("4. 회원 정보 등록");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료 ");
			System.out.print("선 택 > > > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				selectAllMember();
				break;
			case 2:
				selectMemberId();
				break;
			case 3:
				selectMemberName();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.println("종료.");
				return;
			default:
				System.out.println("잘못된 입력.");
				break;
			}// switch
		} // while
	}// main();

	public void selectAllMember() {
		System.out.println("\n----------- 전체 회원 조회 ----------\n");
		ArrayList<Member> list = service.selectAllMember();
		if (list.isEmpty()) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.println("아이디\t비밀번호\t이름\t연락처\t\t나이\t성별\t회원가입일");
			for (Member m : list) {
				System.out.println(
						m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t" + m.getMemberPhone()
								+ "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t" + m.getEnrollDate());
			}
		}
	}// m();

	public void selectMemberId() {
		System.out.println("\n---------- 아이디로 회원 조회 ----------\n");
		System.out.println("조회할 회원 아이디 입력 : ");
		String memberId = sc.next();
		Member m = service.selectMemberId(memberId);

		if (m == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			System.out.println("아이디 : " + m.getMemberId());
			System.out.println("비밀번호 : " + m.getMemberPw());
			System.out.println("이름 : " + m.getMemberName());
			System.out.println("전화번호 : " + m.getMemberPhone());
			System.out.println("나이 : " + m.getMemberAge());
			System.out.println("성별 : " + m.getMemberGender());
			System.out.println("회원 가입일 : " + m.getEnrollDate());
		}
	}// m();

	public void selectMemberName() {
		System.out.println("\n---------- 이름으로 회원 조회 ----------\n");
		System.out.println("조회할 회원 이름 입력 : ");
		String memberName = sc.next();

		ArrayList<Member> list = service.selectMemberName(memberName);
		if (list.isEmpty()) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.println("아이디\t비밀번호\t이름\t연락처\t\t나이\t성별\t회원가입일");
			for (Member m : list) {
				System.out.println(
						m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t" + m.getMemberPhone()
								+ "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t" + m.getEnrollDate());
			}
		}
	}// m();
	
	public void insertMember() {
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		Member m = new Member();
		while(true) {
		System.out.print("입력 할 회원 아이디 : ");
		String memberId = sc.next();
		Member member = service.selectMemberId(memberId);
		if (member == null) {
			m.setMemberId(memberId);
			break;
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
		}
		System.out.print("입력 할 회원 비밀번호 : ");
		String memberPw = sc.next();
		m.setMemberPw(memberPw);
		System.out.print("입력 할 회원 이름 : ");
		m.setMemberName(sc.next());
		System.out.print("입력 할 회원 전화번호 : ");
		m.setMemberPhone(sc.next());
		System.out.print("입력 할 회원 나이 : ");
		m.setMemberAge(sc.nextInt());
		System.out.print("입력 할 회원 성별 : ");
		m.setMemberGender(sc.next());

		int result = service.insertMember(m);
		if (result > 0) {
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
	}
	
	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.println("수정할 아이디 입력 : ");
		String searchId = sc.next();
		Member m = service.selectMemberId(searchId); 
		if (m == null) {
			System.out.println("그런 아이디 없어");
		} else {
			System.out.println("수정할 비밀번호 입력 : ");
			String memberPw = sc.next();
			System.out.println("수정할 연락처 입력 : ");
			String memberPhone = sc.next();

			int result = service.updateMember(searchId, memberPw, memberPhone);

			if (result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
	}
	}//m();
	
	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.println("삭제할 아이디 입력 :");
		String searchId = sc.next();
		
		int result = service.deleteMember(searchId);
		
		if(result == 2) {
			System.out.println("삭제 성공");
		}else if (result == 1) {
			System.out.println("insert 실패");
		}else if (result == 0) {
			System.out.println("delete 실패");
		}else if (result == -1) {
			System.out.println("회원정보 못 찾음");
		}
	}//m();
}
