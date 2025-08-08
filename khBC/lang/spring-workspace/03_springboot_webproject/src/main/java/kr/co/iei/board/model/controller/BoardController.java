package kr.co.iei.board.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import kr.co.iei.board.model.service.BoardService;
import kr.co.iei.board.model.vo.Board;
import kr.co.iei.board.model.vo.BoardFile;
import kr.co.iei.board.model.vo.BoardListData;
import kr.co.iei.util.FileUtil;


@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private FileUtil fileUtil;
	
	
	@Value("${file.root}")
	private String root;
	
	@GetMapping(value = "/list")
	public String boardList (int reqPage, Model model) {
		BoardListData bld = boardService.selectBoardList(reqPage);
		model.addAttribute("list",bld.getList());
		model.addAttribute("pageNav",bld.getPageNav());
		return "board/list";
	}
	
	@GetMapping(value = "/writeFrm")
	public String writeFrm () {
		return "board/writeFrm";
	}
	
	@PostMapping(value = "/write")
	public String write (Board b, MultipartFile[] upfile, Model model) {
		//1. FILE
		List<BoardFile> fileList = new ArrayList<BoardFile>();
		if(!upfile[0].isEmpty()) {
			String savepath = root + "/board/";
			for(MultipartFile file : upfile) {
				String filename = file.getOriginalFilename();
				String filepath = fileUtil.upload(savepath, file);
				BoardFile boardFile = new BoardFile();
				boardFile.setFileName(filename);
				boardFile.setFilePath(filepath);
				fileList.add(boardFile);
			}
		}
		//file, end.
			
		int result = boardService.insertBoardFile(b,fileList);
		
		model.addAttribute("title", "완료");
		model.addAttribute("text", "완벽하게 작성했어요!");
		model.addAttribute("icon", "success");
		model.addAttribute("loc", "/board/list?reqPage=1");
		return "common/msg";
	}//write()
	
	@GetMapping(value = "/view")
	public String boardView (int boardNo, Model model) {
		Board b = boardService.selectOneBoard(boardNo);
		if (b == null) {
			model.addAttribute("title", "게시글 조회 실패");
			model.addAttribute("text", "이미 삭제된 게시글 입니다");
			model.addAttribute("icon", "info");
			model.addAttribute("loc", "/board/list?reqPage=1");
			return "common/msg";
		}else {
			model.addAttribute("b", b);
			return "board/view";
		}
	}//view
	
	@GetMapping(value = "/filedown")
	public void filedown(int boardFileNo, HttpServletResponse response) {
		BoardFile boardFile = boardService.selectOneBoardFile(boardFileNo);
		String savepath = root + "/board/";
		
		fileUtil.downloadFile(savepath, boardFile.getFilePath(), boardFile.getFileName(), response);
	}
	
}
