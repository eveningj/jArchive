package kr.co.iei.memo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.iei.memo.model.dao.MemoDao;
import kr.co.iei.memo.model.vo.Memo;

@Service
public class MemoService {
	@Autowired
	private MemoDao memoDao;

	public List selectAllMemo() {
		List list = memoDao.selectAllMemo();
		return list;
	}

	public int insertMemo(Memo m) {
		int result = memoDao.insertMemo(m);
		return result;
	}

	public List searchMemo(String memoWriter) {
		List list = memoDao.searchMemo(memoWriter);
		return list;
	}

	public Memo searchMemoId(String memoId) {
		Memo m = memoDao.searchMemoId(memoId);
		return m;
	}

	public int modifyMemo(Memo m) {
		int result = memoDao.modifyMemo(m);
		return result;
	}

	public int deleteMemo(String memoId) {
		// TODO Auto-generated method stub
		int result = memoDao.deleteMemo(memoId);
		return result;
	}
}
