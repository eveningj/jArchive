package kr.co.iei.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.Student;
import kr.co.iei.member.model.service.MemberService;
import kr.co.iei.member.model.vo.Member;
	
	

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired // 스프링이 서버 시작시 생성한 객체들 중 일치하는 타입의 객체 주소를 넣어둠.
	private MemberService memberService;
	//컨트롤러가 필요한 경우 -> @Controller Annotation 이 작성되어 있는 클래스에 메소드 하나 생성
	//Method 는 리턴타입이 String
	
	//@PostMapping
	//@RequestMapping -> get post 구분 하지 않고 처리 -> 권고사항 아님.
	@GetMapping(value= "/allMember")
	public String allMember(Model model) {
		//3. 비즈니스 로직
		List list = memberService.selectAllMember();
		model.addAttribute("list",list);
		return "member/allMember";
	}
	
	@GetMapping(value = "/thymeTest4")
	public String test4(Model model) {
		model.addAttribute("data1",101);
		model.addAttribute("data2","test");
		Student s = new Student ("학생1", 20, "서울");
		model.addAttribute("s",s);
		return "test/thyme4";
	}
	
	@GetMapping(value = "/thymeTest5")
	public String test5(Model model) {
		model.addAttribute("num",500);
		return "test/thyme5";
	}
	
	@GetMapping(value = "/thymeTest6")
	public String test6(Model model) {
		List list1 = new ArrayList<Integer>();
		list1.add(100);
		list1.add(200);
		list1.add(300);
		list1.add(400);
		list1.add(500);
		//Object LIst
		Student s1 = new Student ("학생1",20,"서울시 영등포구");
		Student s2 = new Student ("학생2",30,"서울시 동작구");
		Student s3 = new Student ("학생3",25,"서울시 강남구");
		List list2 = new ArrayList<Integer>();
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		return "test/thyme6";
	}
	
	@GetMapping(value = "/joinFrm")
	public String joinFrm() {
		
		return "member/joinFrm";
	}
	
	@PostMapping(value = "/join")
	public String join(Member m) {
		System.out.println(m);
		int result = memberService.insertMember(m);
		//회원가입 성공하면 -> 전체회원 조회 페이지로 이동 -> 다른 컨트롤러 호출하는 방법
		return "redirect:/member/allMember";
		//회원가입 실패하면 ->
	}
	
	@GetMapping(value = "/searchIdFrm")
	public String searchIdFrm() {
		return "member/searchIdFrm";
	}
	
	@GetMapping(value = "/searchId")
	public String searchId(String memberId, Model model) {
		Member m = memberService.searchId(memberId);
		if (m == null) {
			return "member/searchFail";
		}else {
			model.addAttribute("m",m);
			return "member/searchSuccess";
		}
		//return "member/searchId";
	}
}
