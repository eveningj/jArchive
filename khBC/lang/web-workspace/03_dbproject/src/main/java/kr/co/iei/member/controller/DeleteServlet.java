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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteMember")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>아이디로 회원조회</title></head>");
		out.println("<body>");
		out.println("<h1>회원 삭제</h1><hr>");
		int result = memberService.deletehMember(memberId);
		if(result>0) {
			out.println("<h3>회원삭제 완료!</h3>");
			out.println("<hr>");
		}else {
			out.println("<h3>회원삭제 실패..</h3>");
			out.println("<hr>");
		}
		out.println("<a href='/'>메인페이지로 이동</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
