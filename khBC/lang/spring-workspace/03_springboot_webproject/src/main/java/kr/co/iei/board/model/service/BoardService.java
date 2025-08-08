package kr.co.iei.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.board.model.dao.BoardDao;
import kr.co.iei.board.model.vo.Board;
import kr.co.iei.board.model.vo.BoardFile;
import kr.co.iei.board.model.vo.BoardListData;
import kr.co.iei.notice.model.vo.NoticeFile;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardListData selectBoardList(int reqPage) {
		//LIMIT
		//QUERY 1
		int limit = 20;
		int offset = (reqPage-1) * limit;
		
		int end = reqPage * limit;
		int start = end - limit + 1;
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("end", end);
		
		//QUERY 2
		int totalCount = boardDao.selectBoardTotalCount();
		int totalPage = (int)Math.ceil((double)totalCount/limit);
		
		//NAV
		int pageNavSize = 10;
		
		//NAV - PAGE NO.
		int pageNo = ((reqPage-1)/pageNavSize)*pageNavSize + 1;
		
		//NAV - HTML
		String pageNav = "<ul class = 'pagination circle-style'>";
			//PREV BUTTON
		if(pageNo != 1) {
			pageNav += "<li>";
			pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+(pageNo-1)+"'>";
			pageNav += "<span class = 'material-icons'>chevron_left</span>";
			pageNav += "</a>";
			pageNav += "</li>";
		}
			//PAGINATION
		for (int i = 0; i<pageNavSize; i++) {
			pageNav += "<li style = 'width : 100px;'>";
			if(pageNo == reqPage) {
				pageNav += "<a class = 'page-item active-page' href = '/notice/list?reqPage="+pageNo+"'>";
			}else {
				pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+pageNo+"'>";
			}
			pageNav += pageNo;
			pageNav += "</a>";
			pageNav += "</li>";
			pageNo++;
			//LAST PAGE
			if(pageNo > totalPage)	{
				break;
			}
		}// pagination end.
			//NEXT BUTTON
		if(pageNo <= totalPage)	{
			pageNav += "<li>";
			pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+pageNo+"'>";
			pageNav += "<span class = 'material-icons'>chevron_right</span>";
			pageNav += "</a>";
			pageNav += "</li>";
		}
		pageNav += "</ul>";
		
		List list = boardDao.selectBoardList(param);
		
		BoardListData bld = new BoardListData(list, pageNav); 
		
		return bld;
	}

	@Transactional
	public int insertBoardFile(Board b, List<BoardFile> fileList) {
		//SEQUENCE
		int newBoardNo = boardDao.getBoardNo();
		b.setBoardNo(newBoardNo);
		
		//QUERY 1
		int result = boardDao.insertBoard(b);
		
		//FILE DEPENDENCY (NO)
		for (BoardFile boardFile : fileList) {
			boardFile.setBoardNo(newBoardNo);
			//QUERY 2 (BOARDFILE TBL)s
			result += boardDao.insertBoardFile(boardFile);
		}
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		Board b = boardDao.selectOneBoard(boardNo);
		//FILE
		if (b != null) {
			List fileList = boardDao.selectBoardFile(boardNo);
			b.setFileList(fileList);
		}
		return b;
	}

	public BoardFile selectOneBoardFile(int boardFileNo) {
		BoardFile boardFile = boardDao.selectOneBoardFile(boardFileNo);
		return boardFile;
	}

}
