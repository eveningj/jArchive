package kr.co.iei.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.memo.model.service.MemoService;
import kr.co.iei.memo.model.vo.Memo;

@Controller
@RequestMapping(value = "/memo")
public class MemoController {

	@Autowired
	MemoService memoService;
	
	@GetMapping(value = "/memoList")
	public String allMemo (Model model) {
		List list = memoService.selectAllMemo();
		model.addAttribute("list", list);
		return "memo/memoList";
	}
	
	
	@GetMapping(value = "/insertMemoFrm")
	public String insertMemoFrm () {
		return "memo/insertMemoFrm";
	}
	
	@PostMapping(value = "/insertMemo")
	public String insertMemo (Memo m) {
		int result = memoService.insertMemo(m);
		if (result>0) {
			return "redirect:/memo/memoList";
		}else {
			return "redirect:/memo/insertFail";
		}
	}
	
	@GetMapping(value = "/insertFail")
	public String insertFail () {
		return "memo/insertFail";
	}
	
	@GetMapping(value = "/searchMemo")
	public String searchMemo(String memoWriter, Model model) {
		List list = memoService.searchMemo(memoWriter);
		model.addAttribute("list",list);
		return "memo/searchWriter";
	}
	
	@GetMapping(value = "/searchMemoId")
	public String searchMemoId(String memoId, Model model) {
		Memo m = memoService.searchMemoId(memoId);
		model.addAttribute("memo",m);
		if ( m == null) {
			return "redirect:/memo/searchIdFail";
		}else {
			return "memo/searchId";
		}
	}
	
	@GetMapping(value = "/modifyFrm")
	public String modifyFrm(String memoId, Model model) {
		Memo m = memoService.searchMemoId(memoId);
		model.addAttribute("memo",m);
		return "memo/modifyFrm";
	}
	
	@PostMapping(value = "/modifyMemo")
	public String modifyMemo(Memo m, Model model) {
		int result = memoService.modifyMemo(m);
		if (result>0) {
			return "redirect:/memo/searchMemoId?memoId=" + m.getMemoId();
		}else {
			return "redirect:/memo/modifyFail";
		}
	}
	
	@GetMapping(value = "/deleteMemo")
	public String deleteMemo(String memoId, Model model) {
		int result = memoService.deleteMemo(memoId);
		List list = memoService.selectAllMemo();
		model.addAttribute("list", list);
		if(result>0) {
			return "memo/memoList";
		}else {
			return "redirect:/memo/deleteFail";
		}
	}
	
	@GetMapping(value = "/modifyFail")
	public String modifyFail () {
		return "memo/modifyFail";
	}
	
	@GetMapping(value = "/deleteFail")
	public String deleteFail () {
		return "memo/deleteFail";
	}
	
	@GetMapping(value = "/searchIdFail")
	public String searchIdFail () {
		return "memo/searchIdFail";
	}
}
