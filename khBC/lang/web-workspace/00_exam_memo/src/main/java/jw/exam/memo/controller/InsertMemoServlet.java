package jw.exam.memo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.exam.memo.model.service.MemoService;
import jw.exam.memo.model.vo.Memo;

/**
 * Servlet implementation class InsertMemoServlet
 */
@WebServlet("/insertMemo")
public class InsertMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemoService memoService = new MemoService();
		Memo m = new Memo();
		m.setMemoTitle(request.getParameter("memoTitle"));
		m.setMemoWriter(request.getParameter("memoWriter"));
		m.setMemoContent(request.getParameter("memoContent"));
		int result = memoService.insertMemo(m);
		if (result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/memoSuccess.jsp");
			request.setAttribute("insertMemo", result);
			view.forward(request, response);
		} else {
			response.sendRedirect("/insertFail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
