package kr.co.iei.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.member.model.service.MemberService;
import kr.co.iei.member.model.vo.Member;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/allMember")
	public String allMember(Model model) {
		List list = memberService.selectAllMember();
		model.addAttribute("list",list);
		return "admin/allMember";
	}
	
	@GetMapping(value = "/changeLevel")
	public String changeLevel(Member m) {
		int result = memberService.changeLevel(m);
		return "redirect:/admin/allMember";
	}
	
	@GetMapping(value = "checkedChangeLevel")
	public String checkedChangeLevel(String no, String level) {
		boolean result = memberService.checkedChangeLevel(no,level);
		return "redirect:/admin/allMember";
	}
}
