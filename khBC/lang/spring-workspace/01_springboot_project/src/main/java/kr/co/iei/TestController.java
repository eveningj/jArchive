package kr.co.iei;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@GetMapping(value="/request")
	public String request() {
		//3. 비즈니스 로직
		System.out.println("요청 테스트");
		//4. 결과처리(html 파일의 위치를 리턴)
		//리턴한 문자열에 application.properties에 설정한 prefix / suffix 값이 앞 뒤에 붙어서 해당 페이지로 넘어감.
		
		return "test/test1";
	}
	
	@GetMapping(value = "/request2")
	public String request2(String str, int num) {
		//1. 인코딩	: Spring Boot 는 기본적으로 UTF-8 인코딩을 수행하기 때문에 작업 X
		
		//2. 값추출	: 데이터 전송시 키값을 변수명으로 매개변수를 선언하면 데이터를 넣어줌 
		
		//Method 의 매개변수로 request 를 선언한 후 사용 : 
		/*String str = request.getParameter("str");
		int num = Integer.parseInt(request.getParameter("num"));*/
		
		//3. 비즈니스로직
		System.out.println("str :" + str);
		System.out.println("num :" + num);
		//4. 결과처리
		return "test/test1";
	}
	
	@PostMapping(value = "/plus")
	public String plus(int num1, int num2, Model model) {
		//3. 비즈니스 로직
		int result = num1 + num2;
		//4. 결과처리
		// 화면에서 사용할 데이터 등록 : request.setAttribute(key, value);
		//-> Spring 에서는 Model 객체 사용
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		model.addAttribute("result",result);
		return "test/plus";
	}
	
	@GetMapping(value = "/thymeTest1")
	public String test1(Model model) {
		model.addAttribute("str", "안녕");
		model.addAttribute("num1", 100);
		model.addAttribute("num2", 200);
		
		return "test/thyme1";
	}
	
	@GetMapping(value = "/thymeTest2")
	public String test2(Model model) {
		Student s1 = new Student ("학생1", 30, "서울시 영등포구");
		Student s2 = new Student ("학생2", 20, "서울시 동작구");
		Student s3 = new Student ("학생3", 25, "서울시 강남구");
		
		model.addAttribute("s1",s1);
		model.addAttribute("s2",s2);
		model.addAttribute("s3",s3);
		return "test/thyme2";
	}
	
	@GetMapping(value = "/thymeTest3")
	public String test3(Model model) {
		//기본형 리스트
		List list1 = new ArrayList<Integer>();
		list1.add(100);
		list1.add(200);
		
		//객체 리스트
		List list2 = new ArrayList<Student>();
		Student s1 = new Student ("학생1", 30, "서울시 영등포구");
		Student s2 = new Student ("학생2", 20, "서울시 동작구");
		Student s3 = new Student ("학생3", 25, "서울시 강남구");
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		
		return "test/thyme3";
	}
}
