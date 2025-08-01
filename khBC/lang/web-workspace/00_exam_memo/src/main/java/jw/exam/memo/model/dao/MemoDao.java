package jw.exam.memo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jw.exam.common.JDBCTemplate;
import jw.exam.memo.model.vo.Memo;

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
				m.setMemoTitle(rset.getString("memo_title"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getString("write_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}//m();

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
				m.setMemoTitle(rset.getString("memo_title"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getString("write_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}

	public int insertMemo(Connection conn, Memo m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into memo_tbl values (memo_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemoTitle());
			pstmt.setString(2, m.getMemoContent());
			pstmt.setString(3, m.getMemoWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Memo selectMemoId(Connection conn, int memoId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from memo_tbl where memo_Id = ?";
		Memo m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memoId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Memo();
				m.setMemoId(rset.getInt("memo_id"));
				m.setMemoTitle(rset.getString("memo_title"));
				m.setMemoContent(rset.getString("memo_content"));
				m.setMemoWriter(rset.getString("memo_writer"));
				m.setWriteDate(rset.getString("write_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return m;
	}//m();

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
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateMemo(Connection conn, Memo m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update memo_tbl set memo_title = ?, memo_content = ? where memo_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemoTitle());
			pstmt.setString(2, m.getMemoContent());
			pstmt.setInt(3, m.getMemoId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}

