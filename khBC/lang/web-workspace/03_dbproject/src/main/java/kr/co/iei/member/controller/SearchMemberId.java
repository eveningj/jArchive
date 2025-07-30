package kr.co.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.member.model.service.MemberService;
import kr.co.iei.member.model.vo.Member;

/**
 * Servlet implementation class SearchMemberId
 */
@WebServlet("/searchMemberId")
public class SearchMemberId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberService();
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		Member m = memberService.searchMemberId(memberId);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>아이디로 회원조회</title></head>");
		out.println("<body>");
		out.println("<h1>아이디로 회원조회</h1><hr>");
		
		if (m == null) {
			out.println("<h3>회원정보 조회 실패! (그런 회원 없음)</h2>");
		}else {
			out.println("<span>회원번호 : " + m.getMemberNo()+  "</span><br>");
			out.println("<span>회원아이디 : " + m.getMemberId()+  "</span><br>");
			out.println("<span>회원비밀번호: " + m.getMemberPw()+  "</span><br>");
			out.println("<span>회원이름: " + m.getMemberName()+  "</span><br>");
			out.println("<span>회원전화번호: " + m.getMemberPhone()+  "</span><br>");
			out.println("<span>회원주소: " + m.getMemberAddr()+  "</span><br>");
			
			switch (m.getMemberLevel()) {
				case 1 : out.println("<span>회원등급 :" + "관리자" + "</span><br>");
				break;
				case 2 : out.println("<span>회원등급 : " + "정회원" + "</span><br>");
				break;
				case 3 : out.println("<span>회원등급 : " + "준회원" + "</span><br>");
				break;
				}
			out.println("<span>회원가입일: " + m.getEnrollDate()+  "</span><br>");
					
			}
		out.println("<a href='/'>메인페이지로 이동</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
