package kr.co.iei.notice.controller;

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
import kr.co.iei.notice.model.service.NoticeService;
import kr.co.iei.notice.model.vo.Notice;
import kr.co.iei.notice.model.vo.NoticeFile;
import kr.co.iei.notice.model.vo.NoticeListData;
import kr.co.iei.util.FileUtil;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@Value("${file.root}")
	private String root;//application.properties 에 설정되어 있는 file.root 의 값을 가지고 와서 문자열로 저장함.
	
	@Autowired
	private FileUtil fileUtil;
	
	@GetMapping(value = "/list")
	public String noticeList(int reqPage, Model model) {
		NoticeListData nid = noticeService.selectNoticeList(reqPage);
		model.addAttribute("list", nid.getList());
		model.addAttribute("pageNav", nid.getPageNav());
		return "notice/list";
	}
	
	@GetMapping(value = "/writeFrm")
	public String noticeWriteFrm() {
		return "notice/writeFrm";
	}
	
	@PostMapping(value = "/write")
	public String noticeWrite(Notice n, MultipartFile[] upfile, Model model) {
		//input type = text 에 아무것도 입력하지 않고 전송하면 null 이 아니라 빈 문자열 ("")
		//input type = file 에 아무것도 첨부하지 않고 전송하면 배열 길이는 0이 아니라 1. 첫번째 파일이 비어있음.
		
		//첨부파일은 서버에 업로드를 진행, 업로드된 결과 (업로드한 파일명)을 DB에 저장
		// 첨부파일은 여러개 있을 수 있으므로 반복문으로 처리
		List<NoticeFile> fileList = new ArrayList<NoticeFile>();
		//첨부파일이 없으면 첫번째 파일이 비어있음. -> 첨부파일이 있을 때만 데이터 처리함.
		if(!upfile[0].isEmpty()) {
			//실제 파일이 업로드 될 폴더 설정
			String savepath = root + "/notice/";
			System.out.println(savepath);
			for(MultipartFile file : upfile) {
				//사용자가 업로드한 파일의 원본 이름
				String filename = file.getOriginalFilename();
				String filepath = fileUtil.upload(savepath, file);
				//파일을 업로드 할 위치와 파일 객체를 주면서 업로드 요청
				// -> 파일명이 겹쳤을 때 중복처리를 해 업로드 수행
				// -> 중복처리가 된 파일명을 리턴 (DB에 insert 해야 하므로)
				NoticeFile noticeFile = new NoticeFile();
				noticeFile.setFilename(filename);
				noticeFile.setFilepath(filepath);
				fileList.add(noticeFile);
			}
		}
		int result = noticeService.insertNotice(n,fileList);
		model.addAttribute("title", "DONE");
		model.addAttribute("text", "공지사항 썼음.");
		model.addAttribute("icon", "success");
		model.addAttribute("loc", "/notice/list?reqPage=1");
		return "common/msg";
	}
	
		@GetMapping(value = "/view")
		public String noticeView(int noticeNo, Model model) {
			Notice n = noticeService.selectOneNotice(noticeNo);
			if(n == null) {
				model.addAttribute("title", "게시글 조회 실패");
				model.addAttribute("text", "이미 삭제된 게시글 입니다");
				model.addAttribute("icon", "info");
				model.addAttribute("loc", "/notice/list?reqPage=1");
				return "common/msg";
			}else {
				model.addAttribute("n",n);
				return "notice/view";
			}
		}//
		
		@GetMapping(value = "/filedown")
		public void filedown(int noticeFileNo, HttpServletResponse response) {
			NoticeFile noticeFile = noticeService.selectOneNoticeFile(noticeFileNo);
			String savepath = root + "/notice/";
			//download 에 필요한 객체를 downloadFile 메소드에 전달
			//1. 다운로드할 파일이 저장됭 있는 폴더 위치
			//2. 실제 저장된 파일 이름
			//3. 원본 파일 이름
			//4. 응답객체 (파일 다운로드를 진행할 객체)
			fileUtil.downloadFile(savepath, noticeFile.getFilepath(), noticeFile.getFilename(), response);
		}
}
