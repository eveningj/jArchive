package kr.co.iei.member.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.member.model.vo.Member;

public class MemberController {
	Scanner sc;

	public MemberController() {
		super();
		sc = new Scanner(System.in);
	}

	public void main() {
		while (true) {
			System.out.println("\n---------- 회원 관리 프로그램 v1 ----------");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 아이디로 회원 조회"); // 입력받은 아이디와 일치하는 회원을 조회
			System.out.println("3. 이름으로 회원 조회"); // 입력받은 이름이 포함된 회원 모두 조회 // LIKE
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				selectAllMember(); // R
				break;
			case 2:
				selectMemberId(); // R
				break;
			case 3:
				selectMemberName(); // R
				break;
			case 4:
				insertMember(); // C
				break;
			case 5:
				updateMember(); // U
				break;
			case 6:
				deleteMember(); // D
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}// switch();
		} // while();
	}// main();

	// 전체 회원 정보를 DB에서 조회해서 출력하는 메소드
	public void selectAllMember() {
		// 1. 이 메소드 구현시 DB 작업이 필요한지 -> O
		// 2. 이 메소드 구현을 위해 필요한 쿼리 -> select * from member_tbl (; 빼서 작성.)
		// 3. 2번에서 작성 쿼리를 완성하기 위해 사용자가 입력해야 할 데이터가 있는지 체크 -> X
		// -> 사용자가 입력해야 할 데이터가 있으면 데이터 입력을 먼저받아야 함.
		// 4. DB 작업 시작

		// 4-1. DB 작업을 수행하고 나면 어떤 타입 데이터 (JAVA 기준) 가 최종적으로 필요한지
		// -> 전체 회원 조회 -> 회원정보 여러 개 -> 가장 적게 나올 때 / 가장 많이 나올 때 모두를 처리할 자료형
		// 회원 1명 -> Member TYPE
		// 회원 여러 명 -> Member[] -> ArrayList<Member>

		// 0-1. 반환할 객체 미리 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // 이 객체는 수행할 쿼리가 select 인 경우에만 선언

		// 0-2. 쿼리문 수행 결과를 처리할 변수 선언
		// 변수 초기 값은 쿼리 수행 결과가 실패했을 떄의 값
		ArrayList<Member> list = new ArrayList<Member>(); // 조회 결과가 없으면 비어있는 list

		// 0-3. 쿼리문을 문자열 형식으로 저장 : 쿼리문 작성시 세미콜론(;)은 반드시 제거 (있으면 에러)
		String query = "select * from member_tbl";

		try {
			// 1. 드라이버 등록 (데이터베이스와 연결할 때 사용할 클래스 등록 -> ojdbc6.jar 이 포함된 클래스)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			// 3. Statement 객체 생성 (쿼리문을 DB에 전달해서 수행하고, 수행 결과를 받아오는 객체)
			stmt = conn.createStatement();
			// 4. 쿼리문 수행하고 결과 받아옴
			// 5. 수행 결과를 받아서 저장.
			rset = stmt.executeQuery(query);
			// select 쿼리의 수행결과를 rset 에 저장
			// ResultSet 은 DB의 select 수행 결과를 처리하기 위한 객체
			// 최종적으로 우리가 사용할 형태인 ArrayList<Member> 타입으로 데이터 편집
			// ResultSet 은 내부에 커서라는 객체, 커서를 통해서 데이터에 접근
			// rset.next() -> 커서를 아래로 한 줄 내림. //Data 가 있으면 true/ 없으면 false 리턴

			while (rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberPhone = rset.getString("member_phone");
				int memberAge = rset.getInt("member_age");
				char memberGender = rset.getString("member_gender").charAt(0);
				Date enrollDate = rset.getDate("enroll_date");

				Member m = new Member(memberId, memberPw, memberName, memberPhone, memberAge, memberGender, enrollDate);
				list.add(m);
			} // while();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 6. 자원반환 코드
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n---------- 전체 회원 정보 ----------\n");
		System.out.println("아이디\t비밀번호\t이름\t전화번호\t\t나이\t성별\t회원가입일");
		for (Member m : list) {
			System.out.println(
					m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t" + m.getMemberPhone()
							+ "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t" + m.getEnrollDate());
		}

//		 for(int i=0; i<list.size(); i++) {
//			 Member m = list.get(i);
//		 }
	}// selectAllMember();

	public void selectMemberId() {
		// 1. 메소드 구현을 위해서 DB 작업 필요한지 -> O
		// 2. Query : select * from member_tbl where member_id='사용자입력아이디'
		// 3. Query 완성을 위해 사용자에게 받아야 할 정보가 있는지 -> String name = sc.nextLine();
		// 필요한 데이터 입력받기
		System.out.println("\n---------- 아이디로 회원 조회 ----------\n");
		System.out.println("조회할 회원 아이디 입력 : ");
		String searchId = sc.next();
		// 4. DB 작업 수행 -> 결과를 어떤 타입으로 처리할 지
		// 회원정보 조회 -> Member -> 조건절이 member_id 와 일치하는 회원
		// -> 일치하는 회원은 0 or 1 -> member_id 는 primary key 이므로 중복값 없음.
		// -> Member type 으로 사용

		// 0-1. 반환할 객체 미리 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		// 0-2. 결과 처리할 변수 선언
		Member m = null; // 조회 실패값으로 초기값 세팅
		// 0-3. 문자열로 query 작성
		String query = "select * from member_tbl where member_id='" + searchId + "'";

		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			// 3. Statement 객체 생성
			stmt = conn.createStatement();
			// 4. 쿼리문 수행하고 결과 받아옴
			// 5. 받아온 결과 저장
			rset = stmt.executeQuery(query);

			// 조건 절이 member_id 와 일치하는 데이터 조회 -> 0 row or 1row 중 하나
			// 커서를 내려서 확인하는 행위를 1번만 수행하면 됨.
			if (rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberPhone = rset.getString("member_phone");
				int memberAge = rset.getInt("member_age");
				char memberGender = rset.getString("member_gender").charAt(0);
				Date enrollDate = rset.getDate("enroll_date");

				m = new Member(memberId, memberPw, memberName, memberPhone, memberAge, memberGender, enrollDate);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (m == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			System.out.println("아이디 : " + m.getMemberId());
			System.out.println("비밀번호 : " + m.getMemberPw());
			System.out.println("이름 : " + m.getMemberName());
			System.out.println("연락처 : " + m.getMemberPhone());
			System.out.println("나이 : " + m.getMemberAge());
			System.out.println("성별 : " + m.getMemberGender());
			System.out.println("회원가입일 : " + m.getEnrollDate());
		}

	}// selectMemberId();

	public void selectMemberName() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		ArrayList<Member> list = new ArrayList<Member>();
		System.out.print("검색할 이름 입력 : ");
		String searchName = sc.next();

		String query = "select * from member_tbl where member_name LIKE '%" + searchName + "%'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				Member m = new Member();
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberGender(rset.getString("member_gender").charAt(0));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));
				list.add(m);
			} // while();
			if (list.isEmpty()) {
				System.out.println("회원 정보가 없습니다.");
			} else {

				System.out.println("\n---------- 회원 정보 ----------\n");
				System.out.println("아이디\t비밀번호\t이름\t전화번호\t\t나이\t성별\t회원가입일");
				for (Member m : list) {
					System.out.println(m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t"
							+ m.getMemberPhone() + "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t"
							+ m.getEnrollDate());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// selectMemberName

	public void insertMember() {
		// 1. DB 작업 필요한지 -> O
		// 2. QUERY -> insert into member_tbl values ('id','pw','name', 'phone', age,
		// 'gender',sysdate)
		// 입력받아야하는 정보 :
		// id, pw, name, contact, age, gender
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		System.out.print("연락처 입력 (ex.010-0000-0000) : ");
		String memberPhone = sc.next();
		System.out.print("나이 입력 :");
		int memberAge = sc.nextInt();
		System.out.print("성별 입력 (남/여) : ");
		char memberGender = sc.next().charAt(0);

		// 0-1. 반환할 객체 선언
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rset = null --> select 의 결과를 저장하는 객체 -> insert/update/delete 에는 사용하지 않음.
		// 0-2. 결과를 처리할 변수 선언
		// insert/update/delete 의 쿼리 수행 결과는 해당 쿼리로 인해 변경된 행의 수를 리턴 -> 정수로 처리
		int result = 0; // 반영된 행의 수가 0이면 변경사항이 없음 -> 쿼리 실패
		// 0-3. 쿼리 작성
		String query = "insert into member_tbl values(" + "'" + memberId + "'," + "'" + memberPw + "'," + "'"
				+ memberName + "'," + "'" + memberPhone + "'," + memberAge + "," + "'" + memberGender + "',"
				+ "sysdate)";
		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			// 3. statement 객체 생성
			stmt = conn.createStatement();
			// 4. query 수행 후 return.
			// 쿼리를 수행하고 결과를 받아오는 메소드가 select 와 다름.
			// insert/update/delete 인 경우 : executeUpdate() 로 처리

			// 5. 받은 결과 저장 (쿼리로 인해 변경된 행의 수)
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원 반환
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result > 0) {
			System.out.println("회원 정보 등록 성공");
		} else {
			System.out.println("회원 정보 등록 실패");
		}
	}// insertMember();

	public void deleteMember() {
		System.out.print("삭제 하고자하는 아이디 입력 : ");
		String searchId = sc.next();
		int result = 0;
		Connection conn = null;

		Statement stmt = null;

		String query = "delete from member_tbl where member_ID = '" + searchId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 에러가 나지 않으면, auto commit 기능이 활성화됨. -> 쿼리 한 줄 끝나면 auto commit 됨.
			// 쿼리가 정상적으로 수행되면 자동으로 commit -> transaction 을 우리가 원하는 대로 처리할 수 없음.
			// -> auto commit 기능 비활성화.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result > 0) {
			System.out.println("회원 정보 삭제 성공");
		} else {
			System.out.println("회원 정보 삭제 실패");
		}
	}

	public void updateMembertest() {
		System.out.println("수정하고자 하는 아이디 입력 : ");
		String searchId = sc.next();
		int result = 0;

		Connection conn = null;
		Statement stmt = null;

		System.out.println("수정되는 비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.println("수정되는 이름 입력 : ");
		String memberName = sc.next();
		System.out.println("수정되는 연락처 입력 : ");
		String memberPhone = sc.next();
		System.out.println("수정되는 나이 입력 : ");
		int memberAge = sc.nextInt();
		System.out.println("수정되는 성별 입력 : ");
		char memberGender = sc.next().charAt(0);

		String query = "update member_tbl set " + "member_pw = '" + memberPw + "'," + "member_name = '" + memberName
				+ "'," + "member_phone = '" + memberPhone + "'," + "member_age = " + memberAge + ","
				+ "member_gender = '" + memberGender + "'" + "where member_id = '" + searchId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (result > 0) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("수정 실패하였습니다.");
		}

	}// updateMembertest();

	public void updateMember() {
		// 비밀번호와 전화번호 변경
		// 1. DB -> O
		// 2. QUERY :
		// UPDATE MEMBER_TBL SET MEMBER_PW = ' ', MEMBER_PHONE = ' '
		// WHERE MEMBER_ID = ' '

		// 3. 입력받아야 할 정보 : PW, PHONE, ID

		System.out.println("\n--------- 회원 정보 수정 -----------\n");
		System.out.println("수정할 회원 아이디 입력 : ");
		String memberId = sc.next();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // update 에는 필요가 없지만 존재하는 체크할 때 select 를 해야하므로.
		// 아이디를 체크하는 쿼리
		/*
		 * select * from member_tbl where member_id = '아이디' select member_id from
		 * member_tbl where member_id = '아이디' select count(*) from member_tbl where
		 * member_id = '아이디' / 0, 1 로 boolean Check
		 * 
		 */
		String query = "select count(*) as cnt from member_tbl where member_id = '" + memberId + "'";

		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			rset.next();
			result = rset.getInt("cnt");
			if (result == 1) {
				System.out.println("수정할 비밀번호 입력 : ");
				String memberPw = sc.next();
				System.out.println("수정할 전화번호 입력 : ");
				String memberPhone = sc.next();

				query = "update member_tbl set " + "member_pw = '" + memberPw + "', " + "member_phone = '" + memberPhone
						+ "' " + "where member_id = '" + memberId + "'";

				result = stmt.executeUpdate(query);
				if (result > 0) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(result>0) {
			System.out.println("정보 변경 성공");
		}else {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}
	}// updateMember

}
