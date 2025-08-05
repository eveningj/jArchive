package kr.co.iei.memo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.memo.model.vo.Memo;

@Mapper
public interface MemoDao {

	List selectAllMemo();

	int insertMemo(Memo m);

	List searchMemo(String memoWriter);

	Memo searchMemoId(String memoId);

	int modifyMemo(Memo m);

	int deleteMemo(String memoId);

}
