package jdbc_exercise_memo.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc_exercise_memo.model.dao.MemoDao;
import jdbc_exercise_memo.model.vo.Memo;

public class MemoService {
	MemoDao memoDao;
	
	
	public MemoService() {
		super();
		memoDao = new MemoDao();
	}


	public ArrayList<Memo> selectAllMemo() {
		Connection conn = null;
		ArrayList<Memo> list = new ArrayList<Memo>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","memo","1111");
			list = memoDao.selectAllMemo(conn);
			
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


	public ArrayList<Memo> selectMemoByWriter(String writer) {
		Connection conn = null;
		ArrayList<Memo> list = new ArrayList<Memo>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","memo","1111");
			list = memoDao.selectMemoByWriter(conn, writer);
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
	}//m();


	public int insertMemo(String writer, String memoContent) {
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","memo","1111");
			conn.setAutoCommit(false);
			result = memoDao.insertMemo(conn,writer,memoContent);
			
			if (result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public int deleteMemo(int memoId) {
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","memo","1111");
			Memo m = memoDao.selectMemoId(conn,memoId);
			if (m != null) {
				result = memoDao.deleteMemo(conn,memoId);
				if(result>0) {
					conn.commit();
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
		}
		
		return result;
	}

	
}
