package jdbc03_prepared_dao.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc03_prepared_dao.model.dao.MemberDao;
import jdbc03_prepared_dao.model.vo.Member;

public class MemberController {
	Scanner sc;
	MemberDao memberDao;

	public MemberController() {
		super();
		sc = new Scanner(System.in);
		memberDao = new MemberDao();
	}

	public void main() {
		while (true) {
			System.out.println("\n----------- 회원 관리 프로그램 v3 ----------");
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
	}// main()

	public void selectMemberId() {
		// 1. DB 작업 필요한지 ?
		// 2. QUERY : SELECT * FROM MEMBER_TBL FROM MEMBER_ID=?
		// 3. 입력받을 정보 : 아이디

		System.out.println("\n----------- 아이디로 회원 조회 ----------\n");
		System.out.print("조회할 회원 아이디 입력 : ");
		String memberId = sc.next();

		// DB접속해서 필요한 DB작업 수행하고 결과 받아옴.
		// -> DB 관련 작업은 CONTROLLER 가 하지 않고 DAO 가 처리함.

		// 쿼리문 수행에 필요한 데이터 (controller -> DAO 로 데이터 전송 -> 메소드의 매개변수)
		// 쿼리문의 결과 (DAO -> CONTROLLER 로 데이터 전송 -> METHOD 의 RETURN)

		// CONTROLLER 가 알아야하는 건 결과의 자료형

		Member m = memberDao.selectMemberId(memberId);
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
	}// selectMemberId();

	public void insertMember() {
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.print("입력 할 회원 아이디 : ");
		String memberId = sc.next();
		System.out.print("입력 할 회원 비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("입력 할 회원 이름 : ");
		String memberName = sc.next();
		System.out.print("입력 할 회원 전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("입력 할 회원 나이 : ");
		int memberAge = sc.nextInt();
		System.out.print("입력 할 회원 성별 : ");
		String memberGender = sc.next();

		// CONTROLLER -> DAO : COLUMN
		// DAO -> CONTROLLER : INT
		Member m = new Member(memberId, memberPw, memberName, memberPhone, memberAge, memberGender, null);
		int result = memberDao.insertMember(m);
		if (result > 0) {
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
	}// insertMember();

	public void selectAllMember() {
		System.out.println("\n----------- 회원 정보 출력 ----------\n");
		ArrayList<Member> list = new ArrayList<Member>();
		list = memberDao.selectAllMember();
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
	}

	public void selectMemberName() {
		System.out.println("\n---------- 이름으로 회원 조회 ----------\n");
		System.out.println("조회할 이름 입력 : ");
		String searchName = sc.next();
		ArrayList<Member> list = new ArrayList<Member>();
		list = memberDao.selectMemberName(searchName);
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
	}

	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.println("수정할 아이디 입력 : ");
		String searchId = sc.next();

		if (memberDao.selectMemberId(searchId) == null) {
			System.out.println("없어");
		} else {
			System.out.println("수정할 비밀번호 입력 : ");
			String memberPw = sc.next();
			System.out.println("수정할 연락처 입력 : ");
			String memberPhone = sc.next();

			int result = memberDao.updateMember(searchId, memberPw, memberPhone);

			if (result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		}
	}// method();

	public void deleteMember() {
		//삭제 로직 : member_tbl (delete)
		//	-> select * from member_tbl where member_id = ?
		// 	->	delete from member_tbl where member_id = ?
		//->	del_member_tbl (insert)
		//-> insert into del_member_tbl values(?,?,?,sysdate)
		
		//입력 받을 정보 1개 -> id, (이름, 전화번호는 DB에서 조회해서 처리)
		
		
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.println("삭제할 아이디 입력 :");
		String searchId = sc.next();
		Member m = memberDao.selectMemberId(searchId);
		if (m == null) {
			System.out.println("없어");
		} else {
			int result = memberDao.deleteMember(searchId);
			if (result > 0) {
				int result2 = memberDao.insertDelMember(m);
				if(result2>0) {
					System.out.println("진정한 삭제 성공이니라");
				}else {
					System.out.println("del_member_tbl 에서 insert 실패");
				}
			} else {
				System.out.println("MEMBER_TBL 에서 삭제 실패");
			}
		}
	}// method();
}// class{};
