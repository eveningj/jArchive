package jw.exam.memo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.exam.memo.model.service.MemoService;
import jw.exam.memo.model.vo.Memo;

/**
 * Servlet implementation class DeleteMemoServlet
 */
@WebServlet("/deleteMemo")
public class DeleteMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemoServlet() {
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
		int memoId = Integer.parseInt(request.getParameter("memoId"));
		int result = memoService.deleteMemo(memoId);
		if(result>0) {
			response.sendRedirect("/memoList");
		}else {
			response.sendRedirect("/deleteFail");
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
