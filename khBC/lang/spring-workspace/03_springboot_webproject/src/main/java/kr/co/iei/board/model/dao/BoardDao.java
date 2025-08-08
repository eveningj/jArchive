package kr.co.iei.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.board.model.vo.Board;
import kr.co.iei.board.model.vo.BoardFile;

@Mapper
public interface BoardDao {

	int selectBoardTotalCount();

	List selectBoardList(HashMap<String, Object> param);

	int getBoardNo();

	int insertBoard(Board b);

	int insertBoardFile(BoardFile boardFile);

	Board selectOneBoard(int boardNo);

	List selectBoardFile(int boardNo);

	BoardFile selectOneBoardFile(int boardFileNo);
	
}
