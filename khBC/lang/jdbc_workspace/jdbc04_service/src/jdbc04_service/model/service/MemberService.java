package jdbc04_service.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc04_service.model.dao.MemberDao;
import jdbc04_service.model.vo.Member;

public class MemberService {
	MemberDao memberDao;

	public MemberService() {
		super();
		memberDao = new MemberDao();
	}

	public ArrayList<Member> selectAllMember() {
		//0-1. OBJECT
		Connection conn = null;
		//0-2. VARIABLE (RETURN)
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			//1. DRIVER
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.CONNECTION
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			//3.TRANSFER CONNECTION -> DAO (PARAM)
			list = memberDao.selectAllmember(conn);
			//DB 작업이 다 끝났는지 체크
			//ADDITIONAL DB PROCESS -> CONN 재사용. 재수행.
			//END DB PROCESS -> COMMIT, ROLLBACK CHECK
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Member selectMemberId(String memberId) {
		Connection conn = null;
		Member m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			m = memberDao.selectMemberId(conn, memberId);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}//m();

	public ArrayList<Member> selectMemberName(String searchName) {
		Connection conn = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			list = memberDao.selectMemberName(conn, searchName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			conn.setAutoCommit(false);
			result = memberDao.insertMember(conn, m);
			
			if (result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(String searchId, String memberPw, String memberPhone) {
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			conn.setAutoCommit(false);;
			result = memberDao.updateMember(conn, memberPw, memberPhone, searchId);
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}//m();

	public int deleteMember(String searchId) {
		Connection conn = null;
		int result =  0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc_user","1234");
			conn.setAutoCommit(false);
			Member m = memberDao.selectMemberId(conn, searchId);
			
			if (m != null) {
				result = memberDao.deleteMember(conn,searchId);
				//DB 작업이 추가로 있는지? -> 삭제에 성공했으면 추가 작업 있고 / 삭제 실패했으면 없음
				if (result>0) {
					result = memberDao.insertDelMember(conn, m);
					if(result> 0) {
						conn.commit();
					}else {
						conn.rollback();
					}
				}else {
					conn.rollback();
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}


	
	
}
