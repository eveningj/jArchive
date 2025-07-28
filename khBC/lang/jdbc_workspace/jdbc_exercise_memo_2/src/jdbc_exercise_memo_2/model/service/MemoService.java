package jdbc_exercise_memo_2.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc_exercise_memo_2.common.JDBCTemplate;
import jdbc_exercise_memo_2.model.dao.MemoDao;
import jdbc_exercise_memo_2.model.vo.Memo;


public class MemoService {

	MemoDao memoDao;
	
	public MemoService() {
		super();
		memoDao = new MemoDao();
	}

	public ArrayList<Memo> selectAllMemo() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Memo> list = new ArrayList<Memo>();
		list = memoDao.selectAllMemo(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Memo> selectMemoByWriter(String writer) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Memo> list = new ArrayList<Memo>();
		list = memoDao.selectMemoByWriter(conn, writer);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertMemo(String writer, String memoContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = memoDao.insertMemo(conn, writer, memoContent);
		if (result >0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMemo(int memoId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		Memo m = memoDao.selectMemoId(conn,memoId);
		if (m != null) {
		result = memoDao.deleteMemo(conn,memoId);
		if (result > 0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);;
		}
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMemo(int memoId,String memoContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		Memo m = memoDao.selectMemoId(conn,memoId);
		if (m != null) {
			result = memoDao.updateMemo(conn,memoId,memoContent);
			if (result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}
		return result;
	}

}
