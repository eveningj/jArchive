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
 * Servlet implementation class GetMemoServlet
 */
@WebServlet("/getMemo")
public class GetMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemoService memoService = new MemoService();
		int memoId = Integer.parseInt(request.getParameter("memoId"));
		Memo m = memoService.selectMemoId(memoId);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/getMemo.jsp");
		request.setAttribute("getMemo", m);
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
