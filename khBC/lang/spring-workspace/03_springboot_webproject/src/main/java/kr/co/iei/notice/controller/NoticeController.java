package kr.co.iei.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.notice.model.service.NoticeService;
import kr.co.iei.notice.model.vo.NoticeListData;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping(value = "/list")
	public String noticeList(int reqPage, Model model) {
		NoticeListData nid = noticeService.selectNoticeList(reqPage);
		model.addAttribute("list", nid.getList());
		model.addAttribute("pageNav", nid.getPageNav());
		return "notice/list";
	}
}
