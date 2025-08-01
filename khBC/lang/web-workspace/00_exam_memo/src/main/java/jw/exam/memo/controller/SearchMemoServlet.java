package jw.exam.memo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.exam.memo.model.service.MemoService;
import jw.exam.memo.model.vo.Memo;

/**
 * Servlet implementation class SearchMemo
 */
@WebServlet("/searchMemo")
public class SearchMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemoService memoService = new MemoService();
		String memoWriter = request.getParameter("memoWriter");
		ArrayList<Memo> list = memoService.selectMemoByWriter(memoWriter);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/searchMemoList.jsp");
		request.setAttribute("searchMemoList", list);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
