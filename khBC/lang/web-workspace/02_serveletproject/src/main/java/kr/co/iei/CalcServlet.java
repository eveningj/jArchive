package kr.co.iei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setCharacterEncoding("utf-8");
		// 1. 파라미터 수신
				String su1Str = request.getParameter("su1");
				String su2Str = request.getParameter("su2");
				String oper = request.getParameter("oper");

				// 2. 데이터 파싱 및 연산
				int su1 = Integer.parseInt(su1Str);
				int su2 = Integer.parseInt(su2Str);
				int result = 0;
				boolean valid = true;

				switch (oper) {
					case "+":
						result = su1 + su2;
						break;
					case "-":
						result = su1 - su2;
						break;
					case "*":
						result = su1 * su2;
						break;
					case "/":
						if (su2 != 0) {
							result = su1 / su2;
						} else {
							valid = false;
						}
						break;
					default:
						valid = false;
				}

				// 3. 응답 처리
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();

				out.println("<!DOCTYPE html>");
				out.println("<html><head><title>계산 결과</title></head>");
				out.println("<body>");
				out.println("<h1>계산기 결과</h1>");
				out.println("<hr>");
				if (valid) {
					out.println("<h3>" + su1 + " " + oper + " " + su2 + " = " + result + "</h3>");
				} else {
					out.println("<h3><span style = 'color : red;'> 잘못된 입력입니다. (0으로 나누기 또는 연산자 오류)</span></h3>");
				}
				out.println("<a href='/YourProjectName'>처음으로</a>");
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
