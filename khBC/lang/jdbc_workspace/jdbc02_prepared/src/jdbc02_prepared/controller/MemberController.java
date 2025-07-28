package jdbc02_prepared.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc02_prepared.model.vo.Member;

public class MemberController {
	Scanner sc;

	public MemberController() {
		super();
		sc = new Scanner(System.in);
	}

	public void main() {
		while (true) {
			System.out.println("\n----------- 회원 관리 프로그램 v2 ----------");
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
		}
	}// main();

	public void selectMemberId() {
		// 1. DB -> O
		// 2. QUERY = SELECT * FROM MEMBER_TBL FROM WHERE MEMBER_ID = ' ';
		// 3. INPUT : ID

		System.out.println("\n---------- 아이디로 회원 조회 ----------\n");
		System.out.print("조회할 회원 아이디 입력 : ");
		String memberId = sc.next();

		// 0-1 . RETURN OBJECT
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		// -> 쿼리문을 수행하고 결과를 받아오는 객체 (Statement -> PreparedStatement)
		ResultSet rset = null;

		// 0-2 . RESULT VARIABLE
		Member m = null;

		// 0-3 . QUERY
//		String query = "select * from member_tbl where member_id '"+memberId+"'";

//		PreparedStatement에서는 쿼리문에서 변수로 대체되어야하는 부분을 ?로 표시함.
		String query = "select * from member_tbl where member_id = ?";
		// ? -> Placeholder -> SQL Token, SQL 구문이 실행되기 전에 값으로 대체 됨.
		// -> 실행 시점에 값을 대체되지 않은 상태로 실행하면 에러 발생함.
		// -> LITERAL 대체함.
		// -> 값에 대한 부분만 대체가 가능함. (TABLE NAME, COLUMN NAME, OPERATOR, ETC 등 불가능.)
		// -> PLACEHOLER 에 어떤 값이 들어가더라도 쿼리문 문법에는 변화가 없어야함 -> 쿼리의 구조변경은 불가능.

		try {
			// 1.DRIVER
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. CONNECTION
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			// (3). STATEMENT
//			stmt = conn.createStatement();
			// 3. PREPARED STATEMENT
			pstmt = conn.prepareStatement(query);
			// PLACEHOLER 에 INPUT 하기 전 생성.
			// -> 객체 생성할 때 쿼리문을 전달하면서 생성 (위치홀더인 상태의 쿼리)
			// 3-1. PREPARED STATEMENT 가 받은 쿼리는 PLACEHOLER 가 들어간 QUERY -> 실행 전에 값으로 대체함.
			pstmt.setString(1, memberId); // 첫번쨰 PLACEHOLER 자리를 MEMBERID 값으로 대체함.
			// 모든 PLACEHOLDER 를 값으로 대체된 후 실행

			// 4. QUERY 실행 후 결과 받아옴.
			// 5. 받아온 결과 저장
//			rset = stmt.executeQuery(query);
			rset = pstmt.executeQuery();
			// -> query 문이 parameter 에 들어가지 않음 -> 이미 pstmt 에서 쿼리문이 준비되어 있음.

			// -> 쿼리 실행 시 param 으로 쿼리 전송 X
			// -> PSTMT 객체 생성시 PLACEHOLDER 로 작성된 쿼리 전송됨.
			// -> PLACEHOLER 에 들어갈 VALUE PSTMT 에 메소드를 이용해 처리함.
			// -> VALUE 로 대체된 QUERY 는 PSTMT 만 알고있음. -> 이미 완성된 쿼리 실행함.

			if (rset.next()) {
				m = new Member();
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (m == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			System.out.println("아이디 :" + m.getMemberId());
			System.out.println("비밀번호 :" + m.getMemberPw());
			System.out.println("이름 :" + m.getMemberName());
			System.out.println("전화번호 :" + m.getMemberPhone());
			System.out.println("나이 :" + m.getMemberAge());
			System.out.println("성별 :" + m.getMemberGender());
			System.out.println("회원 가입일 :" + m.getEnrollDate());
		}
	}// selectMemberId();

	public void selectAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> list = new ArrayList<Member>();

		String query = "select * from member_tbl";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));
				list.add(m);
				/*
				 * m.setMemberId(rset.getString(1)); m.setMeberPw(rset.getString(2)); . . .
				 */
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (list.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.");
		} else {
			System.out.println("아이디\t패스워드\t이름\t연락처\t\t나이\t성별\t회원가입일");
			for (Member m : list) {
				System.out.println(
						m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t" + m.getMemberPhone()
								+ "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t" + m.getEnrollDate());
			}
		} // else
	}// selectAllMember();

	public void selectMemberName() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> list = new ArrayList<Member>();
		System.out.print("검색할 회원 이름 입력 : ");
		String searchName = sc.next();
		String query = "select * from member_tbl where member_name like ?"; // " '%'||?||'%' "

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchName + "%");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));
				list.add(m);
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
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally
		if (list.isEmpty()) {
			System.out.println("해당 이름을 가진 회원은 없습니다.");
		} else {
			System.out.println("아이디\t패스워드\t이름\t연락처\t\t나이\t성별\t회원가입일");
			for (Member m : list) {
				System.out.println(
						m.getMemberId() + "\t" + m.getMemberPw() + "\t" + m.getMemberName() + "\t" + m.getMemberPhone()
								+ "\t" + m.getMemberAge() + "\t" + m.getMemberGender() + "\t" + m.getEnrollDate());
			}
		} // else
	}// selectMemberName

	public void insertMember() {
		// INPUT : ID, PW, NAME, CONTACT, AGE, GENDER
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.println("아이디 입력 : ");
		String memberId = sc.next();
		System.out.println("비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.println("이름 입력 : ");
		String memberName = sc.next();
		System.out.println("연락처 입력 (010-0000-0000) : ");
		String memberPhone = sc.next();
		System.out.println("나이 입력 : ");
		int memberAge = sc.nextInt();
		System.out.println("성별 입력 : ");
		String memberGender = sc.next();

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into member_tbl values(?,?,?,?,?,?,sysdate)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberName);
			pstmt.setString(4, memberPhone);
			pstmt.setInt(5, memberAge);
			pstmt.setString(6, memberGender);
			result = pstmt.executeUpdate();

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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result > 0) {
			System.out.println("등록 됨");
		} else {
			System.out.println("등록 안됨");
		}
	}// insert();

	public void deleteMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		System.out.println("삭제할 회원 아이디 입력 : ");
		String searchId = sc.next();
		//
		String query = "select * from member_tbl where member_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc_user", "1234");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				query = "delete from member_tbl where member_id = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, searchId);
				result = pstmt.executeUpdate();

				if (result > 0) {
					conn.commit();
				} else {
					conn.rollback();
				}
			}else {
				System.out.println("그런 회원 없음");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}// delete();

	public void updateMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		Member m = null;
		
		System.out.println("수정할 회원 아이디 입력 : ");
		String searchId = sc.next();
		//
		String query = "select * from member_tbl where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("수정 후의 회원 비밀번호 입력 : ");
				String updatePw = sc.next();
				System.out.println("수정 후의 회원 연락처 입력 : ");
				String updatePhone = sc.next();
				query = "update member_tbl set member_pw = ? , member_phone = ? where member_id = ? ";
				pstmt = conn.prepareStatement(query);
				int i = 1;
				pstmt.setString(i++, updatePw);
				pstmt.setString(i++, updatePhone);
				pstmt.setString(i++, searchId);
						
				result = pstmt.executeUpdate();
				
					if(result>0) {
						conn.commit();
					}else {
						conn.rollback();
					}
			}else {
				System.out.println("그런 회원 없음");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}// update();

}
