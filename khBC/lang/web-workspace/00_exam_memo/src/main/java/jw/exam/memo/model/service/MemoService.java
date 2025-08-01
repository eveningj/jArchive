package jw.exam.memo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jw.exam.common.JDBCTemplate;
import jw.exam.memo.model.dao.MemoDao;
import jw.exam.memo.model.vo.Memo;

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

	public int insertMemo(Memo m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = memoDao.insertMemo(conn, m);
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

	public int updateMemo(Memo m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
			result = memoDao.updateMemo(conn,m);
			if (result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		return result;
	}

	public Memo selectMemoId(int memoId) {
		Connection conn = JDBCTemplate.getConnection();
		Memo m = new Memo();
		m = memoDao.selectMemoId(conn, memoId);
		JDBCTemplate.close(conn);
		return m;
	}
	
}