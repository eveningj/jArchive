package jdbc_exercise_memo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc_exercise_memo.model.vo.Memo;

public class MemoDao {

	public ArrayList<Memo> selectAllMemo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Memo> list = new ArrayList<Memo>();
		String query = "select * from memo_tbl";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Memo m = new Memo();
				m.setMemoId(rset.getInt("memo_id"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getDate("write_date"));
				list.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}// m();

	public ArrayList<Memo> selectMemoByWriter(Connection conn, String writer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Memo> list = new ArrayList<Memo>();
		String query = "select * from memo_tbl where memo_writer = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Memo m = new Memo();
				m.setMemoId(rset.getInt("memo_id"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getDate("write_date"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}//m();

	public int insertMemo(Connection conn, String writer, String memoContent) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "insert into memo_tbl values (memo_seq.nextval, ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			pstmt.setString(2, memoContent);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public Memo selectMemoId(Connection conn, int memoId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Memo m = null;
		String query = "select * from memo_tbl where memo_Id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memoId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Memo();
				m.setMemoId(rset.getInt("memo_id"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getDate("write_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	public int deleteMemo(Connection conn, int memoId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from memo_tbl where memo_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memoId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}//m();
	

	

}
