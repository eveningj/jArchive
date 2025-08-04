package kr.co.iei.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.iei.member.model.service.MemberService;
import kr.co.iei.member.model.vo.Member;
	
	

@Controller
public class MemberController {
	
	@Autowired // 스프링이 서버 시작시 생성한 객체들 중 일치하는 타입의 객체 주소를 넣어둠.
	private MemberService memberService;
	//컨트롤러가 필요한 경우 -> @Controller Annotation 이 작성되어 있는 클래스에 메소드 하나 생성
	//Method 는 리턴타입이 String
	
	//@PostMapping
	//@RequestMapping -> get post 구분 하지 않고 처리 -> 권고사항 아님.
	@GetMapping(value= "/allMember")
	public String allMember() {
		//3. 비즈니스 로직
		List list = memberService.selectAllMember();
		System.out.println(list);
		return null;
	}

}
